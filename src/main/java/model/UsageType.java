package model;

import java.util.Date;

public class UsageType {
    private int id;
    private boolean isPayAtLocation;
    private boolean isMembershipRequired;
    private boolean isAccessKeyRequired;
    private String title;
    private int numberOfPoints;
    private String generalComments;
    private Date datePlanned;
    private Date dateLastConfirmed;
}
