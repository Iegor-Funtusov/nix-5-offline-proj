package nix.com.author;

public class Author {

    private String id;
    private String Name;
    private Integer Age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        this.Age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + Name + '\'' +
                ", age=" + Age +
                '}';
    }
}
