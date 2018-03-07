package controller;

import model.ChargingPoint;

import javax.ejb.Singleton;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Singleton
public class DataFilter {

    public List<ChargingPoint> findChargingStationAtTown(List<ChargingPoint> points, String town) {

        List<ChargingPoint> chargingPoints = points.stream()
                .filter(p -> p.getAddressInfo().getTown().toUpperCase().equals(town.toUpperCase()))
                .collect(toList());

        return chargingPoints;
    }

    public ChargingPoint findClosestChargingStation(List<ChargingPoint> points, double longitude, double latitude) {

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

    public List<ChargingPoint> findChargingStationAtArea(List<ChargingPoint> points, double longitude, double latitude, double radius) {

        List<ChargingPoint> chargingPoints = points.stream()
                .filter(p -> DistanceCalculator.distanceBetweenTwoPoints(p.getAddressInfo().getLatitude(), latitude,
                        p.getAddressInfo().getLongitude(), longitude) < radius)
                .collect(toList());

        return chargingPoints;
    }
}

