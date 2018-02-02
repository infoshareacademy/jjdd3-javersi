import model.AddressInfo;
import model.ChargingPoint;
import model.Country;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.sqrt;

public class Data {

    public void dataIn() {

    }

////////////////////////// FIND STATION AT TOWN ////////////////////////////////////////////////////////////////////////

    public List<ChargingPoint> findChargingStationAtTown(List<ChargingPoint> points, String town, Country country) {

        List<ChargingPoint> chargingPoints = new ArrayList<>();

        for (ChargingPoint p : points) {
            if (p.getOperatorInfo().getAddressInfo().getTown() == town) {
                chargingPoints.add(p);
            }
        }

        return chargingPoints;
    }
    ////////////////////////// FIND CLOSEST STATION ////////////////////////////////////////////////////////////////////////

    public void findClosestChargingStation(List<ChargingPoint> points, double longitude, double latitude) {

        List<ChargingPoint> chargingPoints = new ArrayList<>();

        double distance;

        double closest = Double.MAX_VALUE;

        for (ChargingPoint p : points) {

            distance = sqrt(Math.pow(latitude - p.getOperatorInfo().getAddressInfo().getLatitude(), 2)
                    + Math.pow(longitude - p.getOperatorInfo().getAddressInfo().getLongitude(), 2));

            if (distance < closest) {
                closest = distance;
            }

        }

    }

    ////////////////////////// FIND STATION AT AREA ////////////////////////////////////////////////////////////////////////

    public List<ChargingPoint> findChargingStationAtArea(List<ChargingPoint> points, double longitude, double latitude, double radius) {


        List<ChargingPoint> chargingPoints = new ArrayList<>();

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

