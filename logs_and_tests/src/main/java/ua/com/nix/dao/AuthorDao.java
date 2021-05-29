package ua.com.nix.dao;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.nix.model.Author;
import ua.com.nix.model.Library;

import java.util.Arrays;
import java.util.UUID;

public class AuthorDao {
    LibraryDao libraryDao = new LibraryDao();
    private int capacity = 0;
    private static int size = 10;

    private static Author[] authors = new Author[size];
    public void create(Author author) {
        if (capacity + 1 > authors.length) {
            size = (authors.length +1);
            authors = Arrays.copyOf(authors, size);
        }
        author.setId(UUID.randomUUID().toString());
        authors[capacity]=author;
        capacity++;
    }

    public Author[] findAll() {
        return Arrays.stream(authors)
                .filter(author -> author != null)
                .toArray(Author[]::new);
    }

    public void update(Author author) {
        Author currentAuthor = findById(author.getId());
        try {
            BeanUtils.copyProperties(currentAuthor, author);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

    }

    public Author findById(String id) {
        for (Author author : authors) {
            if (author.getId().equals(id)) {
                return author;
            }
        }
        return null;
    }

    public void delete(String id) {
        Author current = findById(id);
        if (current == null) {
            return;
        }
        int countNulls = 0;
        for(int i=0;i<authors.length;i++)
        {
            if(authors[i].getId().equals(id))
            {
                authors[i]=null;
                break;
            }
        }
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                countNulls++;
            }
        }
        Author[] tempAuthors = new Author[authors.length - countNulls];
        for (int i = 0, j = 0; i < authors.length; i++) {
            if (authors[i] != null) {
                tempAuthors[j] = authors[i];
                j++;
            }
        }
        authors=tempAuthors;
        Library[] libraries = libraryDao.findAll();
        for (int i = 0; i < libraries.length; i++) {
            if(id.equals(libraries[i].getAuthor().getId()))
            {
                libraries[i].setAuthor(null);
            }
        }
    }
}
