package controller;

import model.AddressInfo;
import model.ChargingPoint;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataFilterTest {

    @Test
    void findChargingStationAtTownCheck() {

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

        List<ChargingPoint> chargPoints = DataFilter.findChargingStationAtTown(chargingPointList,
                "Wroclaw");

        assertEquals("Wroclaw", chargPoints.get(0).getAddressInfo().getTown(), "Town: ");
    }

    @Test
    void findClosestChargingStationCheck() {

        List<ChargingPoint> chargingPointList = new ArrayList<>();

        ChargingPoint pointOne = new ChargingPoint();
        AddressInfo addressInfoOne = new AddressInfo();
        addressInfoOne.setLatitude(15);
        addressInfoOne.setLongitude(30);
        addressInfoOne.setId(1111);
        pointOne.setAddressInfo(addressInfoOne);
        chargingPointList.add(pointOne);

        ChargingPoint pointTwo = new ChargingPoint();
        AddressInfo addressInfoTwo = new AddressInfo();
        addressInfoTwo.setLatitude(87);
        addressInfoTwo.setLongitude(82);
        addressInfoTwo.setId(2222);
        pointTwo.setAddressInfo(addressInfoTwo);
        chargingPointList.add(pointTwo);

        ChargingPoint pointThree = new ChargingPoint();
        AddressInfo addressInfoThree = new AddressInfo();
        addressInfoThree.setLatitude(18);
        addressInfoThree.setLongitude(47);
        addressInfoThree.setId(3333);
        pointThree.setAddressInfo(addressInfoThree);
        chargingPointList.add(pointThree);

        ChargingPoint returnedPoint = DataFilter.findClosestChargingStation(chargingPointList,
                31, 16);

        assertEquals(1111, returnedPoint.getAddressInfo().getId());
    }

    @Test
    void findChargingStationAtAreaCheck() {

        List<ChargingPoint> chargingPointList = new ArrayList<>();

        ChargingPoint pointOne = new ChargingPoint();
        AddressInfo addressInfoOne = new AddressInfo();
        addressInfoOne.setLatitude(15);
        addressInfoOne.setLongitude(30);
        addressInfoOne.setId(1111);
        pointOne.setAddressInfo(addressInfoOne);
        chargingPointList.add(pointOne);

        ChargingPoint pointTwo = new ChargingPoint();
        AddressInfo addressInfoTwo = new AddressInfo();
        addressInfoTwo.setLatitude(87);
        addressInfoTwo.setLongitude(82);
        addressInfoTwo.setId(2222);
        pointTwo.setAddressInfo(addressInfoTwo);
        chargingPointList.add(pointTwo);

        ChargingPoint pointThree = new ChargingPoint();
        AddressInfo addressInfoThree = new AddressInfo();
        addressInfoThree.setLatitude(16);
        addressInfoThree.setLongitude(30);
        addressInfoThree.setId(3333);
        pointThree.setAddressInfo(addressInfoThree);
        chargingPointList.add(pointThree);

        ChargingPoint pointFour = new ChargingPoint();
        AddressInfo addressInfoFour = new AddressInfo();
        addressInfoFour.setLatitude(88);
        addressInfoFour.setLongitude(88);
        addressInfoFour.setId(4444);
        pointFour.setAddressInfo(addressInfoFour);
        chargingPointList.add(pointFour);

        List<ChargingPoint> returnedList = DataFilter.findChargingStationAtArea(chargingPointList,
                30, 15, 200);

        assertEquals(2, returnedList.size());
        assertEquals(1111, returnedList.get(0).getAddressInfo().getId());
        assertEquals(3333, returnedList.get(1).getAddressInfo().getId());
    }
}