package view;

import controller.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Settings {

    private static final Logger logger = LoggerFactory.getLogger(Settings.class);

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
                yesNo = Integer.valueOf(scanner.nextLine());
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
