package controller;

public class UnitSettings {
    private static final double  R = 6371;//km

    public static double distanceBetweenTwoPoints(double latitude1, double latitude2, double longitude1, double longitude2) {

        double distanceLatitude = Math.toRadians(latitude2 - latitude1);
        double distanceLongitude = Math.toRadians(longitude2 - longitude1);
        double a = Math.sin(distanceLatitude / 2) * Math.sin(distanceLatitude / 2) +
                Math.cos(Math.toRadians(longitude1)) * Math.cos(Math.toRadians(longitude2)) *
                        Math.sin(distanceLongitude / 2) * Math.sin(distanceLongitude / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
