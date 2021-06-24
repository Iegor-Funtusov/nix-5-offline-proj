package daoclasses;

import dataclasses.Author;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class AuthorDao {
    Author[] authors = new Author[5];

    public void create(Author author) {
        author.setId(generateId(RandomStringUtils.randomAlphanumeric(6)));
        if (authors[authors.length - 1] == null) {
            authors[getCount()] = author;
        } else {
            Author[] newArray = new Author[authors.length + authors.length / 2];
            for (int i = 0; i < authors.length; i++) {
                newArray[i] = authors[i];
            }
            newArray[authors.length] = author;
            authors = newArray;
        }
    }

    public void update(Author author) {
        Author current = findById(author.getId());
        try {
            BeanUtils.copyProperties(current, author);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void delete(String id) {
        int index = getIndexById(id);
        authors = ArrayUtils.remove(authors, index);
    }

    public Author[] getAll() {
        Author[] authorEntities = new Author[getCount()];
        for (int i = 0; i < authorEntities.length; i++) {
            authorEntities[i] = authors[i];
        }
        return authorEntities;
    }

    private String generateId(String id) {
        for (Author author : authors) {
            if (author != null && author.getId().equals(id)) {
                return generateId(RandomStringUtils.randomAlphanumeric(6));
            }
        }
        return id;
    }

    private Author findById(String id) {
        if (getIndexById(id) == -1) return null;
        return authors[getIndexById(id)];
    }

    public Author getById(String id) {
        return findById(id);
    }

    private int getIndexById(String id) {
        for (int i = 0; i < getCount(); i++) {
            if (authors[i].getId().equals(id)) {
                return i;
            }
        }
        System.out.println("dataclasses.Author with this ID does not exist!!!");
        return -1;
    }

    private int getCount() {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                return i;
            }
        }
        return authors.length;
    }
}