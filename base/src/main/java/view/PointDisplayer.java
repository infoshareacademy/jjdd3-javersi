package view;

import model.ChargingPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class PointDisplayer {

    public static final Logger UI_LOG = LoggerFactory.getLogger("UI");

    public static void showChargingPointProperties(ChargingPoint chargingPoint) {

        UI_LOG.info(
                "Properties of the: " + chargingPoint + "\n" +

                        "\nID: " + chargingPoint.getId() +
                        "\nUUID: " + chargingPoint.getUuid() +

                        "\nTitle: " + chargingPoint.getStatusType().getTitle() +
                        "\nOperability: " + chargingPoint.getStatusType().isOperational() +
                        "\nSelection: " + chargingPoint.getStatusType().isUserSelectable() +

                        "\nLongitude: " + chargingPoint.getAddressInfo().getLongitude() +
                        "\nLatitude: " + chargingPoint.getAddressInfo().getLatitude() +
                        "\nTown: " + chargingPoint.getAddressInfo().getTown() +
                        "\nState/province: " + chargingPoint.getAddressInfo().getStateOrProvince() +
                        "\nCountry: " + chargingPoint.getAddressInfo().getCountry().getTitle()
        );
    }

    public static void showAllAvailablePointsProperties(List<ChargingPoint> chargingPoints) {

        chargingPoints.forEach(c -> showChargingPointProperties(c));
    }
}