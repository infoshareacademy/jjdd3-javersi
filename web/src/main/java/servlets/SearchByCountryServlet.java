package servlets;

import cdi.AppPropertiesBean;
import cdi.ChargingPointToDtoConverterBean;
import dao.ChargingPointDao;
import dao.CountryStatisticsDao;
import dto.ChargingPointDto;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.User;
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

@WebServlet("/search-by-country")
public class SearchByCountryServlet extends HttpServlet{

    @Inject
    private ChargingPointDao chargingPointDao;

    @Inject
    private ChargingPointToDtoConverterBean chargingPointToDtoConverterBean;

    @Inject
    private CountryStatisticsDao countryStatisticsDao;

    @Inject
    private AppPropertiesBean appPropertiesBean;

    public static final Logger LOG = LoggerFactory.getLogger(SearchByCountryServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOG.info("User searched charging station at country");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("title", "Search by country");

        Object userObject = req.getSession().getAttribute("user");
        User user;
        if (userObject != null) {
            user = (User) userObject;
            dataModel.put("userSessionName", user.getName());
            dataModel.put("userAdmin", user.getRoleAdministration());
        }

        String country = req.getParameter("country");
        if (country == null || country.isEmpty()) {
            dataModel.put("body_template", "search-by-country");
        } else {
            try {

                List<ChargingPointDto> chargingPointsDtoList = chargingPointToDtoConverterBean.convertList(chargingPointDao.findByCountry(country));

                if (chargingPointsDtoList.size() > 0) {
                    countryStatisticsDao.addToStatistics(country);
                    dataModel.put("body_template", "results");
                    dataModel.put("chargingPoints", chargingPointsDtoList);
                    dataModel.put("google_api_key", appPropertiesBean.getGoogleApiKey());
                }
                else { errorMessages(dataModel);
                }
            } catch (Exception e) {
                errorMessages(dataModel);
                LOG.error("Exception was catched.");
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

    private void errorMessages(Map<String, Object> dataModel) {
        dataModel.put("body_template", "search-by-country");
        dataModel.put("error", "No charging points found");
    }
}
