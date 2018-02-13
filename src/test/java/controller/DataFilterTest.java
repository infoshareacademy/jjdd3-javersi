package controller;

import model.AddressInfo;
import model.ChargingPoint;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataFilterTest {


    @Test
    void shouldProperlySetFirstAndLastName() {

        List<ChargingPoint> chargingPointList = new ArrayList<>();
        ChargingPoint pointOne = new ChargingPoint();
        AddressInfo addressInfoOne = new AddressInfo();
        addressInfoOne.setTown("Wroclaw");
        pointOne.setAddressInfo(addressInfoOne);
        chargingPointList.add(pointOne);

        ChargingPoint pointTwo = new ChargingPoint();
        AddressInfo addressInfoTwo = new AddressInfo();
        addressInfoTwo.setTown("Gdansk");
        pointTwo.setAddressInfo(addressInfoTwo);
        chargingPointList.add(pointTwo);

        assertAll("Get town",
                () -> assertEquals("Wroclaw", pointOne.getAddressInfo().getTown(), "Town: "),
                () -> assertEquals("Gdansk", pointTwo.getAddressInfo().getTown(), "Town: ")
        );
    }

    @Test
    void findClosestChargingStation() {

        List<ChargingPoint> chargingPointList = new ArrayList<>();


    }

    @Test
    void findChargingStationAtArea() {


    }
}