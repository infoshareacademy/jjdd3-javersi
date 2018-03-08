package controller;

import model.ChargingPoint;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class DataFilter {

    public static List<ChargingPoint> findChargingStationInCity(List<ChargingPoint> points, String city) {

        List<ChargingPoint> chargingPoints = points.stream()
                .filter(p -> p.getAddressInfo().getTown().toUpperCase().equals(city.toUpperCase()))
                .collect(toList());

        return chargingPoints;
    }

    public static List<ChargingPoint> findChargingStationInCountry(List<ChargingPoint> points, String country) {

        List<ChargingPoint> chargingPoints = points.stream()
                .filter(p -> p.getAddressInfo().getCountry().getTitle().toUpperCase().equals(country.toUpperCase()))
                .collect(toList());

        return chargingPoints;
    }

    public static ChargingPoint findClosestChargingStation(List<ChargingPoint> points, double longitude, double latitude) {

        ChargingPoint chargingPoint = null;

        double distance;

        double closest = Double.MAX_VALUE;

        for (ChargingPoint p : points) {

            distance = DistanceCalculator.distanceBetweenTwoPoints(p.getAddressInfo().getLatitude(), latitude,
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
                .filter(p -> DistanceCalculator.distanceBetweenTwoPoints(p.getAddressInfo().getLatitude(), latitude,
                        p.getAddressInfo().getLongitude(), longitude) < radius)
                .collect(toList());

        return chargingPoints;
    }
}

