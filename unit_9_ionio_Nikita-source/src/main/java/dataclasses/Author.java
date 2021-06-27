package dataclasses;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Author {
    private String id;
    private String firstName;
    private String lastName;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Book[] books = new Book[0];

    public void setBook(Book book) {
        for (Book book1 : books) {
            if (book.getId().equals(book1.getId()))
                return;
        }

        Book[] newBooks = new Book[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
        }
        newBooks[books.length] = book;
        books = newBooks;
    }

    public Author(String id){
        this.id = id;
        this.firstName = "";
        this.lastName = "";
    }

    public Author() {
        this.id = "";
        this.firstName = "";
        this.lastName = "";
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < books.length; i++) {
            s += "\'" + books[i].getTitle() + "\' ";
        }
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", books=[" + s + "]" +
                '}';
    }
}