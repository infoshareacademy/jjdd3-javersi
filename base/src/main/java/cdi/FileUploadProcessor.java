package cdi;

import exceptions.JsonFileNotFound;

import javax.servlet.http.Part;
import java.io.IOException;


public interface FileUploadProcessor {
    int uploadJsonFile(Part filePart) throws JsonFileNotFound, IOException;
}
