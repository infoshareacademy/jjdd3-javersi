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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@WebServlet("/find-the-closest-in-radius")
public class FindTheClosestInRadius extends HttpServlet{


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
        String radiusString = req.getParameter("radius");




        if (degreesLong == null || degreesLong.isEmpty() || degreesLati == null || degreesLati.isEmpty()){
            dataModel.put("body_template", "find-the-closest-in-radius");
           dataModel.put("title", "Find the closest charging point in radius");
        } else {
            double radius = Double.valueOf(radiusString);
            double longitude = coordinatesConverter.convertCoordinatesToDecimal(degreesLong, minutesLong, secondLong);
            double latitude = coordinatesConverter.convertCoordinatesToDecimal(degreesLati, minutesLati, secondLati);

            List<ChargingPoint> chargingPointsList = dataFilter
                    .findChargingStationAtArea(chargingPointDao.findAll(), longitude,
                            latitude, radius);


            dataModel.put("body_template", "results");
            dataModel.put("title", "Find the closest charging point in radius");
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
