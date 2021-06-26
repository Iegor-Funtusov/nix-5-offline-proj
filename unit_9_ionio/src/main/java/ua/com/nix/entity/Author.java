package ua.com.nix.entity;

import java.util.List;

public class Author extends BaseEntity {

    private String firstName;
    private String lastName;
    private List<Integer> idBooks;


    public Author(){
        super();
        setType(Type.AUTHOR);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Integer> getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(List<Integer> idBooks) {
        this.idBooks = idBooks;
    }

}
