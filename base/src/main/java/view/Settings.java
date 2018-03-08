package view;

import controller.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Settings {

    private static final Logger LOG = LoggerFactory.getLogger(Settings.class);
    public static final Logger UI_LOG = LoggerFactory.getLogger("UI");

    public static void show() {
        ClearScreen.clearScreen();
        int yesNo = -1;
        do {
            Scanner scanner = new Scanner(System.in);
            UI_LOG.info("Configuration has been loaded\n" +
                    "Selected unit: " + AppProperties.getInstance().getUnits() + "\n" +
                    "would you like to change?\n" +
                    "1. YES\n" +
                    "2. NO");
            try {
                yesNo = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                UI_LOG.info("Write a number.");
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
