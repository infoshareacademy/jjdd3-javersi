package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOWN_STATISTICS")
public class TownStatistics {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "numberOfVisits")
    private Long numberOfVisits;

    public TownStatistics() {
    }

    public TownStatistics(String name, Long numberOfVisits) {
        this.name = name;
        this.numberOfVisits = numberOfVisits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(Long numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }
}
