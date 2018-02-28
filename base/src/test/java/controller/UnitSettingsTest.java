package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitSettingsTest {

    @Test
    void distanceBetweenTwoPointsOne() {

        double testDistance = Math.round(DistanceCalculator.distanceBetweenTwoPoints(14, 56, 35, 11));

        assertEquals(5101, testDistance);
    }

    @Test
    void distanceBetweenTwoPointsTwo() {

        double testDistance = Math.round(DistanceCalculator.distanceBetweenTwoPoints(89, 167, 67, 189));

        assertEquals(8503, testDistance);
    }

    @Test
    void distanceBetweenTwoPointsThree() {

        double testDistance = Math.round(DistanceCalculator.distanceBetweenTwoPoints(11, 14, 18, 22));

        assertEquals(548, testDistance);
    }

    @Test
    void distanceBetweenTwoPointsFour() {

        double testDistance = Math.round(DistanceCalculator.distanceBetweenTwoPoints(114, 156, 135, 111));

        assertEquals(4968, testDistance);
    }

}