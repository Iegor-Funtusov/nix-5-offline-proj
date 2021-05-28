import org.apache.commons.lang3.RandomStringUtils;

public class Library {
    private String id;
    private Book book;
    private Author author;

    public String getId() {
        return id;
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

    public Library(Book book, Author author) {
        this.book = book;
        this.author = author;
        this.id = RandomStringUtils.randomAlphanumeric(6);
    }

    public Library() {
        this.id = RandomStringUtils.randomAlphanumeric(6);
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
