import org.apache.commons.lang3.RandomStringUtils;

public class Author {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
        this.id = RandomStringUtils.randomAlphanumeric(6);
    }

    public Author() {
        this.id = RandomStringUtils.randomAlphanumeric(6);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
