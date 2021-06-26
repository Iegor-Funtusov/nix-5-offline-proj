package ua.practice.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ua.practice.app.dao.dao_impl.AuthorDaoImpl;
import ua.practice.app.dao.dao_impl.BookDaoImpl;
import ua.practice.app.entity.Author;
import ua.practice.app.entity.Book;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CommonTest {
    static List<Author> authors = new ArrayList<>();
    static List<Book> books = new ArrayList<>();
    static AuthorDaoImpl authorDao = new AuthorDaoImpl();
    static BookDaoImpl bookDao = new BookDaoImpl();

    @AfterAll
    static void afterAll() {
        File file = new File("Author_database.csv");
        file.delete();
        File file1 = new File("Book_database.csv");
        file1.delete();
    }

    @Test
    void testApp(){
        for (int i = 0; i < 4; i++) {
            Book book = new Book();
            book.setName("book name" + i);
            books.add(book);
        }
        for (int i = 0; i < 4; i++) {
            Author author = new Author("name" + i, "lname" + i);
            author.setBooks(books.subList(0, i));
            authors.add(author);
        }
        authors.forEach(authorDao::create);
        books.forEach(bookDao::create);
        assertEquals(authors.size(), authorDao.read().size());
        assertEquals(books.size(), bookDao.read().size());
        Author author = authors.get(2);
        author.setLastName("New");
        authorDao.update(author);
        assertEquals(author, authorDao.read(author.getId()));
        Book book = books.get(2);
        book.setName("New");
        bookDao.update(book);
        assertEquals(book, bookDao.read(book.getId()));
        authorDao.delete(author.getId());
        assertEquals(authors.size()-1, authorDao.read().size());
        bookDao.delete(book.getId());
        assertEquals(books.size()-1, bookDao.read().size());
        assertThrows(RuntimeException.class, ()->authorDao.read(author.getId()));
        assertThrows(RuntimeException.class, ()->bookDao.read(book.getId()));


    }
}
