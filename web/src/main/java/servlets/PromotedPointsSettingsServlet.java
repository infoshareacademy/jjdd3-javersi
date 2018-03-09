package servlets;

import cdi.PromotedChargingPointsBean;
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
import java.util.List;
import java.util.Map;

@WebServlet ("/promoted-settings")
public class PromotedPointsSettingsServlet extends HttpServlet {

    @Inject
    PromotedChargingPointsBean promotedChargingPointsBean;

    @Inject
    ChargingPointDao chargingPointDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && !action.isEmpty()) {
            String idString = req.getParameter("id");
            if (idString != null && !idString.isEmpty()) {

                Integer id =Integer.parseInt(idString);
                promotedChargingPointsBean.addToPromoted(id);
            }
            resp.sendRedirect("/promoted-settings");
        }
        Map<String, Object> dataModel = new HashMap<>();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        dataModel.put("body_template", "promoted-setting");
        dataModel.put("title", "Promoted Charging Points Settings");

        List<ChargingPoint> chargingPointsList = chargingPointDao.findAll();
        dataModel.put("chargingPoints", chargingPointsList);

        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
