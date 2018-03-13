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
    private boolean promoted;


    public static ChargingPointDto convertFromChargingPoint(ChargingPoint chargingPoint) {
        ChargingPointDto result = new ChargingPointDto();
        result.setId(chargingPoint.getId());
        result.setCountry(chargingPoint.getAddressInfo().getCountry().getTitle());
        result.setTown(chargingPoint.getAddressInfo().getTown());
        result.setLongitudeString(chargingPoint.getAddressInfo().getLongitude());
        result.setLatitudeString(chargingPoint.getAddressInfo().getLatitude());
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
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getLongitudeString() {
        return longitudeString;
    }

    public void setLongitudeString(double longitude) {
        this.longitudeString = coordinatesConverter.convertDecimalAToLongitudeCoordinatesString(longitude);
    }

    public String getLatitudeString() {
        return latitudeString;
    }

    public void setLatitudeString(double latitude) {
        this.latitudeString = coordinatesConverter.convertDecimalAToLatitudeCoordinatesString(latitude);
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }
}
