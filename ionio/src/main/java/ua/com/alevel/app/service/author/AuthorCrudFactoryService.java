package ua.com.alevel.app.service.author;

import ua.com.alevel.app.service.book.BookService;

import java.util.List;

public class AuthorCrudFactoryService implements AuthorCrudService {

    AuthorCrudService authorCrudService = new AuthorArrayCrudService();
    @Override
    public void create(AuthorService authorService) {
        if (!isAuthorNull(authorService)) {
            authorCrudService.create(authorService);
        } else {
            throw new RuntimeException("author is null");
        }
    }

    @Override
    public void update(AuthorService authorService) {
        if (!isAuthorNull(authorService)) {
            authorCrudService.update(authorService);
        }else {
            throw new RuntimeException("author is null");
        }
    }

    @Override
    public void delete(AuthorService authorService) {
        if (!isAuthorNull(authorService)) {
            authorCrudService.delete(authorService);
        }else {
            throw new RuntimeException("author is null");
        }
    }

    @Override
    public List<AuthorService> read() {
        return authorCrudService.read();
    }

    @Override
    public List<BookService> readList(AuthorService authorService) {
        return authorCrudService.readList(authorService);
    }

    private boolean isAuthorNull(AuthorService authorService) {
        return authorCrudService == null || authorService.getName().isBlank() || authorService.getLastname().isBlank();
    }
}
