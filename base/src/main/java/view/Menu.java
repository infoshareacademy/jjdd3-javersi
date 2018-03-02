package view;

import controller.AppProperties;
import model.Coordinates;

import java.util.Scanner;

public class Menu {

    public int pickOption() {
        System.out.println("1. Find the closest charging point");
        System.out.println("2. Find charging points with the given radius");
        System.out.println("3. Find charging points in the given city");
        System.out.println("4. Settings");
        System.out.println("5. Exit");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Select option: ");
                int x = Integer.valueOf(scanner.nextLine());
                if (x >= 1 && x <= 5) {
                    return x;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Wrong value.");
        }

    }

    public Coordinates readCoordinates() {

        System.out.println("Set geographical coordinates: ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Longitude (-180; 180): ");
                double longitude = Double.valueOf(scanner.nextLine());
                System.out.print("Latitude (-90; 90): ");
                double latitude = Double.valueOf(scanner.nextLine());
                if ((longitude >= -180 && longitude <= 180) && (latitude >= -90 && latitude <= 90)) {
                    return new Coordinates(longitude, latitude);
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Wrong value.");
        }

    }

    public double readRadius() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Radius (" + AppProperties.getInstance().getUnits() + "):");
                double radius = Double.valueOf(scanner.nextLine());
                if (radius > 0) {
                    return radius;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Wrong value.");
        }
    }

    public String readTown() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Town:");
                String town = scanner.nextLine();
                if (town != null) {
                    return town;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Wrong value.");
        }
    }
}
