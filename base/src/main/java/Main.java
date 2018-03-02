import controller.DataFilter;
import controller.JsonLoader;
import controller.JsonParser;
import model.ChargingPoint;
import model.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.ClearScreen;
import view.Menu;
import view.PointDisplayer;
import view.Settings;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        private final Logger logger = LoggerFactory.getLogger(Main.class.getName());

        List<ChargingPoint> chargingPointList = null;

        try {
            String jsonContent = JsonLoader.loadFromFile(args[0]);
            JsonParser jsonParser = new JsonParser();
            chargingPointList = jsonParser.jsonToChargingPointList(jsonContent);
        } catch (IOException e) {
            logger.error("IOException was catched in class ");
        }

        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        outerloop:
        while (true) {
            ClearScreen.clearScreen();
            switch (menu.pickOption()) {
                case 1: {
                    logger.info("User searched closest charging station.");
                    ClearScreen.clearScreen();
                    Coordinates coordinates = menu.readCoordinates();
                    ChargingPoint chargingPoint = DataFilter
                            .findClosestChargingStation(chargingPointList, coordinates.getLongitude(),
                                    coordinates.getLatitude());
                    if (chargingPoint != null) {
                        PointDisplayer.showChargingPointProperties(chargingPoint);
                    } else {
                        System.out.println("Charging points not found.");
                    }
                    scanner.nextLine();
                    break;
                }
                case 2: {
                    logger.info("User searched charging station at the area.");
                    ClearScreen.clearScreen();
                    Coordinates coordinates = menu.readCoordinates();
                    double radius = menu.readRadius();
                    List<ChargingPoint> chargingPointListAtArea = DataFilter
                            .findChargingStationAtArea(chargingPointList, coordinates.getLongitude(),
                                    coordinates.getLatitude(), radius);

                    if (chargingPointListAtArea.size() != 0) {
                        PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtArea);
                    } else {
                        System.out.println("Charging points not found.");
                    }
                    scanner.nextLine();
                    break;
                }
                case 3: {
                    logger.info("User searched charging station at town.");
                    ClearScreen.clearScreen();
                    List<ChargingPoint> chargingPointListAtTown = DataFilter
                            .findChargingStationAtTown(chargingPointList, menu.readTown());
                    if (chargingPointListAtTown.size() != 0) {
                        PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtTown);
                    } else {
                        System.out.println("Charging points not found.");
                    }
                    scanner.nextLine();
                    break;
                }
                case 4: {
                    logger.info("User changed settings.");
                    ClearScreen.clearScreen();
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