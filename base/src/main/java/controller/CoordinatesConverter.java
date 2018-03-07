package controller;

public class CoordinatesConverter {

    public static double convertCoordinatesToDecimal(String degrees, String minutes, String seconds) {
        double degree = Double.valueOf(degrees);
        double minute = Double.valueOf(minutes);
        double second = Double.valueOf(seconds);
        return Double.valueOf(degrees) + (Double.valueOf(minutes)*60 + Double.valueOf(seconds))/3600;
    }
    public static String[]  convertDecimalToCoordinates(double coordinate) {
        int degrees = (int) coordinate;
        int minutes = (int)(60*(coordinate-degrees));
        double seconds = 3600*(coordinate-Double.valueOf(degrees))-(60*(int)minutes);
        String[] coordinates = new String[3];
        coordinates[0]=String.valueOf(degrees);
        coordinates[1]=String.valueOf(minutes);
        coordinates[2]=String.valueOf(seconds);
        return coordinates;
    }

}
