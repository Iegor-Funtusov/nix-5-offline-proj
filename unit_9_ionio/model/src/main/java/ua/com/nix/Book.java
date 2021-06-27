package ua.com.nix;

import java.util.List;

public class Book extends BaseEntity {

    private String title;
    private List<Integer> idAuthorsList;

    public Book() {
        super();
        setType(Type.BOOK);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getIdAuthorsList() {
        return idAuthorsList;
    }

    public void setIdAuthorsList(List<Integer> idAuthorsList) {
        this.idAuthorsList = idAuthorsList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", idAuthorsList=" + idAuthorsList +
                '}';
    }
}
