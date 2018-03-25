package dto;

public class ConnectionDto {
    private String levelTitle;
    private String levelComments;
    private int quantity;

    public ConnectionDto(String levelTitle, String levelComments, int quantity) {
        this.levelTitle = levelTitle;
        this.levelComments = levelComments;
        this.quantity = quantity;
    }

    public String getLevelTitle() {
        return levelTitle;
    }

    public void setLevelTitle(String levelTitle) {
        this.levelTitle = levelTitle;
    }

    public String getLevelComments() {
        return levelComments;
    }

    public void setLevelComments(String levelComments) {
        this.levelComments = levelComments;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
