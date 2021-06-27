package ua.com.alevel.app.service.book;

import ua.com.alevel.app.service.author.AuthorService;

import java.util.List;

public class BookCrudFactoryService implements BookCrudService {

    BookCrudService bookCrudService = new BookArrayCrudService();

    @Override
    public void create(BookService bookService) {
        if (!isBookNull(bookService)) {
            bookCrudService.create(bookService);
        } else {
            throw new RuntimeException("book is null");
        }
    }

    @Override
    public void update(String id) {
        if (!isBookNull(findById(id))) {
            bookCrudService.update(id);
        } else {
            throw new RuntimeException("book is null");
        }
    }

    @Override
    public void delete(BookService bookService) {
        if (!isBookNull(bookService)) {
            bookCrudService.delete(bookService);
        } else {
            throw new RuntimeException("book is null");
        }
    }

    @Override
    public List<BookService> read() {
        return bookCrudService.read();
    }

    @Override
    public List<AuthorService> readList(BookService bookService) {
        return bookCrudService.readList(bookService);
    }

    private boolean isBookNull(BookService bookService) {
        return bookService == null || bookService.getTitle() == null || bookService.getTitle().isBlank();
    }

    private BookService findById(String id) {
        BookService current = bookCrudService.read().stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
        if (current == null) {
            throw new RuntimeException("This id does not exist");
        }
        return current;
    }
}
