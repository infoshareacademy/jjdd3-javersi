import controller.DataFilter;
import controller.JsonLoader;
import controller.JsonParser;
import model.ChargingPoint;
import model.Coordinates;
import model.OperatorInfo;
import view.ClearScreen;
import view.Menu;
import view.PointDisplayer;
import view.Settings;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<ChargingPoint> chargingPointList = null;

        try {
            //String jsonContent = JsonLoader.loadFromFile("src/main/resources/sample.json");
            String jsonContent = JsonLoader.loadFromFile(args[0]);
            JsonParser jsonParser = new JsonParser();
            chargingPointList = jsonParser.jsonToChargingPointList(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        outerloop:
        while (true) {
            ClearScreen.clearScreen();
            switch (menu.pickOption()) {
                case 1: {
                    ClearScreen.clearScreen();
                    Coordinates coordinates = menu.readCoordinates();
                    ChargingPoint chargingPoint = DataFilter
                            .findClosestChargingStation(chargingPointList, coordinates.getLongitude(),
                                    coordinates.getLatitude());
                    if (chargingPoint != null) {
                        ClearScreen.clearScreen();
                        PointDisplayer.showChargingPointProperties(chargingPoint);
                    }
                    else {
                        System.out.println("Nie znaleziono żadnego punktu");
                    }
                    scanner.nextLine();
                    break;
                }
                case 2: {
                    ClearScreen.clearScreen();
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
                    scanner.nextLine();
                    break;
                }
                case 3: {
                    ClearScreen.clearScreen();
                    List<ChargingPoint> chargingPointListAtTown = DataFilter
                            .findChargingStationAtTown(chargingPointList, menu.readTown());
                    if (!chargingPointList.isEmpty() && chargingPointList != null) {
                        PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtTown);
                    } else {
                        System.out.println("Nie znaleziono żadnych punktów");
                    }
                    scanner.nextLine();
                    break;
                }
                case 4: {
                    ClearScreen.clearScreen();
                    Settings.show();
                    scanner.nextLine();
                    break;
                }

                case 5: {
                    break outerloop;
                }
            }
        }
    }
}