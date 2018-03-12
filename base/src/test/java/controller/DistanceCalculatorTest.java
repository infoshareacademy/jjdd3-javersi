package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    @Test
    void distanceBetweenTwoPointsOne() {
        AppProperties.getInstance().setUnits(Units.KILOMETERS);

        double testDistance = Math.round(DistanceCalculator.distanceBetweenTwoPoints(14, 56, 35, 11));

        assertEquals(5101, testDistance);
    }

    @Test
    void distanceBetweenTwoPointsTwo() {
        AppProperties.getInstance().setUnits(Units.KILOMETERS);

        double testDistance = Math.round(DistanceCalculator.distanceBetweenTwoPoints(89, 167, 67, 189));

        assertEquals(8503, testDistance);
    }

    @Test
    void distanceBetweenTwoPointsThree() {
        AppProperties.getInstance().setUnits(Units.KILOMETERS);

        double testDistance = Math.round(DistanceCalculator.distanceBetweenTwoPoints(11, 14, 18, 22));

        assertEquals(548, testDistance);
    }

    @Test
    void distanceBetweenTwoPointsFour() {
        AppProperties.getInstance().setUnits(Units.KILOMETERS);

        double testDistance = Math.round(DistanceCalculator.distanceBetweenTwoPoints(114, 156, 135, 111));

        assertEquals(4968, testDistance);
    }

}