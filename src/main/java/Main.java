import controller.DataFilter;
import controller.JsonLoader;
import controller.JsonParser;
import model.ChargingPoint;
import view.Menu;
import view.Settings;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<ChargingPoint> chargingPointList = null;

        try {
            String jsonContent = JsonLoader.loadFromFile("src/main/resources/sample.json");
            JsonParser jsonParser = new JsonParser();
            chargingPointList = jsonParser.jsonToChargingPointList(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Settings.run();
        Menu menu = new Menu();
        switch (menu.pickOption()) {
                ChargingPoint chargingPoint = DataFilter.findClosestChargingStation(chargingPointList, -110, 40);
                PointDisplayer.showChargingPointProperties(chargingPoint);
                break;
            }
            case 2: {
                List<ChargingPoint> chargingPointListAtArea = DataFilter.findChargingStationAtArea(chargingPointList, -99.36, 39.16, 500);
                PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtArea);
                break;
            }
            case 3: {
                List<ChargingPoint> chargingPointListAtTown = DataFilter.findChargingStationAtTown(chargingPointList, "Whistler");
                PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtTown);
                break;
            }
        }

    }
}