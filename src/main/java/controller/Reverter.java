package controller;

import model.ChargingPoint;

import static java.lang.StrictMath.*;
import static jdk.nashorn.internal.objects.NativeMath.round;

public class Reverter {

    public double getDistanceInMeters(ChargingPoint pointOne, ChargingPoint pointTwo) {

        double radius = 6371000;

        double diffLat = pointOne.getOperatorInfo().getAddressInfo().getLatitude() -
                pointTwo.getOperatorInfo().getAddressInfo().getLatitude();

        double diffLon = pointOne.getOperatorInfo().getAddressInfo().getLongitude() -
                pointTwo.getOperatorInfo().getAddressInfo().getLongitude();

        double a = sin(diffLat / 2) * sin(diffLat / 2) +
                cos(pointTwo.getOperatorInfo().getAddressInfo().getLatitude()) *
                        cos(pointOne.getOperatorInfo().getAddressInfo().getLatitude()) *
                        sin(diffLon / 2) *
                        sin(diffLon / 2);

        double b = 2 * asin(sqrt(a));

        double distance = round((radius * b), 2);

        return distance;

    }



}


