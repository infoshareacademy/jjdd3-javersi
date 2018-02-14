package model;

public final class Coordinates {

    private double longitude;
    private double latitude;

    public Coordinates(double longtitude, double latitude) {
        this.longitude = longtitude;
        this.latitude = latitude;
    }

    public Coordinates() {
    }

    public double getLongtitude() {
        return longitude;
    }

    public void setLongtitude(double longtitude) {
        this.longitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
