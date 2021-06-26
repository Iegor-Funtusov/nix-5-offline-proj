package ua.com.nix.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Book implements Serializable {
    @Expose
    private String id;
    @Expose
    private String title;

    private Author authorForBook;
    @Expose
    private boolean invisible;

    public boolean isInvisible()  {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    @JsonBackReference
    public Author getAuthorForBook() {
        return authorForBook;
    }

    public void setAuthorForBook(Author authorForBook) {
        this.authorForBook = authorForBook;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
