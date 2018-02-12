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


        for (ChargingPoint p : points) {

            distance = UnitSettings.distanceBetweenTwoPoints(p.getOperatorInfo().getAddressInfo().getLatitude(), latitude, p.getOperatorInfo().getAddressInfo().getLongitude(), longitude);


            if (distance < closest) {
                closest = distance;
                chargingPoint = p;
            }
        }
        return chargingPoint;
    }

    public static List<ChargingPoint> findChargingStationAtArea(List<ChargingPoint> points, double longitude, double latitude, double radius) {

        List<ChargingPoint> chargingPoints = new ArrayList();

        double distance;
        for (ChargingPoint p : points) {
            distance = UnitSettings.distanceBetweenTwoPoints(p.getOperatorInfo().getAddressInfo().getLatitude(), latitude, p.getOperatorInfo().getAddressInfo().getLongitude(), longitude);

            if (distance < radius) {

                chargingPoints.add(p);
            }
        }
        return chargingPoints;
    }
}

