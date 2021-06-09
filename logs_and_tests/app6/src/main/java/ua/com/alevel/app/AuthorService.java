package ua.com.alevel.app;

import ua.com.alevel.lib.ArrayCrudService;
import ua.com.alevel.lib.CrudFactory;

public class AuthorService {
    private static final ArrayCrudService<Author> authorCrudService = new ArrayCrudService<>();

    public void createAuthor(Author author) {
        authorCrudService.create(author);
    }
    public Author readAuthor(String id) {
        return authorCrudService.read(id);
    }
    public void updateAuthor(Author author) {
        authorCrudService.update(author);
    }
    public void deleteAuthor(String id) {
        authorCrudService.delete(id);
    }
    public CrudFactory readAuthor() {
        return authorCrudService.read();
    }
}
