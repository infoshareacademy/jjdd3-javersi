package dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChargingPointDtoTest {

    ChargingPointDto sut = new ChargingPointDto();

    @Test
    public void shouldReturnProperLatitudeString() {
        //GIVEN
            double coordinates = 1.255;
        String expected = "N 01° 15' 18\"";
        sut.setLatitudeString(coordinates);
        //WHEN
        String result = sut.getLatitudeString();
        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnProperLongitudeString() {
        //GIVEN
        double coordinates = 1.255;
        String expected = "E 01° 15' 18\"";
        sut.setLongitudeString(coordinates);
        //WHEN
        String result = sut.getLongitudeString();
        //THEN
        assertEquals(expected, result);
    }
}