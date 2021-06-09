package ua.com.alevel.app;

import ua.com.alevel.lib.ArrayCrudService;
import ua.com.alevel.lib.CrudFactory;

public class BookService {
    private static final ArrayCrudService<Book> bookCrudService = new ArrayCrudService<>();

    public void createBook(Book book) {
        bookCrudService.create(book);
    }
    public Book readBook(String id) {
        return bookCrudService.read(id);
    }
    public void updateBook(Book book) {
        bookCrudService.update(book);
    }
    public void deleteBook(String id) {
        bookCrudService.delete(id);
    }
    public CrudFactory readBook() {
        return bookCrudService.read();
    }
}
