package service;

import dao.AuthorDAO;
import dataclasses.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class AuthorService {

    private static final Logger loggerInfo = LoggerFactory.getLogger("info");
    private static final Logger loggerWarn = LoggerFactory.getLogger("warn");
    private static final Logger loggerError = LoggerFactory.getLogger("error");

    private AuthorDAO authorDAO = new AuthorDAO();

    public void createAuthor(Author author) {
        loggerInfo.info("Created author " + author.getFirstName() + " " + author.getLastName());
        if (!author.getLastName().isEmpty()) {
            boolean exist = authorDAO.ifExistLastName(author.getLastName());
            if (exist) {
                loggerError.error("Author already exist " + author.getFirstName() + " " + author.getLastName());
                System.out.println("Author already exist " + author.getFirstName() + " " + author.getLastName());
            } else {
                authorDAO.createAuthor(author);
                System.out.println("Author created " + author.getFirstName() + " " + author.getLastName());
                loggerInfo.info("Author created " + author.getFirstName() + " " + author.getLastName());
            }
        } else {
            loggerError.error("last name can't be empty");
            System.out.println("last name can't be empty");
       }
    }

    public void deleteAuthor(String lastName) {
        Collection<Author> list = authorDAO.findAuthors();
        Author author = checkAuthor(list, lastName);
        if (author != null) {
            loggerWarn.warn("Delete author " + lastName);
            authorDAO.deleteAuthor(author.getAuthorId());
            System.out.println("Author deleted " + author.getFirstName() + " " + author.getLastName());
            loggerWarn.warn("Author deleted "  + author.getFirstName() + " " + author.getLastName());
        } else {
            loggerError.error("Author don't exist" + lastName);
            System.out.println("Author don't exist" + lastName);
        }
    }

    public void updateAuthor(Author author) {
        loggerWarn.warn("Update author " + author.getFirstName() + " " + author.getLastName());
        authorDAO.updateAuthor(author);
        loggerWarn.warn("Author updated " + author.getFirstName() + " " + author.getLastName());
    }

    public Collection<Author> findAuthors() {
        loggerInfo.info("Show all authors ");
        loggerInfo.info(authorDAO.findAuthors().toString());
        return authorDAO.findAuthors();
    }

    public Author checkAuthor(Collection<Author> list, String name) {
        Author bookAuthor = null;
        for (Author author : list) {
            if (author.getLastName().equalsIgnoreCase(name)) {
                bookAuthor = author;
                break;
            }
        }
        return bookAuthor;
    }

    public void errorMessage() {
        loggerError.error("Author don't exist");
        System.out.println("Author don't exist");
    }
}
