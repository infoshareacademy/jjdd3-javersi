package view;

import model.Coordinates;

import java.util.Scanner;

public class Menu {

    public int pickOption() {

        System.out.println("1. Znajdź najbliższą stację ładowania");
        System.out.println("2. Znajdź stacje ładowania w podanym promieniu");
        System.out.println("3. Znajdź stacje ładowania w danym państwie lub mieście ");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Wybierz opcje: ");
                int x = Integer.valueOf(scanner.nextLine());
                if (x == 1 || x == 2 || x == 3) {
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
                double longitude = Integer.valueOf(scanner.nextLine());
                System.out.print("Latitude (-90; 90) :");
                double latitude = Integer.valueOf(scanner.nextLine());
                if ((longitude >= -180 && longitude <= 180) && (latitude >= -90 && latitude <= 90)) {
                    return new Coordinates(longitude, latitude);
                }
            } catch (NumberFormatException e) {
                System.out.println("Błędna wartość!");
            }
        }

    }

}
