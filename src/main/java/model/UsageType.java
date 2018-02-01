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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPayAtLocation() {
        return isPayAtLocation;
    }

    public void setPayAtLocation(boolean payAtLocation) {
        isPayAtLocation = payAtLocation;
    }

    public boolean isMembershipRequired() {
        return isMembershipRequired;
    }

    public void setMembershipRequired(boolean membershipRequired) {
        isMembershipRequired = membershipRequired;
    }

    public boolean isAccessKeyRequired() {
        return isAccessKeyRequired;
    }

    public void setAccessKeyRequired(boolean accessKeyRequired) {
        isAccessKeyRequired = accessKeyRequired;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public String getGeneralComments() {
        return generalComments;
    }

    public void setGeneralComments(String generalComments) {
        this.generalComments = generalComments;
    }

    public Date getDatePlanned() {
        return datePlanned;
    }

    public void setDatePlanned(Date datePlanned) {
        this.datePlanned = datePlanned;
    }

    public Date getDateLastConfirmed() {
        return dateLastConfirmed;
    }

    public void setDateLastConfirmed(Date dateLastConfirmed) {
        this.dateLastConfirmed = dateLastConfirmed;
    }
}
