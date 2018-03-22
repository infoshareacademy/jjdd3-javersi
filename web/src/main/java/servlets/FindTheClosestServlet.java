package servlets;

import cdi.AppPropertiesBean;
import cdi.ChargingPointToDtoConverterBean;
import controller.CoordinatesConverter;
import controller.DataFilter;
import dao.ChargingPointDao;
import dto.ChargingPointDto;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.ChargingPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/find-the-closest")
public class FindTheClosestServlet extends HttpServlet {
    public static final Logger LOG = LoggerFactory.getLogger(FindTheClosestInRadiusServlet.class);


    @Inject
    private ChargingPointDao chargingPointDao;

    @Inject
    private DataFilter dataFilter;

    @Inject
    private CoordinatesConverter coordinatesConverter;

    @Inject
    private ChargingPointToDtoConverterBean chargingPointToDtoConverterBean;

    @Inject
    private AppPropertiesBean appPropertiesBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOG.info("User searched closest charging station");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("title", "Find the closest charging point");

        String userSessionName = (String) req.getSession().getAttribute("user_name");
        dataModel.put("userSessionName", userSessionName);

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        String directionLong = req.getParameter("directionLong");
        String degreesLong = req.getParameter("degreesLong");
        String minutesLong = req.getParameter("minutesLong");
        String secondLong = req.getParameter("secondLong");
        String directionLati = req.getParameter("directionLati");
        String degreesLati = req.getParameter("degreesLati");
        String minutesLati = req.getParameter("minutesLati");
        String secondLati = req.getParameter("secondLati");

        if (degreesLong == null || degreesLong.isEmpty() || minutesLong == null || minutesLong.isEmpty()) {
            dataModel.put("body_template", "find-the-closest");

        } else {
            double longitude = coordinatesConverter.convertCoordinatesToDecimal(directionLong, degreesLong, minutesLong, secondLong);
            double latitude = coordinatesConverter.convertCoordinatesToDecimal(directionLati, degreesLati, minutesLati, secondLati);
            List<ChargingPoint> chargingPointsList = new ArrayList<>();
            ChargingPoint chargingPoint = dataFilter
                    .findClosestChargingStation(chargingPointDao.findAll(), longitude,
                            latitude);
            chargingPointsList.add(chargingPoint);
            List<ChargingPointDto> chargingPointsDtoList = chargingPointToDtoConverterBean.convertList(chargingPointsList);
            dataModel.put("points-map", "results");
            dataModel.put("body_template", "results");
            dataModel.put("chargingPoints", chargingPointsDtoList);
            dataModel.put("google_api_key", appPropertiesBean.getGoogleApiKey());
        }
        resp.setContentType("text/html;charset=UTF-8");

        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            LOG.error("Template problem occurred.");
        }
    }

    private void errorMessages(Map<String, Object> dataModel) {
        dataModel.put("body_template", "find-the-closest");
        dataModel.put("title", "Find the closest charging point");
        dataModel.put("error", "Please fill the form with correct value");
    }

    private boolean isStringInRange(String value, int min, int max) {
        Double coordinateDouble = Double.valueOf(value);
        return coordinateDouble >= min && coordinateDouble <= max;
    }


}
