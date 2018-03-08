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

    public static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        
        List<ChargingPoint> chargingPointList = null;

        try {
            String jsonContent = JsonLoader.loadFromFile(args[0]);
            JsonParser jsonParser = new JsonParser();
            chargingPointList = jsonParser.jsonToChargingPointList(jsonContent);
        } catch (IOException e) {
            LOG.error("IOException was catched");
        }

        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        outerloop:
        while (true) {
            ClearScreen.clearScreen();
            switch (menu.pickOption()) {
                case 1: {
                    LOG.info("User searched closest charging station.");
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
                    LOG.info("User searched charging station at the area.");
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
                    LOG.info("User searched charging station at town.");
                    ClearScreen.clearScreen();
                    List<ChargingPoint> chargingPointListAtTown = DataFilter
                            .findChargingStationInCity(chargingPointList, menu.readCity());
                    if (chargingPointListAtTown.size() != 0) {
                        PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtTown);
                    } else {
                        System.out.println("Charging points not found.");
                    }
                    scanner.nextLine();
                    break;
                }
                case 4: {
                    LOG.info("User changed settings.");
                    ClearScreen.clearScreen();
                    List<ChargingPoint> chargingPointListAtTown = DataFilter
                            .findChargingStationInCountry(chargingPointList, menu.readCountry());
                    if (chargingPointListAtTown.size() != 0) {
                        PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtTown);
                    } else {
                        System.out.println("Charging points not found.");
                    }
                    scanner.nextLine();
                    break;
                }
                case 5: {
                    ClearScreen.clearScreen();
                    Settings.show();
                    break;
                }
                case 6: {
                    break outerloop;
                }
            }
        }
    }
}