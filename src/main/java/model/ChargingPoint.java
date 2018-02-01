package model;

import java.util.Date;
import java.util.List;

public class ChargingPoint {
    private int id;
    private String uuid;
    private int parentChargePointID;
    private OperatorInfo operatorInfo;
    private UsageType usageType;
    private double usageCost;
    private StatusType statusType;
    private Date dateLastStatusUpdate;
    private int dataQualityLevel;
    private Date dateCreated;
    private List<Connection> connectionList;
    private Date dateLastVerified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getParentChargePointID() {
        return parentChargePointID;
    }

    public void setParentChargePointID(int parentChargePointID) {
        this.parentChargePointID = parentChargePointID;
    }

    public OperatorInfo getOperatorInfo() {
        return operatorInfo;
    }

    public void setOperatorInfo(OperatorInfo operatorInfo) {
        this.operatorInfo = operatorInfo;
    }

    public UsageType getUsageType() {
        return usageType;
    }

    public void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    public double getUsageCost() {
        return usageCost;
    }

    public void setUsageCost(double usageCost) {
        this.usageCost = usageCost;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public Date getDateLastStatusUpdate() {
        return dateLastStatusUpdate;
    }

    public void setDateLastStatusUpdate(Date dateLastStatusUpdate) {
        this.dateLastStatusUpdate = dateLastStatusUpdate;
    }

    public int getDataQualityLevel() {
        return dataQualityLevel;
    }

    public void setDataQualityLevel(int dataQualityLevel) {
        this.dataQualityLevel = dataQualityLevel;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public Date getDateLastVerified() {
        return dateLastVerified;
    }

    public void setDateLastVerified(Date dateLastVerified) {
        this.dateLastVerified = dateLastVerified;
    }
}
