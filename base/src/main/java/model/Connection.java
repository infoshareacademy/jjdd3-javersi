package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CONNECTION")
public class Connection {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "level")
    private Level level;

    @ManyToMany(mappedBy = "connectionList")
    private List<ChargingPoint> chargingPointList;

    @Transient
    private ConnectionType connectionType;
    @Transient
    private StatusType statusType;
    @Transient
    private double amps;
    @Transient
    private double voltage;
    @Transient
    private double powerKW;
    @Transient
    private CurrentType currentType;
    @Transient
    private int quantity;
    @Transient
    private String comments;

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public double getAmps() {
        return amps;
    }

    public void setAmps(double amps) {
        this.amps = amps;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getPowerKW() {
        return powerKW;
    }

    public void setPowerKW(double powerKW) {
        this.powerKW = powerKW;
    }

    public CurrentType getCurrentType() {
        return currentType;
    }

    public void setCurrentType(CurrentType currentType) {
        this.currentType = currentType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ChargingPoint> getChargingPointList() {
        return chargingPointList;
    }

    public void setChargingPointList(List<ChargingPoint> chargingPointList) {
        this.chargingPointList = chargingPointList;
    }
}
