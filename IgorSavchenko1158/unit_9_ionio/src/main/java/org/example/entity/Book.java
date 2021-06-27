package org.example.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Book {
    private Long id = -1L;
    private String name;
    private final List<Author> authors = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return List.copyOf(authors);
    }

    public void addAuthors(Collection<Author> authors) {
        if (authors == null || authors.stream().anyMatch(Objects::isNull)) {
            return;
        }
        this.authors.addAll(authors);
    }

    public void addAuthor(Author author) {
        if (author != null) {
            this.authors.add(author);
        }
    }

    @Override
    public String toString() {
        String authors = this.authors.stream().map(a -> a.getFirstName() + " " + a.getLastName()).collect(Collectors.joining(", "));
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, authors);
    }
}
