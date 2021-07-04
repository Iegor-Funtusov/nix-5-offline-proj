package nix.com.book;

public class Book {

    private String id;
    private String Title;
    private Integer NumPg;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public Integer getNumPg() {
        return NumPg;
    }

    public void setNumPg(Integer numPg) {
        this.NumPg = numPg;
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
                ", title='" + Title + '\'' +
                ", numPg=" + NumPg +
                '}';
    }
}
