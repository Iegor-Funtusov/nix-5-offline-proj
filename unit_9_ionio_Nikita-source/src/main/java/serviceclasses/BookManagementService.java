package serviceclasses;

import daoclasses.AuthorDao;
import daoclasses.BookDao;
import dataclasses.Author;
import dataclasses.Book;
import dataclasses.EntityWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookManagementService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private AuthorDao authorDao = new AuthorDao();
    private BookDao bookDao = new BookDao();

    public void createAuthor(Author author) {
        LOGGER_INFO.info("start create author: " + author.getId() + "-" + author.getFirstName());
        for (int i = 0; i < authorDao.getAllAuthors().length; i++) {
            if (author.equals(authorDao.getAllAuthors()[i])) {
                LOGGER_ERROR.error("This author already exists: " + author.getId() + "-" + author.getFirstName());
                return;
            }
        }
        for (int i = 0; i < authorDao.getAllEntities().length; i++) {
            if (author.equals(authorDao.getAllEntities()[i].getEntity())) {
                LOGGER_ERROR.error("Recovering a deleted author: " + author.getId() + "-" + author.getFirstName());
                authorDao.getAllEntities()[i].setDeleted(false);
                return;
            }
        }
        authorDao.create(author);
        LOGGER_INFO.info("end create author: " + author.getId() + "-" + author.getFirstName());
    }

    public void createBook(Book book, Author... author) {
        LOGGER_INFO.info("start create book: " + book.getId() + "-" + book.getTitle());
        for (int i = 0; i < bookDao.getAllBooks().length; i++) {
            if (book.equals(bookDao.getAllBooks()[i])) {
                LOGGER_ERROR.error("This book already exists: " + book.getId() + "-" + book.getTitle());
                return;
            }
        }
        for (int i = 0; i < bookDao.getAllEntities().length; i++) {
            if (author.equals(bookDao.getAllEntities()[i].getEntity())) {
                LOGGER_ERROR.error("Recovering a deleted author: " + book.getId() + "-" + book.getTitle());
                bookDao.getAllEntities()[i].setDeleted(false);
                return;
            }
        }
        bookDao.create(book);
        for (int i = 0; i < author.length; i++) {
            setRelation(book, authorDao.getById(author[i].getId()));
        }
        LOGGER_INFO.info("end create book: " + book.getId() + "-" + book.getTitle());
    }

    public void addBooks(EntityWrapper<Book>[] newBooks){
            bookDao.addBooks(newBooks);
    }

    public void addAuthors(EntityWrapper<Author>[] newAuthors){
            authorDao.addAuthors(newAuthors);
    }

    public void setRelation(Book book, Author author) {
        if (!hasAuthor(author)) {
            LOGGER_ERROR.error("There is no such object: " + author.getId() + "-" + author.getFirstName());
            return;
        }
        if (!hasBook(book)) {
            LOGGER_ERROR.error("There is no such object: " + book.getId() + "-" + book.getTitle());
            return;
        }
        book.setAuthor(author);
        author.setBook(book);
    }

    public Author[] getAllAuthors() {
        LOGGER_INFO.info("get all authors");
        return authorDao.getAllAuthors();
    }

    public EntityWrapper<Author>[] getAllEntityAuthors() {
        LOGGER_INFO.info("get entity all books");
        return authorDao.getAllEntities();
    }

    public Author getAuthorById(String id) {
        LOGGER_INFO.info("get author by ID: " + id);
        return authorDao.getById(id);
    }

    public Book[] getAllBooks() {
        LOGGER_INFO.info("get all books");
        return bookDao.getAllBooks();
    }

    public EntityWrapper<Book>[] getAllEntityBooks() {
        LOGGER_INFO.info("get entity all books");
        return bookDao.getAllEntities();
    }

    public Book getBookById(String id) {
        LOGGER_INFO.info("get book by ID: " + id);
        return bookDao.getById(id);
    }

    public void updateAuthor(Author author) {
        LOGGER_WARN.warn("start update author: " + author.getId() + "-" + author.getFirstName());
        if (!hasAuthor(author)) {
            LOGGER_ERROR.error("There is no such object: " + author.getId() + "-" + author.getFirstName());
            return;
        }
        authorDao.update(author);
        if (author.getBooks().length > 0) {
            for (int i = 0; i < author.getBooks().length; i++) {
                setRelation(bookDao.getById(author.getBooks()[i].getId()), author);
            }
        }
        LOGGER_WARN.warn("end update author: " + author.getId() + "-" + author.getFirstName());
    }

    public void updateBook(Book book) {
        LOGGER_WARN.warn("start update book: " + book.getId() + "-" + book.getTitle());
        if (!hasBook(book)) {
            LOGGER_ERROR.error("There is no such object: " + book.getId() + "-" + book.getTitle());
            return;
        }
        bookDao.update(book);
        for (int i = 0; i < book.getAuthors().length; i++) {
            setRelation(book, authorDao.getById(book.getAuthors()[i].getId()));
        }
        LOGGER_WARN.warn("end update book: " + book.getId() + "-" + book.getTitle());
    }

    public void deleteBook(Book book) {
        LOGGER_WARN.warn("start delete book: " + book.getId() + "-" + book.getTitle());
        if (!hasBook(book)) {
            LOGGER_ERROR.error("There is no such object: " + book.getId() + "-" + book.getTitle());
            return;
        }
        bookDao.delete(book.getId());
        LOGGER_WARN.warn("end delete book: " + book.getId() + "-" + book.getTitle());
    }

    public void deleteAuthor(Author author) {
        LOGGER_WARN.warn("start delete author: " + author.getId() + "-" + author.getFirstName());
        if (!hasAuthor(author)) {
            LOGGER_ERROR.error("There is no such object: " + author.getId() + "-" + author.getFirstName());
            return;
        }
        authorDao.delete(author.getId());
        LOGGER_WARN.warn("end delete author: " + author.getId() + "-" + author.getFirstName());
    }

    public boolean hasBook(Book book) {
        for (int i = 0; i < bookDao.getAllBooks().length; i++) {
            if (bookDao.getAllBooks()[i].equals(book)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAuthor(Author author) {
        for (int i = 0; i < authorDao.getAllAuthors().length; i++) {
            if (authorDao.getAllAuthors()[i].equals(author)) {
                return true;
            }
        }
        return false;
    }
}