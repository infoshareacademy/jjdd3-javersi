package view;

import controller.AppProperties;

import java.util.Scanner;

public class Settings {
    public static void show() {
        ClearScreen.clearScreen();
        int yesNo = -1;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Załadowano konfigurację\n" +
                    "Wybrana jednostka to: " + AppProperties.getInstance().getUnits() + "\n" +
                    "czy chcesz ją zmienić?\n" +
                    "1. TAK\n" +
                    "2. NIE");
            try {
                yesNo = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Musisz podać liczbę");
            }
        } while (yesOrNo(yesNo) == false);

        if (yesNo == 1) {
            AppProperties.getInstance().setUnits(UnitPicker.chooseUnit());
            AppProperties.getInstance().save();
        }
    }

    private static boolean yesOrNo(int number) {
        return (number <= 2 && number >= 1);
    }
}
