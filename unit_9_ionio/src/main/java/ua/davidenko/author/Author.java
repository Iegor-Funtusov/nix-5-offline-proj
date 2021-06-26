package ua.davidenko.author;

import ua.davidenko.book.Book;

import java.util.List;

public class Author {
    private String authorId;
    private String authorName;
    private String authorSurName;
    private List<Book> allBooks;
    private boolean visible;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurName() {
        return authorSurName;
    }

    public void setAuthorSurName(String authorSurName) {
        this.authorSurName = authorSurName;
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId='" + authorId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorSurName='" + authorSurName + '\'' +
                ", allBooks=" + allBooks +
                ", visible=" + visible +
                '}';
    }
}

