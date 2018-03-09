package controller;

public enum Units {
    METRES(1000),
    KILOMETRES(1),
    MILES(1 / 1.609344);

    double converter;

    public double getConverter() {
        return converter;
    }

    Units(double converter) {
        this.converter = converter;
    }
}
