package ua.com.nix.entity;

import java.util.Date;

public abstract class BaseEntity {
    private int id;
    private boolean visible;
    private Date dateOfCreated;
    private Type type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Date getDateOfCreated() {
        return dateOfCreated;
    }

    public void setDateOfCreated(Date dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BaseEntity() {
        dateOfCreated = new Date();
        visible = true;
    }
}
