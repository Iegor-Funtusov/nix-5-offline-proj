import daoclasses.AuthorDao;
import daoclasses.BookDao;
import dataclasses.Author;
import dataclasses.Book;

public class BookManagementService<T> {
    private AuthorDao authorDao = new AuthorDao();
    private BookDao bookDao = new BookDao();

    public void createAuthor(Author author) {
        for (int i = 0; i < authorDao.getAll().length; i++) {
            if (author.equals(authorDao.getAll()[i])) {
                System.out.println("This author already exists!!!");
                return;
            }
        }
        authorDao.create(author);
    }

    public void createBook(Book book, Author... author) {
        for (int i = 0; i < bookDao.getAll().length; i++) {
            if (book.equals(bookDao.getAll()[i])) {
                System.out.println("This book already exists!!!");
                return;
            }
        }
        bookDao.create(book);
        for (int i = 0; i < author.length; i++) {
            setRelation(book, authorDao.getById(author[i].getId()));
        }
    }

    private void setRelation(Book book, Author author) {
        book.setAuthor(author);
        author.setBook(book);
    }

    public Author[] getAllAuthors() {
        return authorDao.getAll();
    }

    public Author getAuthorById(String id) {
        return authorDao.getById(id);
    }

    public Book[] getAllBooks() {
        return bookDao.getAll();
    }

    public Book getBookById(String id) {
        return bookDao.getById(id);
    }

    public void updateAuthor(Author author) {
        authorDao.update(author);
        for (int i = 0; i < author.getBooks().length; i++) {
            setRelation(bookDao.getById(author.getBooks()[i].getId()), author);
        }
    }

    public void updateBook(Book book) {
        bookDao.update(book);
        for (int i = 0; i < book.getAuthors().length; i++) {
            setRelation(book, authorDao.getById(book.getAuthors()[i].getId()));
        }
    }

    public void deleteBook(Book book) {
        bookDao.delete(book.getId());
    }

    public void deleteAuthor(Author author) {
        authorDao.delete(author.getId());
    }
}
