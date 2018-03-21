package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GMapsApiGeometry {
    GMapsApiLocation location;

    public GMapsApiLocation getLocation() {
        return location;
    }

    public void setLocation(GMapsApiLocation location) {
        this.location = location;
    }
}
