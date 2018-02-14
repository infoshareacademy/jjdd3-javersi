package view;

import controller.Units;

import java.util.Arrays;
import java.util.Scanner;

public class UnitPicker {
    public static Units chooseUnit() {
        int unitNumber = -1;
        do {
            System.out.println("Wybierz jednostkę wpisując jej numer:");

            Arrays.stream(Units.values()).forEach(s -> System.out.println((s.ordinal() + 1) + ". " + s.toString()));
            Scanner scanner = new Scanner(System.in);
            try {
                unitNumber = scanner.nextInt() - 1;
            } catch (Exception e) {
                System.out.println("Musisz podać liczbę");
            }
        } while (ifExist(unitNumber) == false);

        return Units.values()[unitNumber];
    }

    private static boolean ifExist(int number) {
        return (number <= (Units.values().length - 1) && number >= 0);
    }
}
