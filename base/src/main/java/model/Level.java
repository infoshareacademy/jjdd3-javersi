package model;

public class Level {
    private String title;
    private String comments;
    private boolean isFastChargeCapable;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isFastChargeCapable() {
        return isFastChargeCapable;
    }

    public void setFastChargeCapable(boolean fastChargeCapable) {
        isFastChargeCapable = fastChargeCapable;
    }
}
