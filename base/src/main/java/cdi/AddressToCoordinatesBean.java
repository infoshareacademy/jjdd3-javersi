package cdi;

import controller.AppProperties;
import controller.UrlBuilder;
import model.Coordinates;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.GMapsApiLocation;
import model.GMapsApiResponse;
import  org.apache.commons.lang3.StringEscapeUtils;

@RequestScoped
public class AddressToCoordinatesBean {
    public static final String API_URL = "https://maps.googleapis.com/maps/api/geocode/json";

    public Coordinates getCoordinates(String address) {
        try {
            String escapedAddress = StringEscapeUtils.escapeHtml4(address);
            Client client = ClientBuilder.newClient();

            UrlBuilder builder = new UrlBuilder(API_URL);
            builder.addParameterToUrl("key", AppProperties.getInstance().getGoogleApiKey());
            builder.addParameterToUrl("address", escapedAddress);
            WebTarget webTarget = client.target(builder.toString());

            Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).get();
            GMapsApiResponse data = response.readEntity(GMapsApiResponse.class);
            response.close();

            GMapsApiLocation location = data.getResults().get(0).getGeometry().getLocation();

            return new Coordinates(location.getLat(), location.getLng());
        } catch (Exception e) {
            return null;
        }
    }
}
