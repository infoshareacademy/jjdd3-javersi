package controller;

import model.*;

import java.util.*;

public class JsonParser {

    private CustomGsonBuilder gsonBuilder;

    public JsonParser(CustomGsonBuilder gsonBuilder) {
        this.gsonBuilder = gsonBuilder;
    }

    public List<ChargingPoint> jsonToChargingPointList(String json) {
        List<ChargingPoint> chargingPoints = gsonBuilder.deserialize(new ChargingPointDeserializer(), json);
        return chargingPoints;
    }
}