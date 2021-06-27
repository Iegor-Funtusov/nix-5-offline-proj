package ua.com.nix;

import java.util.Date;

public abstract class BaseEntity {

    private int id;
    private Date dateOfCreated;
    private Type type;
    private boolean visible;

    public BaseEntity() {
        dateOfCreated = new Date();
        visible = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


}
