package ua.com.nix.dao.impl;

import org.apache.commons.beanutils.BeanUtils;
import ua.com.nix.dao.AuthorDao;
import ua.com.nix.model.Author;
import ua.com.nix.model.Book;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AuthorDaoImpl implements AuthorDao {
    static List<Author> authors = new ArrayList<>();
    private static final CSV csv = new CSV();
    @Override
    public void create(Author author) {
        author.setId(UUID.randomUUID().toString());
        authors.add(author);
        csv.writeAuthors();
    }

    @Override
    public void update(Author author) {
        Author currentAuthor = read(author.getId());

        try {
            BeanUtils.copyProperties(currentAuthor, author);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        for (Author author1 : authors) {
            if(author1.getId().equals(currentAuthor.getId()))
            {
                try {
                    BeanUtils.copyProperties(author1, currentAuthor);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        csv.writeAuthors();
        csv.writeBooks();


    }

    @Override
    public void delete(String id) {
        for (Author author : authors) {
            if(author.getId().equals(id))
            {
                author.setInvisible(true);
            }
        }
        csv.writeAuthors();
        csv.writeBooks();
    }


    @Override
    public Author read(String id) {
        List<Author> authors = readAll();
        for (Author author : authors) {
            if(author.getId().equals(id))
                return author;
        }
        return null;
    }

    @Override
    public List<Author> readAll() {
        List<Author> tempAuthors = new ArrayList<>();
        try {
            tempAuthors = csv.readAuthors();

        } catch (IOException e) {
            System.out.println("Anyone book already");
        }
        return tempAuthors;
    }

    @Override
    public List<Book> readAllBooksByAuthor(Author author) {
        return read(author.getId()).getBookList();
    }

}
