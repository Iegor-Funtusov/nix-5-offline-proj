package ua.com.nix.impl;

import org.apache.log4j.Logger;
import ua.com.nix.Author;
import ua.com.nix.AuthorDao;
import ua.com.nix.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private final Logger logger = Logger.getLogger(AuthorServiceImpl.class);
    private final AuthorDao authorDao = new AuthorDaoImpl();

    @Override
    public List<Author> findByBook(int book) {
        logger.info("Start operation find by bookID + " + book);
        return authorDao.findByBook(book);
    }

    @Override
    public void create(Author author) {
        logger.info("Start create new author" + author.getFirstName() + " " + author.getLastName());
        authorDao.create(author);
        logger.info("Operation successful");
    }

    @Override
    public Author read(int id) {
        Author author = authorDao.findALl().stream().filter(author1 -> author1.getId() == id).findFirst().get();

        logger.info("Start read info about author" + id);
        if(authorDao.isAuthorExist(author.getFirstName(),author.getLastName())){
            logger.info("Operation ssuccessful");
            return authorDao.read(id);
        }
        throw new RuntimeException("Author doesn't exist");
    }

    @Override
    public void update(Author author) {
        logger.info("Start update info about author" + author.getFirstName() + " " + author.getLastName());
        authorDao.update(author);
        logger.info("Operation successful");
    }

    @Override
    public void delete(int id) {
        logger.info("Start delete info about author" + id);
        authorDao.delete(id);
        logger.info("Operation successful");
    }

    @Override
    public List<Author> findAll() {
        logger.info("Start find all authors");
        return authorDao.findALl();
    }

    public Author findAuthorByFirstNameAndLastName(String firstName, String lastName){
        logger.info("Start find author by names");
        return authorDao.findAuthorByFirstNameAndLastName(firstName,lastName);
    }

    public boolean isAuthorExist(Author author){
        return authorDao.isAuthorExist(author.getFirstName(), author.getLastName());
    }

}
