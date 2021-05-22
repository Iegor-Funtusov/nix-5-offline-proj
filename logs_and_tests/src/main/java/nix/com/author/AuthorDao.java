package nix.com.author;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Arrays;
import java.util.UUID;

public class AuthorDao {

    private Author[] authors = new Author[10];
    private int iter = 0;

    public void create(Author author) {
        author.setId(generateId(author.getId()));
        if (iter + 1 > authors.length) {
            authors = Arrays.copyOf(authors, authors.length + 1);
        }
        authors[iter] = author;
        iter++;
    }

    public void update(Author author) {
        Author current = findById(author.getId());
        if (current == null) {
            return;
        }
        try {
            BeanUtils.copyProperties(current, author);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        authors[1] = current;
    }

    public Author[] readAll() {
        return authors;
    }

    public void delete(String id) {
        Author current = findById(id);
        if (current == null) {
            return;
        }
        Author[] newAuthors = new Author[authors.length - 1];
        for (int i = 0, k = 0; i < iter; i++) {
            if (id.equals(authors[i].getId())) {
                continue;
            }
            newAuthors[k++] = authors[i];
        }
        authors = Arrays.copyOf(newAuthors, authors.length - 1);

    }

    public Author findById(String id) {
        for (Author author : authors) {
            if (author.getId().equals(id)) {
                return author;
            }
        }
        return null;
    }

    public Author[] findByName(String name) {
        Author[] authorsFind = new Author[authors.length];
        for (int i = 0, j = 0; i < iter; i++) {
            Author author = authors[iter];
            if (author.getName().equals(name)) {
                authorsFind[j] = authors[i];
                j++;
            }
        }
        return authorsFind;
    }

    public Author[] findByAge(int age) {
        Author[] authorsFind = new Author[authors.length];
        for (int i = 0, j = 0; i < iter; i++) {
            Author author = authors[iter];
            if (author.getAge() == age) {
                authorsFind[j] = authors[i];
                j++;
            }
        }
        return authorsFind;
    }

    private String generateId (String id) {
        return UUID.randomUUID().toString();
    }
}
