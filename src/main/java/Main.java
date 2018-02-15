import controller.DataFilter;
import controller.JsonLoader;
import controller.JsonParser;
import model.ChargingPoint;
import model.Coordinates;
import model.OperatorInfo;
import view.Menu;
import view.PointDisplayer;
import view.Settings;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<ChargingPoint> chargingPointList = null;

        try {
            String jsonContent = JsonLoader.loadFromFile("src/main/resources/sample.json");
            JsonParser jsonParser = new JsonParser();
            chargingPointList = jsonParser.jsonToChargingPointList(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu();

        outerloop:
        while (true) {

            switch (menu.pickOption()) {
                case 1: {
                    Coordinates coordinates = menu.readCoordinates();
                    ChargingPoint chargingPoint = DataFilter
                            .findClosestChargingStation(chargingPointList, coordinates.getLongitude(),
                                    coordinates.getLatitude());
                    if (chargingPoint != null) {
                        PointDisplayer.showChargingPointProperties(chargingPoint);
                    }
                    else {
                        System.out.println("Nie znaleziono żadnego punktu");
                    }
                    break;
                }
                case 2: {
                    Coordinates coordinates = menu.readCoordinates();
                    double radius = menu.readRadius();
                    List<ChargingPoint> chargingPointListAtArea = DataFilter
                            .findChargingStationAtArea(chargingPointList, coordinates.getLongitude(),
                                    coordinates.getLatitude(), radius);
                    if (!chargingPointList.isEmpty()) {
                        PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtArea);
                    } else {
                        System.out.println("Nie znaleziono żadnych punktów");
                    }
                    break;
                }
                case 3: {
                    List<ChargingPoint> chargingPointListAtTown = DataFilter
                            .findChargingStationAtTown(chargingPointList, menu.readTown());
                    if (!chargingPointList.isEmpty() && chargingPointList != null) {
                        PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtTown);
                    } else {
                        System.out.println("Nie znaleziono żadnych punktów");
                    }
                    break;
                }
                case 4: {
                    Settings.show();
                    break;
                }

                case 5: {
                    break outerloop;
                }
            }
        }
    }
}