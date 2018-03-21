package servlets;

import cdi.FileUploadProcessorBean;
import exceptions.JsonFileNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/administration/json-file-upload")
@MultipartConfig
public class JsonFileUploadActionServlet extends HttpServlet {

    public static final Logger LOG = LoggerFactory.getLogger(JsonFileUploadActionServlet.class);

    @Inject
    FileUploadProcessorBean fileUploadProcessor;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int recordsAdded = -1;
        try {
            Part filePart = req.getPart("jsonFile");
            try {
                recordsAdded = fileUploadProcessor.uploadJsonFile(filePart);
            } catch (JsonFileNotFound jsonFileNotFound) {
                LOG.error("JsonFileNotFound Exception was catched.");
            }
        } catch (Exception e) {
            recordsAdded = 0;
        }

        resp.sendRedirect("/administration/json-upload?recordsAdded=" + recordsAdded);

    }
}
