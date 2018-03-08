package view;

import controller.Units;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

public class UnitPicker {
    
    private static final Logger LOG = LoggerFactory.getLogger(UnitPicker.class);
    
    public static Units chooseUnit() {
        int unitNumber = -1;
        do {
            ClearScreen.clearScreen();
            System.out.println("Select the unit:");

            Arrays.stream(Units.values()).forEach(s -> System.out.println((s.ordinal() + 1) + ". " + s.toString()));
            Scanner scanner = new Scanner(System.in);
            try {
                unitNumber = scanner.nextInt() - 1;

            } catch (NumberFormatException e) {
                System.out.println("Write a number.");
                LOG.error("NumberFormatException was catched in method chooseUnit");
            }
        } while (ifExist(unitNumber) == false);

        return Units.values()[unitNumber];
    }

    private static boolean ifExist(int number) {
        return (number <= (Units.values().length - 1) && number >= 0);
    }
}
