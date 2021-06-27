package ua.com.alevel.app.service.author;

import ua.com.alevel.app.service.book.BookService;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    private List<BookService> bookServiceList = new ArrayList<>();
    private String id;
    private String name;
    private String lastname;
    private boolean visible = true;

    public List<BookService> getBookList() {
        return bookServiceList;
    }
    public void setBookList(List<BookService> bookServiceList) {
        this.bookServiceList = bookServiceList;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean getVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Author{ID='" + id + "', Name='" + name + "', Lastname='" + lastname + "' | BookList='" + bookServiceList + "', visible='" + visible + "'}";
    }
}
