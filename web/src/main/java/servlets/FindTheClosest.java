package servlets;

import controller.CoordinatesConverter;
import controller.DataFilter;
import dao.ChargingPointDao;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.ChargingPoint;

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
public class FindTheClosest extends HttpServlet{

    @Inject
    ChargingPointDao chargingPointDao;
    @Inject
    DataFilter dataFilter;
    @Inject
    CoordinatesConverter coordinatesConverter;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> dataModel = new HashMap<>();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        String degreesLong = req.getParameter("degreesLong");
        String minutesLong = req.getParameter("minutesLong");
        String secondLong = req.getParameter("secondLong");
        String degreesLati = req.getParameter("degreesLati");
        String minutesLati = req.getParameter("minutesLati");
        String secondLati = req.getParameter("secondLati");
        String radius = req.getParameter("radius");




        if (degreesLong == null || degreesLong.isEmpty() || minutesLong == null || minutesLong.isEmpty()){
            dataModel.put("body_template", "find-the-closest");
            dataModel.put("title", "Find the closest charging point");
        } else {
            double longitude = coordinatesConverter.convertCoordinatesToDecimal(degreesLong, minutesLong, secondLong);
            double latitude = coordinatesConverter.convertCoordinatesToDecimal(degreesLati, minutesLati, secondLati);
            List<ChargingPoint> chargingPointsList = new ArrayList<>();
            ChargingPoint chargingPoint = dataFilter
                    .findClosestChargingStation(chargingPointDao.findAll(), longitude,
                            latitude);
            chargingPointsList.add(chargingPoint);
            dataModel.put("body_template", "results");
            dataModel.put("title", "Find the closest charging point");
            dataModel.put("chargingPoints", chargingPointsList);
        }


        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
