package ua.davidenko.author;

import org.apache.commons.beanutils.BeanUtils;
import ua.davidenko.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthorCrud {

    private List<Author> authorsArray = new ArrayList<>();

    private String generateId(String id) {
        if (authorsArray.stream().anyMatch(e -> e.getAuthorId().equals(id))) {
            return generateId(generateId(UUID.randomUUID().toString()));
        }
        return id;
    }

    public void create(Author author) {
        author.setAuthorId(generateId(UUID.randomUUID().toString()));
        authorsArray.add(author);
    }

    public void update(Author author) {
        Author thisAuthor = findByAuthorId(author.getAuthorId());
        try {
            BeanUtils.copyProperties(thisAuthor, author);
        } catch (Exception ex) {
            throw new RuntimeException("Can not update author");
        }
    }

    public void delete(Author author) {
        author.setVisible(false);
    }

    public Author findByAuthorId(String id) {
        Author thisAuthor = authorsArray
                .stream()
                .filter(a -> a.getAuthorId().equals(id))
                .findAny()
                .orElse(null);
        if(thisAuthor == null){
            throw new RuntimeException("Can not find this author");
        }
        return thisAuthor;
    }

    public List<Author> readAuthors() {
        return authorsArray;
    }

    public List<Book> readBooks(Author author) {
        return author.getAllBooks();
    }
}
