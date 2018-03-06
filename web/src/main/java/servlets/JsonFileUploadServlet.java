package servlets;

import cdi.FileUploadProcessor;
import exceptions.JsonFileNotFound;

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
public class JsonFileUploadServlet extends HttpServlet {

    @Inject
    FileUploadProcessor fileUploadProcessor;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("jsonFile");
        int recordsAdded = -1;
        try {
            recordsAdded = fileUploadProcessor.uploadJsonFile(filePart);
        } catch (JsonFileNotFound jsonFileNotFound) {
            //todo: Zastąpić loggerem
            PrintWriter writer = resp.getWriter();
            writer.write(Arrays.toString(jsonFileNotFound.getStackTrace()));
        }
        resp.sendRedirect("/administration?recordsAdded=" + recordsAdded);
    }
}
