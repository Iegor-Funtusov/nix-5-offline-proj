package ua.practice.app.entity;

import ua.practice.crud_library.BaseEntity;

public class Book extends BaseEntity{

    private String name;
//    private List<Author> authors;

    private boolean isVisible;

    public Book() {
    }

    public Book(String name, String visible) {
        this.name = name;
        this.isVisible = Boolean.parseBoolean(visible);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getVisible() {
        return isVisible;
    }

    public void setVisible(String visible) {
        this.isVisible = Boolean.parseBoolean(visible);
    }

    @Override
    public String toString() {
        return "Book{" + "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
