package controller;

import javax.enterprise.context.RequestScoped;
import java.text.DecimalFormat;

@RequestScoped
public class CoordinatesConverter {

    final String DEGREE  = "\u00b0";
    final String MINUTES  = "\'";
    final String SECONDS  = "\"";

    public double convertCoordinatesToDecimal(String direction, String degrees, String minutes, String seconds) {
        double degree = Math.abs(Double.valueOf(degrees));
        double minute = Math.abs(Double.valueOf(minutes));
        double second = Math.abs(Double.valueOf(seconds));
        double result = degree + minute / 60 + second / 3600;
        if (direction.equalsIgnoreCase("S") || direction.equalsIgnoreCase("W")) {
            return -result;
        } else {
            return result;
        }
    }

    public String convertDecimalAToLatitudeCoordinatesString(double value) {
        int[] parts = convertDecimalToCoordinates(Math.abs(value));
        if (value >= 0) {
            return buildCoordinatesString("N", parts);
        } else {
            return buildCoordinatesString("S", parts);
        }
    }

    public String convertDecimalAToLongitudeCoordinatesString(double value) {
        int[] parts = convertDecimalToCoordinates(Math.abs(value));
        if (value >= 0) {
            return buildCoordinatesString("E", parts);
        } else {
            return buildCoordinatesString("W", parts);
        }
    }

    private String buildCoordinatesString(String prefix, int[] parts) {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        builder.append(" ");
        builder.append(String.format("%02d", parts[0]));
        builder.append(DEGREE);
        builder.append(" ");
        builder.append(String.format("%02d", parts[1]));
        builder.append(MINUTES);
        builder.append(" ");
        builder.append(String.format("%02d", parts[2]));
        builder.append(SECONDS);
        return builder.toString();
    }

    private int[] convertDecimalToCoordinates(double coordinate) {

        int seconds = (int) (coordinate * 3600) % 60;
        int minutes = (int) ((coordinate * 3600 - seconds)/60) % 60;
        int degrees = (int) coordinate;

        int[] coordinates = new int[3];
        coordinates[0] = degrees;
        coordinates[1] = minutes;
        coordinates[2] = seconds;
        return coordinates;
    }
}
