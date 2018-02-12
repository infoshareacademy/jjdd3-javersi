package controller;

import model.ChargingPoint;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class DataFilter {

    public static List<ChargingPoint> findChargingStationAtTown(List<ChargingPoint> points, String town) {

        List<ChargingPoint> chargingPoints = points.stream()
                .filter(p -> p.getAddressInfo().getTown().equals(town))
                .collect(toList());

        return chargingPoints;
    }

    public static ChargingPoint findClosestChargingStation(List<ChargingPoint> points, double longitude, double latitude) {

        ChargingPoint chargingPoint = null;

        double distance;

        double closest = Double.MAX_VALUE;

        for (ChargingPoint p : points) {

            distance = UnitSettings.distanceBetweenTwoPoints(p.getAddressInfo().getLatitude(), latitude,
                    p.getAddressInfo().getLongitude(), longitude);

            if (distance < closest) {
                closest = distance;
                chargingPoint = p;
            }
        }
        return chargingPoint;
    }

    public static List<ChargingPoint> findChargingStationAtArea(List<ChargingPoint> points, double longitude, double latitude, double radius) {

        List<ChargingPoint> chargingPoints = points.stream()
                .filter(p -> UnitSettings.distanceBetweenTwoPoints(p.getAddressInfo().getLatitude(), latitude,
                        p.getAddressInfo().getLongitude(), longitude) < radius)
                .collect(toList());

        return chargingPoints;
    }
}

