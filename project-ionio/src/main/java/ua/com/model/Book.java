package ua.com.model;

import java.util.ArrayList;
import java.util.List;

public class Book extends Entity {

    private String title;
    private List<Author> authorList = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        if (author != null) {
            authorList.add(author);
        }
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> list) {
        this.authorList = list;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + getId() + '\'' +
                "title='" + title + '\'' +
                '}';
    }
}
