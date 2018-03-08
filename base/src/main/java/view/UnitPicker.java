package view;

import controller.Units;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

public class UnitPicker {
    
    private static final Logger LOG = LoggerFactory.getLogger(UnitPicker.class);
    public static final Logger UI_LOG = LoggerFactory.getLogger("UI");
    
    public static Units chooseUnit() {
        int unitNumber = -1;
        do {
            ClearScreen.clearScreen();
            UI_LOG.info("Select the unit:");

            Arrays.stream(Units.values()).forEach(s -> UI_LOG.info((s.ordinal() + 1) + ". " + s.toString()));
            Scanner scanner = new Scanner(System.in);
            try {
                unitNumber = scanner.nextInt() - 1;
            } catch (NumberFormatException e) {
                UI_LOG.info("Write a number.");
                LOG.error("NumberFormatException was catched in method chooseUnit");
            }
        } while (ifExist(unitNumber) == false);

        return Units.values()[unitNumber];
    }

    private static boolean ifExist(int number) {
        return (number <= (Units.values().length - 1) && number >= 0);
    }
}
