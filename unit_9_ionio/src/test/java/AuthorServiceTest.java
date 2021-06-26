import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import ua.davidenko.author.Author;
import ua.davidenko.author.AuthorService;
import ua.davidenko.book.Book;
import ua.davidenko.book.BookService;

import java.util.ArrayList;
import java.util.List;

public class AuthorServiceTest {

    private static AuthorService authorService = new AuthorService();
    private static BookService bookService = new BookService();

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setAuthorName("authorNameTest " + i);
            authorService.create(author);
        }
        List<Author> authors = authorService.readAuthors();
        Assertions.assertTrue(authors != null && authors.size() == 10);
    }
    @Test

    public void readAll(){
        List<Author> authors = authorService.readAuthors();
        int size = authors.size();
        Assertions.assertNotEquals(1, size);
    }

    @Test
    @Order(2)
    public void find() {
        Author author = new Author();
        author.setAuthorName("authorName");
        authorService.create(author);
        Assertions.assertSame(author, authorService.findAuthorById(author.getAuthorId()));
    }

    @Test
    @Order(3)
    public void showAllBooksOneAuthor() {
        Book book = new Book();
        book.setTitle("BookTitleTest");
        bookService.create(book);
        List<Book> books = new ArrayList<>();
        books.add(book);
        Author author = new Author();
        author.setAuthorName("authorNameTest");
        author.setAuthorSurName("authorSureNameTest");
        authorService.create(author);
        author.setAllBooks(books);
        Assertions.assertEquals(authorService.readBooks(author).size(), 1);
    }

    @Test
    @Order(4)
    public void delete() {
        List<Author> authors = authorService.readAuthors();
        for (Author author : authors) {
            authorService.delete(author);
        }
        authors = authorService.readAuthors();
        for (Author author : authors) {
            Assertions.assertNull(author);
        }
    }

}



