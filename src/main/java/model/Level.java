package model;

public class Level {
    private int id;
    private String title;
    private String comments;
    private boolean isFastChargeCapable;

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
