import controller.DataFilter;
import controller.JsonLoader;
import controller.JsonParser;
import model.ChargingPoint;
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
            chargingPointList = JsonParser.jsonToChargingPointList(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu();
        switch (menu.pickOption()) {
            case 1: {
                // wczytac polozenie od uzytkownika

                ChargingPoint chargingPoint = DataFilter.findClosestChargingStation(chargingPointList,10,10);
            }
            case 2: {
                List<ChargingPoint> chargingPointListAtArea = DataFilter.findChargingStationAtArea(chargingPointList,10,10,5);
            }
            case 3: {
            //    List<ChargingPoint> chargingPointListAtTown = DataFilter.findChargingStationAtTown(chargingPointList,"Warszawa","Poland");

                ChargingPoint chargingPoint = DataFilter.findClosestChargingStation(chargingPointList, 10, 10);

            }
        }
    }
}