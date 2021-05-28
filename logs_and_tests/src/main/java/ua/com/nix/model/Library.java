package ua.com.nix.model;

public class Library {
    private String id;
    private Book book;
    private Author author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", author=" + author +
                '}';
    }
}
