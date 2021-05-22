package nix.com;

public class Book {

    private String id;
    private String title;
    private Integer numPg;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumPg() {
        return numPg;
    }

    public void setNumPg(Integer numPg) {
        this.numPg = numPg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", numPg=" + numPg +
                '}';
    }
}
