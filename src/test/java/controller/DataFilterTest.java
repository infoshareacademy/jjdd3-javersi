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
        ChargingPoint point = new ChargingPoint();
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setTown("Warsaw");
        point.setAddressInfo(addressInfo);
        chargingPointList.add(point);

        assertAll("Get town",
                () -> assertEquals("Warsaw", point.getAddressInfo().getTown(), "Town:")
        );
    }


    @Test
    void findClosestChargingStation() {


    }

    @Test
    void findChargingStationAtArea() {


    }
}