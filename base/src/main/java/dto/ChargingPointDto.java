package dto;

import cdi.PromotedChargingPointsBean;
import controller.CoordinatesConverter;
import model.ChargingPoint;
import model.Connection;
import model.PromotedChargingPoint;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChargingPointDto {

    private CoordinatesConverter coordinatesConverter = new CoordinatesConverter();

    private int id;
    private String country;
    private String town;
    private String longitudeString;
    private String latitudeString;
    private double latitude;
    private double longitude;
    private List<ConnectionDto> connections;

    private boolean promoted;


    private String stateOrProvince;
    private String postCode;
    private String title;
    private String addressLine1;
    private String addressLine2;




    public static ChargingPointDto convertFromChargingPoint(ChargingPoint chargingPoint) {
        ChargingPointDto result = new ChargingPointDto();
        result.setId(chargingPoint.getId());
        result.setCountry(chargingPoint.getAddressInfo().getCountry().getTitle());
        result.setTown(chargingPoint.getAddressInfo().getTown());
        result.setLongitude(chargingPoint.getAddressInfo().getLongitude());
        result.setLatitude(chargingPoint.getAddressInfo().getLatitude());

        result.setStateOrProvince(chargingPoint.getAddressInfo().getStateOrProvince());
        result.setPostCode(chargingPoint.getAddressInfo().getPostcode());
        result.setTitle(chargingPoint.getAddressInfo().getTitle());
        result.setAddressLine1(chargingPoint.getAddressInfo().getAddressLine1());
        result.setAddressLine2(chargingPoint.getAddressInfo().getAddressLine2());

        List<ConnectionDto> connections = new ArrayList<>();
        chargingPoint.getConnectionList().forEach(c -> connections.add(new ConnectionDto(c.getLevel().getComments(), c.getLevel().getTitle(), c.getQuantity())));
        result.setConnections(connections);
        return result;
    }

    public static List<ChargingPointDto> convertFromChargingPointList(List<ChargingPoint> chargingPoints) {
        return chargingPoints.stream().map(c -> convertFromChargingPoint(c)).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = (country != null) ? country : "";
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = (town != null) ? town : "";
    }

    public String getLongitudeString() {
        return longitudeString;
    }

    public String getLatitudeString() {
        return latitudeString;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
        this.latitudeString = coordinatesConverter.convertDecimalAToLatitudeCoordinatesString(latitude);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
        this.longitudeString = coordinatesConverter.convertDecimalAToLongitudeCoordinatesString(longitude);
    }

    public List<ConnectionDto> getConnections() {
        return connections;
    }

    public void setConnections(List<ConnectionDto> connections) {
        this.connections = connections;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
}
