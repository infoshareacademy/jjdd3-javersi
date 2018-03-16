package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import model.ChargingPoint;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class CustomGsonBuilder {

    public List<ChargingPoint> deserialize(JsonDeserializer jsonDeserializer, String json) {
        Type listType = new TypeToken<LinkedList<ChargingPoint>>() {
        }.getType();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(listType, jsonDeserializer);
        Gson gson = gsonBuilder.create();

        List<ChargingPoint> chargingPoints = gson.fromJson(json, listType);
        return chargingPoints;
    }
}
