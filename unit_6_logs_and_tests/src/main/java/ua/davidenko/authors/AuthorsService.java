package ua.davidenko.authors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorsService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    AuthorsArrayCrud authorCrud = new AuthorsArrayCrud();

    public void create(Authors author) {
        if (author != null) {
            LOGGER_INFO.info("Create Author " + author.getAuthorName());
            authorCrud.create(author);
            LOGGER_INFO.info("Author " + author.getAuthorName() + " created");
        } else
            LOGGER_ERROR.error("Author is null");
    }

    public void update(Authors author) {
        if (author != null) {
            LOGGER_INFO.info("Update author " + author.getAuthorName() + author.getAuthorId());
            authorCrud.update(author);
            LOGGER_INFO.info("Author " + author.getAuthorName() + author.getAuthorId() + "is updated");
        } else
            LOGGER_ERROR.error("Author not found");
    }

    public void delete(String id) {
        LOGGER_INFO.info("Author delete");
        authorCrud.delete(id);
        LOGGER_INFO.info("Author is deleted");
    }

    public Authors readById(String id) {
        LOGGER_INFO.info("Read author by Id");
        return authorCrud.read(id);
    }

    public Authors[] readAll() {
        LOGGER_INFO.info("Read all authors");
        return authorCrud.read();
    }
}
