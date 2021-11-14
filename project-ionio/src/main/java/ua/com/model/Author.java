package ua.com.model;

import java.util.ArrayList;
import java.util.List;

public class Author extends Entity {
    private String firstName;
    private String lastName;
    private final List<Book> bookList = new ArrayList<>();

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void addBook(Book book){
        if(book!=null){
            bookList.add(book);
        }
    }

    public List<Book> getBookList(){
        return bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + getId() + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
