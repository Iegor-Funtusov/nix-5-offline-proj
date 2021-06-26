package ua.davidenko.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.davidenko.book.Book;

import java.util.List;

public class AuthorService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

   static AuthorCrud authorCrud = new AuthorCrud();

   public void create(Author author) {
        if (author != null) {
            LOGGER_INFO.info("Create Author " + author.getAuthorName() + author.getAuthorSurName());
            authorCrud.create(author);
        } else
            LOGGER_ERROR.error("Author is null");
    }

    public void update(Author author) {
        if (author != null) {
            LOGGER_INFO.info("Update author " + author.getAuthorName() + author.getAuthorSurName() + author.getAuthorId());
            authorCrud.update(author);
            LOGGER_INFO.info("Author " + author.getAuthorName() + author.getAuthorSurName() + author.getAuthorId() + "is updated");
        } else
            LOGGER_ERROR.error("Author not found");
    }

    public void delete(Author author) {
        if (author != null) {
            LOGGER_INFO.info("Author deleting");
            authorCrud.delete(author);
            LOGGER_INFO.info("Author is deleted");
        } else
            LOGGER_ERROR.error("Author not found");
    }
    public  Author findAuthorById(String id) {
        Author current = authorCrud.readAuthors().stream().filter(e -> e.getAuthorId().equals(id)).findAny().orElse(null);
        if (current == null) {
            throw new RuntimeException("This id does not exist");
        }
        return current;
    }

    public List<Author> readAuthors() {
        LOGGER_INFO.info("Read all authors");
        return authorCrud.readAuthors();
    }

    public List<Book> readBooks(Author author){
        LOGGER_INFO.info("Read books from one author");
        return authorCrud.readBooks(author);
    }


}
