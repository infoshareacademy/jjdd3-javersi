package servlets;

import cdi.ChargingPointToDtoConverterBean;
import cdi.PromotedChargingPointsBean;
import dao.ChargingPointDao;
import dto.ChargingPointDto;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet ("/administration/promoted-settings")
public class PromotedPointsSettingsServlet extends HttpServlet {


    @Inject
    PromotedChargingPointsBean promotedChargingPointsBean;

    @Inject
    ChargingPointDao chargingPointDao;

    @Inject
    private ChargingPointToDtoConverterBean chargingPointToDtoConverterBean;

    public static final Logger LOG = LoggerFactory.getLogger(PromotedPointsSettingsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> dataModel = new HashMap<>();

        String action = req.getParameter("action");
        if (action != null && !action.isEmpty()) {
            String idString = req.getParameter("id");
            if (idString != null && !idString.isEmpty()) {

                Integer id =Integer.parseInt(idString);
                if (action.equalsIgnoreCase("remove")) {
                    promotedChargingPointsBean.removeFromPromoted(id);
                }
                if (action.equalsIgnoreCase("add")) {
                    promotedChargingPointsBean.addToPromoted(id);
                }
            }
            resp.sendRedirect("/administration/promoted-settings");
        }

        List<ChargingPointDto> chargingPointsDtoList = chargingPointToDtoConverterBean.convertList(chargingPointDao.findAll());

        dataModel.put("body_template", "promoted-setting");
        dataModel.put("title", "Promoted Charging Points Settings");
        dataModel.put("chargingPointDtoList", chargingPointsDtoList);

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            LOG.error("Template problem occurred.");
        }
    }
}
