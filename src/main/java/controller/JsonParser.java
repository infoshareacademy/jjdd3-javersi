package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.ChargingPoint;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class JsonParser {

    public static List<ChargingPoint> jsonToChargingPointList (String json){

        Type listType = new TypeToken<LinkedList<ChargingPoint>>(){}.getType();
        List<ChargingPoint> chargingPoints = new Gson().fromJson(json, listType);
        return  chargingPoints;
    }
}
