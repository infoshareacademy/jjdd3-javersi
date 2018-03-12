package servlets;

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

    @Inject
    ChargingPointDao chargingPointDao;

    @Inject
    DataFilter dataFilter;

    @Inject
    CoordinatesConverter coordinatesConverter;

    @Inject
    ChargingPointToDtoConverterBean chargingPointToDtoConverterBean;

    public static final Logger LOG = LoggerFactory.getLogger(FindTheClosestServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("title", "Find the closest charging point");

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
            dataModel.put("body_template", "results");
            dataModel.put("chargingPoints", chargingPointsDtoList);
        }

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            LOG.error("Template problem occurred.");
        }
    }
}
