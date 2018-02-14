import controller.DataFilter;
import controller.JsonLoader;
import controller.JsonParser;
import model.ChargingPoint;
import model.Coordinates;
import model.OperatorInfo;
import view.Menu;
import view.PointDisplayer;
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
        Coordinates coordinates = new Coordinates();
        Menu menu = new Menu();
        switch (menu.pickOption()) {
            case 1: {
                coordinates = menu.readCoordinates();
                ChargingPoint chargingPoint = DataFilter
                        .findClosestChargingStation(chargingPointList, coordinates.getLongtitude(),
                                coordinates.getLatitude());
                PointDisplayer.showChargingPointProperties(chargingPoint);
                break;
            }
            case 2: {
                menu.readCoordinates();
                List<ChargingPoint> chargingPointListAtArea = DataFilter
                        .findChargingStationAtArea(chargingPointList, coordinates.getLongtitude(),
                                coordinates.getLatitude(), 700);
                PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtArea);
                break;
            }
            case 3: {
                List<ChargingPoint> chargingPointListAtTown = DataFilter
                        .findChargingStationAtTown(chargingPointList, "Whistler");
                PointDisplayer.showAllAvailablePointsProperties(chargingPointListAtTown);
                break;
            }
        }

    }
}