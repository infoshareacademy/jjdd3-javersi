package servlets;

import cdi.AppPropertiesBean;
import commons.Formaters;
import controller.Units;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/administration/properties")
public class PropertiesServlet extends HttpServlet {

    @Inject
    private AppPropertiesBean appPropertiesBean;

    public static final Logger LOG = LoggerFactory.getLogger(PropertiesServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("title", "Properties");

        String userSessionName = (String) req.getSession().getAttribute("user_name");
        dataModel.put("userSessionName", userSessionName);

        String unit = req.getParameter("unit");
        if (unit != null && !unit.isEmpty()) {
            appPropertiesBean.setUnits(Units.valueOf(unit.toUpperCase()));
        }

        dataModel.put("body_template", "properties");
        dataModel.put("units", Formaters.getNames(Units.values()));
        dataModel.put("current_unit", Formaters.naturalFormat(appPropertiesBean.getCurrentUnit().name()));
        dataModel.put("api_key", appPropertiesBean.getGoogleApiKey());

        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            LOG.error("Template problem occurred.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String unit = req.getParameter("unit");
        if (unit != null && !unit.isEmpty()) {
            appPropertiesBean.setUnits(Units.valueOf(unit.toUpperCase()));
        }

        String apiKey = req.getParameter("api_key");
        if (apiKey != null && !apiKey.isEmpty()) {
            appPropertiesBean.setGoogleApiKey(apiKey);
        }

        resp.sendRedirect("/administration/properties");
    }
}
