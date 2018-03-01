package view;

import controller.AppProperties;

import java.util.Scanner;

public class Settings {
    public static void show() {
        ClearScreen.clearScreen();
        int yesNo = -1;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Configuration has been loaded\n" +
                    "Selected unit: " + AppProperties.getInstance().getUnits() + "\n" +
                    "would you like to change?\n" +
                    "1. YES\n" +
                    "2. NO");
            try {
                yesNo = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Write a number.");
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
