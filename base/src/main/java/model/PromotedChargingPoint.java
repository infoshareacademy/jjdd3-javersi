package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROMOTED_CHARGING_POINTS")
public class PromotedChargingPoint {

    //Charging point id is not a foreign key to id of charging point id
    // to prevent problems when updating data from api.
    @Id
    @Column(name = "charging_point_id")
    private int chargingPointId;

    public int getChargingPointId() {
        return chargingPointId;
    }

    public void setChargingPointId(int chargingPointId) {
        this.chargingPointId = chargingPointId;
    }
}
