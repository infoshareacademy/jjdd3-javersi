package controller;


public class UrlBuilder {
    private String url;

    public UrlBuilder(String url) {
        this.url = url;
    }

    public UrlBuilder addParameterToUrl(String key, String value) {
        url += (url.contains("?")) ? "&" : "?";
        url += key;
        url += "=";
        url += value;

        return this;
    }

    @Override
    public String toString() {
        return url;
    }
}
