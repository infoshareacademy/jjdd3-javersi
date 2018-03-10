package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesConverterTest {
    CoordinatesConverter sut = new CoordinatesConverter();

    @Test
    public void shouldReturnProperNorthLatitudeString() {
        //GIVEN
        double coordinates = 1.255;

        String expected = "N 01° 15' 18\"";

        //WHEN
        String result = sut.convertDecimalAToLatitudeCoordinatesString(coordinates);

        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnProperSouthLatitudeString() {
        //GIVEN
        double coordinates = -1.255;

        String expected = "S 01° 15' 18\"";

        //WHEN
        String result = sut.convertDecimalAToLatitudeCoordinatesString(coordinates);

        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnProperEastLongitudeString() {
        //GIVEN
        double coordinates = 1.255;

        String expected = "E 01° 15' 18\"";

        //WHEN
        String result = sut.convertDecimalAToLongitudeCoordinatesString(coordinates);

        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnProperWestLongitudeString() {
        //GIVEN
        double coordinates = -1.255;

        String expected = "W 01° 15' 18\"";

        //WHEN
        String result = sut.convertDecimalAToLongitudeCoordinatesString(coordinates);

        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void shouldConvertToDecimal() {
        //GIVEN
        String degree = "1";
        String minutes = "15";
        String seconds = "18";
        String direction = "N";

        double expected = 1.255;

        //WHEN
        double result = sut.convertCoordinatesToDecimal(direction, degree, minutes, seconds);

        //THEN
        assertEquals(expected, result);
    }


    @Test
    public void shouldConvertToDecimalNegative() {
        //GIVEN
        String degree = "-1";
        String minutes = "15";
        String seconds = "18";
        String direction = "S";

        double expected = -1.255;

        //WHEN
        double result = sut.convertCoordinatesToDecimal(direction, degree, minutes, seconds);

        //THEN
        assertEquals(expected, result);
    }


}