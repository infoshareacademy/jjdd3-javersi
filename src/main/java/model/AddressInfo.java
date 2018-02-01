package model;

public class AddressInfo {
    private int id;
    private String title;
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String StateOrProvince;
    private String Postcode;
    private int countryID;
    private String stateOrProvince;
    private Country country;
    private double latitude;
    private double longitude;
    private String contactTelephone1;
    private String contactTelephone2;
    private String contactEmail;
    private String accessComments;
    private String relatedURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStateOrProvince() {
        return StateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        StateOrProvince = stateOrProvince;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getContactTelephone1() {
        return contactTelephone1;
    }

    public void setContactTelephone1(String contactTelephone1) {
        this.contactTelephone1 = contactTelephone1;
    }

    public String getContactTelephone2() {
        return contactTelephone2;
    }

    public void setContactTelephone2(String contactTelephone2) {
        this.contactTelephone2 = contactTelephone2;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getAccessComments() {
        return accessComments;
    }

    public void setAccessComments(String accessComments) {
        this.accessComments = accessComments;
    }

    public String getRelatedURL() {
        return relatedURL;
    }

    public void setRelatedURL(String relatedURL) {
        this.relatedURL = relatedURL;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }
}
