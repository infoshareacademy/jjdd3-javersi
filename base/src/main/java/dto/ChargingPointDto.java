package dto;

import cdi.PromotedChargingPointsBean;
import controller.CoordinatesConverter;
import model.ChargingPoint;
import model.PromotedChargingPoint;

import javax.inject.Inject;
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

    private boolean promoted;


    public static ChargingPointDto convertFromChargingPoint(ChargingPoint chargingPoint) {
        ChargingPointDto result = new ChargingPointDto();
        result.setId(chargingPoint.getId());
        result.setCountry(chargingPoint.getAddressInfo().getCountry().getTitle());
        result.setTown(chargingPoint.getAddressInfo().getTown());
        result.setLongitude(chargingPoint.getAddressInfo().getLongitude());
        result.setLatitude(chargingPoint.getAddressInfo().getLatitude());
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
}
