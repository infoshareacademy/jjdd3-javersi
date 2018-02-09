import controller.DataFilter;
import controller.JsonLoader;
import controller.JsonParser;
import model.ChargingPoint;
import model.OperatorInfo;
import view.Menu;
import view.PointDisplayer;

import java.io.IOException;
import java.util.List;

import static java.lang.StrictMath.*;
import static jdk.nashorn.internal.objects.NativeMath.round;

public class Main {

    public static void main(String[] args) {

        List<ChargingPoint> chargingPointList = null;

        try {
            String jsonContent = JsonLoader.loadFromFile("src/main/resources/sample.json");
            chargingPointList = JsonParser.jsonToChargingPointList(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu();
        switch (menu.pickOption()) {
            case 1: {

                ChargingPoint chargingPoint = DataFilter.findClosestChargingStation(chargingPointList,10,10);
            }
            case 2: {
                List<ChargingPoint> chargingPointListAtArea = DataFilter.findChargingStationAtArea(chargingPointList,10,10,5);
            }
            case 3: {

            }
        }

//        Main.getDistance();

    }


 /*   public static double getDistance() {

        double radius = 6371000;

        double diffLat = 10;

        double diffLon = 90;

        double a = sin(diffLat / 2) * sin(diffLat / 2) + cos(2) * cos(3) * sin(diffLon / 2) * sin(diffLon / 2);

        double b = 2 * asin(sqrt(a));

        //double b = 2 * atan2( sqrt(a), sqrt(1-a) );

        double distance = radius * b;

        System.out.println(distance);

        return distance;

    }

    function Dist() {

        final double dz = 12756.274;//średnica Ziemi na równiku [km]
        double a, b;

        a = (Lon2 - Lon1) * Cos(Lat1 * pi / 180);

        b = (Lat2 - Lat1);

        double result = sqrt(a * a + b * b) * PI * dz / 360;//[km]

    }*/
}