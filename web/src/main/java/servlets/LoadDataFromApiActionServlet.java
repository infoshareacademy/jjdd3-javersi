package servlets;

import cdi.ApiUploadProcessorBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/administration/load-data-upload")
@MultipartConfig
public class LoadDataFromApiActionServlet extends HttpServlet {

    public static final Logger LOG = LoggerFactory.getLogger(JsonFileUploadActionServlet.class);

    @Inject
    ApiUploadProcessorBean apiUploadProcessorBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int recordsAdded = -1;
        try {
            recordsAdded = apiUploadProcessorBean.uploadJsonApi();
        } catch (Exception e) {
            LOG.error("Failed to update chargingpoints from api.");
        }
        resp.sendRedirect("/administration/load-data?recordsAdded=" + recordsAdded);
    }
}
