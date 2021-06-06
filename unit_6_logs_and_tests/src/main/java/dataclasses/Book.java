package dataclasses;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Book {
    private String id;
    private String title;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Author[] authors = new Author[0];

    public void setAuthor(Author author) {
        for (Author author1 : authors) {
            if (author.getId().equals(author1.getId())) return;
        }

        Author[] newAuthors = new Author[authors.length + 1];
        for (int i = 0; i < authors.length; i++) {
            newAuthors[i] = authors[i];
        }
        newAuthors[authors.length] = author;
        authors = newAuthors;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < authors.length; i++) {
            s += "\'" + authors[i].getName() + "\' ";
        }
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", authors=[" + s + "]" +
                '}';
    }
}
