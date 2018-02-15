package view;

import controller.AppProperties;
import model.Coordinates;

import java.util.Scanner;

public class Menu {

    public int pickOption() {

        System.out.println("1. Znajdź najbliższą stację ładowania");
        System.out.println("2. Znajdź stacje ładowania w podanym promieniu");
        System.out.println("3. Znajdź stacje ładowania w danym mieście ");
        System.out.println("4. Ustawienia");
        System.out.println("5. Wyjście");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Wybierz opcje: ");
                int x = Integer.valueOf(scanner.nextLine());
                if (x >= 1 && x <= 5) {
                    return x;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Błędna wartość");
        }

    }

    public Coordinates readCoordinates() {
        System.out.println("Podaj współrzędne geograficzne : ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Longitude (-180; 180) :");
                double longitude = Double.valueOf(scanner.nextLine());
                System.out.print("Latitude (-90; 90) :");
                double latitude = Double.valueOf(scanner.nextLine());
                if ((longitude >= -180 && longitude <= 180) && (latitude >= -90 && latitude <= 90)) {
                    return new Coordinates(longitude, latitude);
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Błędna wartość!");
        }

    }

    public double readRadius() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Radius (" + AppProperties.getInstance().getUnits() + ") :");
                double radius = Double.valueOf(scanner.nextLine());
                if (radius > 0) {
                    return radius;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Błędna wartość!");
        }
    }

    public String readTown() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Town :");
                String town = scanner.nextLine();
                if ( town != null ) {
                    return town;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Błędna wartość!");
        }
    }
}
