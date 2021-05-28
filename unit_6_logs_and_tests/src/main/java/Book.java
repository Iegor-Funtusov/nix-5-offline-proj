import org.apache.commons.lang3.RandomStringUtils;

public class Book {
    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(String title) {
        this.title = title;
        this.id = RandomStringUtils.randomAlphanumeric(6);
    }

    public Book() {
        this.id = RandomStringUtils.randomAlphanumeric(6);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
