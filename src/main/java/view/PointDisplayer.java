package view;

import model.ChargingPoint;
import java.util.List;

public class PointDisplayer {

    public void showChargingPointProperties(ChargingPoint chargingPoint) {

        System.out.println(
                "Properties of the: " + chargingPoint + "\n" +

    public static void showChargingPointProperties(ChargingPoint chargingPoint) {

        System.out.println(
                "Properties of the: " + chargingPoint + "\n" +

                        "\nID: " + chargingPoint.getId() +
                        "\nUUID: " + chargingPoint.getUuid() +

                        "\nTitle: " + chargingPoint.getStatusType().getTitle() +
                        "\nOperability: " + chargingPoint.getStatusType().isOperational() +
                        "\nSelection: " + chargingPoint.getStatusType().isUserSelectable() +

                        "\nOperator id: " + chargingPoint.getOperatorInfo().getId() +
                        "\nOperator email: " + chargingPoint.getOperatorInfo().getContactEmail() +
                        "\nOperator comments: " + chargingPoint.getOperatorInfo().getComments() +
                        "\nOperator title: " + chargingPoint.getOperatorInfo().getTitle() +
                        "\nOperator website: " + chargingPoint.getOperatorInfo().getWebsiteURL() +

                        "\nLongitude: " + chargingPoint.getOperatorInfo().getAddressInfo().getLongitude() +
                        "\nLatitude: " + chargingPoint.getOperatorInfo().getAddressInfo().getLatitude() +
                        "\nTown: " + chargingPoint.getOperatorInfo().getAddressInfo().getTown() +
                        "\nState/province: " + chargingPoint.getOperatorInfo().getAddressInfo().getStateOrProvince() +
                        "\nCountry: " + chargingPoint.getOperatorInfo().getAddressInfo().getCountry() +
                        "\nContact telephone: " + chargingPoint.getOperatorInfo().getAddressInfo().getContactTelephone1() +
                        "\nPostcode: " + chargingPoint.getOperatorInfo().getAddressInfo().getPostcode() +
                        "\nRelated URL: " + chargingPoint.getOperatorInfo().getAddressInfo().getRelatedURL()
        );
    }

    public static void showAllAvailablePointsProperties(List<ChargingPoint> chargingPoints) {


        for (ChargingPoint p : chargingPoints) {

            showChargingPointProperties(p);
        }
    }

}
