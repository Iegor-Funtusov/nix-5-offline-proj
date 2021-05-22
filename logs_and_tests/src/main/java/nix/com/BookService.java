package nix.com;

public class BookService {

    private BookDao bookDao = new BookDao();

    public void create(Book book) {
        bookDao.create(book);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public Book[] readAll() {
        return bookDao.readAll();
    }

    public Book findById(String id) {
        return bookDao.findById(id);
    }

    public void delete(String id) {
        bookDao.delete(id);
    }
}
