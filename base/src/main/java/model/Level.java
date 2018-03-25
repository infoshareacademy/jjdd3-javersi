package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LEVEL")
public class Level {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "comments")
    private String comments;

    @OneToMany(mappedBy = "level", fetch = FetchType.EAGER)
    private List<Connection> connections;

    @Transient
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }
}
