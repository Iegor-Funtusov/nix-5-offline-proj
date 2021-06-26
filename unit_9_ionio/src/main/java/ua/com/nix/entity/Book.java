package ua.com.nix.entity;

import java.util.List;

public class Book extends BaseEntity{

    private String title;
    private List<Integer> idAuthorsList;

    public Book(){
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

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer idAuth: idAuthorsList) {
            stringBuilder.append(idAuth).append(";");
        }
        return "Book: " + title + " . Authors: " + stringBuilder.toString() ;
    }

}
