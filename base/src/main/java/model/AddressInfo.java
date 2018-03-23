package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ADDRESS_INFO")
public class AddressInfo {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "town")
    private String town;
    @Column(name = "province")
    private String stateOrProvince;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    @OneToMany(mappedBy = "addressInfo", fetch = FetchType.EAGER)
    private List<ChargingPoint> chargingPoints;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "postcode")
    private String postcode;
    @Column(name = "title")
    private String title;
    @Column(name = "addressLine1")
    private String addressLine1;
    @Column(name = "addressLine2")
    private String addressLine2;

    @Transient
    private String contactTelephone1;
    @Transient
    private String contactTelephone2;
    @Transient
    private String contactEmail;
    @Transient
    private String accessComments;
    @Transient
    private String relatedURL;

    public List<ChargingPoint> getChargingPoints() {
        return chargingPoints;
    }

    public void setChargingPoints(List<ChargingPoint> chargingPoints) {
        this.chargingPoints = chargingPoints;
    }

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
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
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
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }



}
