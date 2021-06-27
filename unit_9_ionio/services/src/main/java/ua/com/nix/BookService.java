package ua.com.nix;

import java.util.List;

public interface BookService extends BaseTypeService<Book> {

    List<Book> findByAuthor(int author);
    Book findBookByTitle(String title);
}
