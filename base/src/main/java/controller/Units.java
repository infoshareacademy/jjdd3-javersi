package controller;

public enum Units {
    METERS(1000),
    KILOMETERS(1),
    MILES(1 / 1.609344);

    double converter;

    public double getConverter() {
        return converter;
    }

    Units(double converter) {
        this.converter = converter;
    }
}
