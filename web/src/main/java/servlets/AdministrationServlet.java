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

@WebServlet("/administration")
public class AdministrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> dataModel = new HashMap<>();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        dataModel.put("body_template", "administration");
        dataModel.put("title", "Administration");
        String recordsAdded = req.getParameter("recordsAdded");
        if (recordsAdded != null && !recordsAdded.isEmpty() ) {
            dataModel.put("recordsAdded", recordsAdded);
        }

        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
