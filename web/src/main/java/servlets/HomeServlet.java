package servlets;

import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    public static final Logger LOG = LoggerFactory.getLogger(HomeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        Map<String,Object> dataModel = new HashMap<>();
        dataModel.put("body_template", "home");
        dataModel.put("title", "Home");
        dataModel.put("text", "Hello World! Javersi team.");

        Object userObject = req.getSession().getAttribute("user");
        User user;
        if (userObject != null) {
            user = (User) userObject;
            dataModel.put("userSessionName", user.getName());
            dataModel.put("userAdmin", user.getRoleAdministration());
        }


        Template template = TemplateProvider.createTemplate(getServletContext(), "layout.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            LOG.error("Template Exception was catched.");
        }

    }
}
