package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTRY")
public class Country {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<AddressInfo> addresses;

    @Transient
    private String isoCode;
    @Transient
    private String continentCode;

    public List<AddressInfo> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressInfo> addresses) {
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
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
