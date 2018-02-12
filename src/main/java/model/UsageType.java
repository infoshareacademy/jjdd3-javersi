package model;

import java.util.Date;

public class UsageType {
    private boolean isPayAtLocation;
    private boolean isMembershipRequired;
    private boolean isAccessKeyRequired;
    private String title;



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

}
