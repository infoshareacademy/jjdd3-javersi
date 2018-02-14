package view;

import java.util.Scanner;

public class Menu {

    public int pickOption() {

        System.out.println("1. Znajdź najbliższą stację ładowania");
        System.out.println("2. Znajdź stacje ładowania w podanym promieniu");
        System.out.println("3. Znajdź stacje ładowania w danym państwie lub mieście ");
        System.out.println("4. Ustawienia");
        System.out.println("5. Wyjście");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Wybierz opcje: ");
                int x = Integer.valueOf(scanner.nextLine());
                if (x == 1 || x == 2 || x == 3 || x == 4 || x == 5) {
                    return x;
                }
            } catch (NumberFormatException e) {
            }
        }
    }

}
