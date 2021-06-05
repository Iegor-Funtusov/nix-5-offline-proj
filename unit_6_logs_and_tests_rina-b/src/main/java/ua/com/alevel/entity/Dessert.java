package ua.com.alevel.entity;

public class Dessert {
    private String name;
    private Integer dateOfCreation;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Integer dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dessert{" +
               "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                '}'+ "\n";


    }
}