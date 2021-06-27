package ua.com.nix;

import java.util.List;

public interface AuthorService extends BaseTypeService<Author>{
    List<Author> findByBook(int book);
    boolean isAuthorExist(Author author);
}
