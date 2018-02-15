package controller;

public enum Units {
    metres(1000),
    kilometres(1),
    miles(1 / 1.609344);

    double converter;

    public double getConverter() {
        return converter;
    }

    Units(double converter) {
        this.converter = converter;
    }
}
