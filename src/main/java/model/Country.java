package model;

public class Country {
    private int id;
    private String iSOCode;
    private String continentCode;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getiSOCode() {
        return iSOCode;
    }

    public void setiSOCode(String iSOCode) {
        this.iSOCode = iSOCode;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
