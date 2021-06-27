package ua.com.nix;

import java.util.List;

public interface BookDao extends AbstractDao<Book>{
    List<Book> findByAuthor(int idAuthor);
    Book findBookByTitle(String title);
    boolean isBookByTitleExist(String title);
}
