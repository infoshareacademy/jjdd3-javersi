package servlets;

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

@WebServlet("/search-by-country")
public class SearchByCountry extends HttpServlet{
    @Inject
    private ChargingPointDao chargingPointDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> dataModel = new HashMap<>();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        String country = req.getParameter("country");




        String town = req.getParameter("country");
        if (town == null || town.isEmpty()) {
            dataModel.put("body_template", "search-by-country");
            dataModel.put("title", "Search by Country");
        } else {
            List<ChargingPoint> chargingPointsList = chargingPointDao.findByCountry(country);
            dataModel.put("body_template", "results");
            dataModel.put("title", "Search by Country");
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
