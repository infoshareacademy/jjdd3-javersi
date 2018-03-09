package model;

public class StatusType {

    private String title;
    private boolean IsOperational;
    private boolean IsUserSelectable;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOperational() {
        return IsOperational;
    }

    public void setOperational(boolean operational) {
        IsOperational = operational;
    }

    public boolean isUserSelectable() {
        return IsUserSelectable;
    }

    public void setUserSelectable(boolean userSelectable) {
        IsUserSelectable = userSelectable;
    }
}
