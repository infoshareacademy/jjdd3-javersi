package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, value = {"address_components", "formatted_address", "place_id", "types"})
public class GMapsApiResult {

    private GMapsApiGeometry geometry;

    public GMapsApiGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(GMapsApiGeometry geometry) {
        this.geometry = geometry;
    }
}
