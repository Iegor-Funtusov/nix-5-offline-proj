package ua.practice.app.entity;

import ua.practice.crud_library.BaseEntity;

public class Author extends BaseEntity {

    private boolean isVisible;

    public Author() {
    }

    public Author(String isVisible) {
        this.isVisible = Boolean.parseBoolean(isVisible);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(String visible) {
        this.isVisible = Boolean.parseBoolean(visible);
    }
}
