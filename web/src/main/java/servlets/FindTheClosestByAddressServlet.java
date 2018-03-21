package servlets;

import cdi.AddressToCoordinatesBean;
import cdi.ChargingPointToDtoConverterBean;
import controller.CoordinatesConverter;
import controller.DataFilter;
import dao.ChargingPointDao;
import dto.ChargingPointDto;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.ChargingPoint;
import model.Coordinates;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/find-the-closest-by-address")
public class FindTheClosestByAddressServlet extends HttpServlet {

    @Inject
    private ChargingPointDao chargingPointDao;

    @Inject
    private DataFilter dataFilter;

    @Inject
    private ChargingPointToDtoConverterBean chargingPointToDtoConverterBean;

    @Inject
    private AddressToCoordinatesBean addressToCoordinatesBean;

    public static final Logger LOG = LoggerFactory.getLogger(FindTheClosestByAddressServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOG.info("User searched closest charging station by address");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("title", "Find the closest charging point by address");

        String address = req.getParameter("address");


        if (address == null || address.isEmpty()) {
            dataModel.put("body_template", "find-the-closest-by-address");

        } else {
            Coordinates coordinates = addressToCoordinatesBean.getCoordinates(address);
            if (coordinates != null) {
                double longitude = coordinates.getLongitude();
                double latitude = coordinates.getLatitude();
                List<ChargingPoint> chargingPointsList = new ArrayList<>();
                ChargingPoint chargingPoint = dataFilter
                        .findClosestChargingStation(chargingPointDao.findAll(), longitude,
                                latitude);
                chargingPointsList.add(chargingPoint);
                List<ChargingPointDto> chargingPointsDtoList = chargingPointToDtoConverterBean.convertList(chargingPointsList);
                dataModel.put("points-map", "results");
                dataModel.put("body_template", "results");
                dataModel.put("chargingPoints", chargingPointsDtoList);
            } else {
                resp.sendError(500, "Wrong Google Api Key");
            }
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
