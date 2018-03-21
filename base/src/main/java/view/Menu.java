package view;

import controller.AppProperties;
import model.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Menu {

    public static final Logger LOG = LoggerFactory.getLogger(Menu.class);
    public static final Logger UI_LOG = LoggerFactory.getLogger("UI");

    public int pickOption() {
        UI_LOG.info("1. Find the closest charging point");
        UI_LOG.info("2. Find charging points with the given radius");
        UI_LOG.info("3. Find charging points in the given city");
        UI_LOG.info("4. Settings");
        UI_LOG.info("5. Exit");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                UI_LOG.info("Select option: ");
                int x = Integer.valueOf(scanner.nextLine());
                if (x >= 1 && x <= 5) {
                    return x;
                }
            } catch (NumberFormatException e) {
                LOG.error("NumberFormatException was catched in method pickOption");
            }
            UI_LOG.info("Wrong value.");
        }

    }

    public Coordinates readCoordinates() {

        UI_LOG.info("Set geographical coordinates: ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                UI_LOG.info("Longitude (-180; 180): ");
                double longitude = Double.valueOf(scanner.nextLine());
                UI_LOG.info("Latitude (-90; 90): ");
                double latitude = Double.valueOf(scanner.nextLine());
                if ((longitude >= -180 && longitude <= 180) && (latitude >= -90 && latitude <= 90)) {
                    return new Coordinates(latitude, longitude);
                }
            } catch (NumberFormatException e) {
                LOG.error("NumberFormatException was catched in method readCoordinates");
            }
            UI_LOG.info("Wrong value.");
        }

    }

    public double readRadius() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                UI_LOG.info("Radius (" + AppProperties.getInstance().getUnits() + "):");
                double radius = Double.valueOf(scanner.nextLine());
                if (radius > 0) {
                    return radius;
                }
            } catch (NumberFormatException e) {
                LOG.error("NumberFormatException was catched in method readRadius");
            }
            UI_LOG.info("Wrong value.");
        }
    }

    public String readTown() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                UI_LOG.info("Town:");
                String town = scanner.nextLine();
                if (town != null) {
                    return town;
                }
            } catch (NumberFormatException e) {
                LOG.error("NumberFormatException was catched in method readTown");
            }
            UI_LOG.info("Wrong value.");
        }
    }
}
