package cdi;

import controller.JsonParser;
import exceptions.JsonFileNotFound;
import model.ChargingPoint;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class FileUploadProcessorBean {

    public int uploadJsonFile(Part filePart) throws JsonFileNotFound, IOException {
        if (filePart == null) {
            throw new JsonFileNotFound("No json file has been uploaded #1");
        }
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if (fileName == null || fileName.isEmpty()) {
            throw new JsonFileNotFound("No json file has been uploaded #2");
        }

        InputStream fileContent = filePart.getInputStream();
        String content = convertInputSteamToString(fileContent);

        List<ChargingPoint> chargingPointList =  new JsonParser().jsonToChargingPointList(content);

        //todo: Dodać zapis charging pointów do bazy danych (po mergu z innymi branchami)
        return chargingPointList.size();
    }

    private String convertInputSteamToString(InputStream inputStream) {
        String result = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining(""));
        return result;
    }

}
