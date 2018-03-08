package controller;

import com.google.gson.Gson;
import model.ChargingPoint;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonParserTest {

    @Test
    void jsonToChargingPointListOne() throws IOException {

        String json = new String(Files.readAllBytes(Paths.get(getClass()
                .getClassLoader().getResource("jsonParserTests/testChargingPointOne.json").getPath())));

        ChargingPoint point = new Gson().fromJson(json, ChargingPoint.class);

        assertAll("point",
                () -> assertEquals(99562, point.getId(), "ID: "),
                () -> assertEquals("75E21538-5A47-4A8E-995A-7D07B02EEE5F", point.getUuid(), "UUID: ")
        );
    }

    @Test
    void jsonToChargingPointListTwo() throws IOException {

        String json = new String(Files.readAllBytes(Paths.get(getClass()
                .getClassLoader().getResource("jsonParserTests/testChargingPointTwo.json").getPath())));

        ChargingPoint point = new Gson().fromJson(json, ChargingPoint.class);

        assertAll("point",
                () -> assertEquals(99559, point.getId(), "ID: "),
                () -> assertEquals("99D22B9B-B787-4105-8236-D3871F99F9F3", point.getUuid(), "UUID: ")
        );
    }
}