package controller;

public class UnitSettings {

    public static double longtitudeToMeters(double longtitude) {
        return longtitude * 111196.672;
    }

    public static double latitudeToMeters(double latitude) {
        return latitude * 111196.672 * Math.cos(latitude * Math.PI / 180);
    }

}
