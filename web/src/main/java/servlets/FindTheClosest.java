package servlets;

import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.ChargingPoint;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@WebServlet("/find-the-closest")
public class FindTheClosest extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> dataModel = new HashMap<>();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");


        String longitude = req.getParameter("longitude");
        String latitude = req.getParameter("latitude");
        if (longitude == null || longitude.isEmpty() || latitude == null || latitude.isEmpty()){
            dataModel.put("body_template", "find-the-closest");
            dataModel.put("title", "Find the closest charging point");
        } else {
            dataModel.put("body_template", "result");
            dataModel.put("title", "Find the closest charging point");
            dataModel.put("chargingPoints", new LinkedList<ChargingPoint>());
        }


        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
