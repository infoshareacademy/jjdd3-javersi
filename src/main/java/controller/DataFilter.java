package controller;

import model.ChargingPoint;
import model.Country;
import java.util.ArrayList;
import java.util.List;
import static java.lang.StrictMath.sqrt;

public class DataFilter {

    public static List<ChargingPoint> findChargingStationAtTown(List<ChargingPoint> points, String town, Country country) {

        List<ChargingPoint> chargingPoints = new ArrayList();


        for (ChargingPoint p : points) {
            if (p.getOperatorInfo().getAddressInfo().getTown() == town) {
                chargingPoints.add(p);
            }
        }
        return chargingPoints;
    }

    public static ChargingPoint findClosestChargingStation(List<ChargingPoint> points, double longitude, double latitude) {

        ChargingPoint chargingPoint = null;

        double distance;

        double closest = Double.MAX_VALUE;
        longitude = UnitSettings.longitudeToMeters(longitude);
        latitude = UnitSettings.latitudeToMeters(latitude);

        for (ChargingPoint p : points) {

            distance = sqrt(Math.pow(latitude - p.getOperatorInfo().getAddressInfo().getLatitude(), 2)
                    + Math.pow(longitude - p.getOperatorInfo().getAddressInfo().getLongitude(), 2));

            if (distance < closest) {
                closest = distance;
                chargingPoint = p;
            }
        }
        return chargingPoint;
    }

    public static List<ChargingPoint> findChargingStationAtArea(List<ChargingPoint> points, double longitude, double latitude, double radius) {

        List<ChargingPoint> chargingPoints = new ArrayList();
        longitude = UnitSettings.longitudeToMeters(longitude);
        latitude = UnitSettings.latitudeToMeters(latitude);

        for (ChargingPoint p : points) {

            if ((Math.pow(longitude - p.getOperatorInfo().getAddressInfo().getLongitude(), 2) +

                    +(Math.pow(latitude - p.getOperatorInfo().getAddressInfo().getLatitude(), 2))

                    < radius * radius)) {

                chargingPoints.add(p);
            }
        }
        return chargingPoints;
    }
}

