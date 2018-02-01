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
}
