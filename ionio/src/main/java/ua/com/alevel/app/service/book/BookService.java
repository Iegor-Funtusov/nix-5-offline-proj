package ua.com.alevel.app.service.book;

import ua.com.alevel.app.service.author.AuthorService;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private List<AuthorService> authorServiceList = new ArrayList<AuthorService>();
    private String id;
    private String title;
    private boolean visible = true;

    public List<AuthorService> getAuthorList() {
        return authorServiceList;
    }
    public void setAuthorList(List<AuthorService> authorServiceList) {
        this.authorServiceList = authorServiceList;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public boolean getVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Book{ID='" + id + "', Title='" + title + "' | AuthorList='" + authorServiceList + "', visible='" + visible + "'}";
    }
}
