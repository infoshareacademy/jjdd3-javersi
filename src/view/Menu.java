package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void showOption() {
        System.out.println("1. Znajdź najbliższą stację ładowania");
        System.out.println("2. Znajdź stacje ładowania w podanym promieniu");
        System.out.println("3. Znajdź stacje ładowania w danym państwie lub mieście ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Wybierz opcje: ");
                int x = Integer.valueOf(scanner.nextLine());
                if (x == 1 || x == 2 || x == 3) {
                    break;
                }
            } catch (NumberFormatException e) {
            }

            System.out.println("Błędna wartość, podaj liczby z zakresu [1,2,3]");
        }

    }

}
