package commons;

import java.util.Arrays;

public class Formaters {

    public static String[] getNames(Enum[] enums) {
        return Arrays.stream(enums).map(e -> naturalFormat(e.name())).toArray(String[]::new);
    }

    public static String naturalFormat (String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1, input.length()).toLowerCase();
    }
}
