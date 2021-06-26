import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.davidenko.author.Author;
import ua.davidenko.author.AuthorService;
import ua.davidenko.book.Book;
import ua.davidenko.book.BookService;


import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {

    private static AuthorService authorService = new AuthorService();
    private static BookService bookService = new BookService();

    @Test
    @Order(1)
    public void create() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setTitle("bookTitleTest " + i);
            bookService.create(book);
        }
        List<Book> books = bookService.readBooks();
        Assertions.assertTrue(books != null && books.size() == 10);
    }

    @Test
    @Order(2)
    public void find() {
        Book book = new Book();
        book.setTitle("bookTitleTest");
        bookService.create(book);
        Assertions.assertSame(book, bookService.findBookById(book.getBookId()));
    }

    @Test
    @Order(3)
    public void showAllAuthorsOneBook() {
        Book book = new Book();
        book.setTitle("bookTitleTest");
        bookService.create(book);
        Author author = new Author();
        author.setAuthorName("authorNameTest");
        author.setAuthorSurName("authorSurNameTest");
        authorService.create(author);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        authors.add(author);
        book.setAllAuthors(authors);
        Assertions.assertEquals(bookService.readAuthors(book).size(), 2);
    }
    @Test
    @Order(4)
    public void readBooks(){
        List<Book> books = bookService.readBooks();
        int size = books.size();
        Assertions.assertNotEquals(1, size);
    }

}


