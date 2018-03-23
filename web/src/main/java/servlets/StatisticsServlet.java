package servlets;

import dao.CountryStatisticsDao;
import dao.TownStatisticsDao;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {

    @Inject
    CountryStatisticsDao countryStatisticsDao;
    @Inject
    TownStatisticsDao townStatisticsDao;

    public static final Logger LOG = LoggerFactory.getLogger(StatisticsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userSessionName = (String) req.getSession().getAttribute("user_name");


        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("userSessionName", userSessionName);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        dataModel.put("body_template", "statistics");
        dataModel.put("title", "Statistics");

        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");
        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            LOG.error("Template Exception was catched.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userSessionName = (String) req.getSession().getAttribute("user_name");
        String location = req.getParameter("location");


        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("userSessionName", userSessionName);
        dataModel.put("title", "Statistics");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        if (location.equals("town")) {
           List locationList = townStatisticsDao.findAllOrderByNumberOfVisitsDesc();
           if (locationList.size()==0) {
               dataModel.put("body_template", "statistics");
               dataModel.put("error" , "Noone was searching charging points by town name");
           }
           else {
               dataModel.put("body_template", "show-statistics");
               dataModel.put("locationList", locationList);
           }
        }
        else if (location.equals("country")) {
            List locationList = countryStatisticsDao.findAllOrderByNumberOfVisitsDesc();
            if (locationList.size()==0) {
                dataModel.put("body_template", "statistics");
                dataModel.put("error" , "Noone was searching charging points by country name");

            }
            else {
                dataModel.put("body_template", "show-statistics");
                dataModel.put("locationList", locationList);
            }

        }



        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");
        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            LOG.error("Template Exception was catched.");
        }
    }

}