package model;

public class StatusType {
    private int id;
    private String title;
    private boolean IsOperational;
    private boolean IsUserSelectable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
