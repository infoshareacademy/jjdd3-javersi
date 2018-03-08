package view;

import controller.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Settings {

    private static final Logger LOG = LoggerFactory.getLogger(Settings.class);

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

            } catch (NumberFormatException e) {
                System.out.println("Write a number.");
                LOG.error("NumberFormatException was catched in method show");
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
