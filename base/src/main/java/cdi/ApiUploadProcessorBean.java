package cdi;

import controller.CustomGsonBuilder;
import controller.JsonParser;
import model.ChargingPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@RequestScoped
public class ApiUploadProcessorBean extends UploadProcessor {

    private static final Logger log = LoggerFactory.getLogger(ApiUploadProcessorBean.class);

    public int uploadAllChargingpointsFromApi() {
        return uploadJsonApi( downloadJsonAsStringFromApi("maxresults=1000000"));

    }

    public int uploadAllChargingpointsInPolandFromApi() {
       return uploadJsonApi( downloadJsonAsStringFromApi("countrycode=PL&maxresults=1000000"));
    }

    private int uploadJsonApi(String Json) {

        List<ChargingPoint> chargingPointList = new JsonParser(new CustomGsonBuilder()).jsonToChargingPointList(Json);
        clearTables();
        log.info("Saving [{}] points", chargingPointList.size());
        saveChargingPoints(chargingPointList);

        return chargingPointList.size();
    }

    private String downloadJsonAsStringFromApi(String properties) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.openchargemap.io/v2/poi/?output=json&" + properties);
        Response response = target.request().accept(MediaType.APPLICATION_JSON).header("User-Agent", "curl/7.47.0").get();
        log.info("Response from HTTP Get openchargemap API: {}", response.getStatus());
        String data = response.readEntity(String.class);
        response.close();
        return data;
    }
}
