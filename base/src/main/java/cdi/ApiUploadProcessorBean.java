package cdi;

import controller.CustomGsonBuilder;
import controller.JsonParser;
import model.ChargingPoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@RequestScoped
public class ApiUploadProcessorBean extends UploadProcessor {


    public int uploadJsonApi() {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.openchargemap.io/v2/poi/?output=json&maxresults=1");
        Response response = target.request().accept(MediaType.APPLICATION_JSON).header("User-Agent", "curl/7.47.0").get();
        String data = response.readEntity(String.class);
        response.close();
        List<ChargingPoint> chargingPointList = new JsonParser(new CustomGsonBuilder()).jsonToChargingPointList(data);
        clearTables();
        saveChargingPoints(chargingPointList);
        return chargingPointList.size();
    }
}
