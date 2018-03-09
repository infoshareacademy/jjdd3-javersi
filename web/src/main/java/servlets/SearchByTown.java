package servlets;

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

@WebServlet("/search-by-town")
public class SearchByTown extends HttpServlet {

    @Inject
    private ChargingPointDao chargingPointDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> dataModel = new HashMap<>();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        String town = req.getParameter("town");


        if (town == null || town.isEmpty()) {
            dataModel.put("body_template", "search-by-town");
            dataModel.put("title", "Search by town");
        } else {
            List <ChargingPoint> chargingPointsList = chargingPointDao.findByTown(town);
            dataModel.put("body_template", "results");
            dataModel.put("title", "Search by town");
            dataModel.put("chargingPoints", chargingPointsList);
        }

        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            //todo: Zastąpić loggerem jak będą działały
            writer.write(Arrays.toString(e.getStackTrace()));
        }
    }

}
