import dataclasses.Author;
import dataclasses.Book;
import org.junit.jupiter.api.*;
import service.AuthorService;
import service.BookService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LibraryControllerTest {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static AuthorService authorService = new AuthorService();
    private static BookService bookService = new BookService();

    @BeforeAll
    public static void setUp() {
        System.out.println(ANSI_GREEN + "\nTests start: \n" + ANSI_RESET);

        for (int i = 0; i < 5; i++) {
            Author author = new Author();
            author.setFirstName("Author" + i);
            author.setLastName("Author" + i);
            authorService.createAuthor(author);
        }

        Author author = new Author();
        author.setFirstName("Jonat");
        author.setLastName("John");
        authorService.createAuthor(author);

        author = new Author();
        author.setFirstName("Gordon");
        author.setLastName("Fisherman");
        authorService.createAuthor(author);

        Collection<Author> authors = authorService.findAuthors();
        Assertions.assertEquals(authors.size(), 7);
    }

    @Test
    @Order(1)
    public void createBooks() {
        Collection<Author> authors = authorService.findAuthors();
        Author author = authorService.checkAuthor(authors, "John");
        if (author != null) {
            Book book = new Book();
            book.setTitle("Fly to the moon");
            book.setYear(1960);
            bookService.createBook(author, book);
        }
        author = authorService.checkAuthor(authors, "Fisherman");
        if (author != null) {
            Book book = new Book();
            book.setTitle("Words nad dogs");
            book.setYear(1965);
            bookService.createBook(author, book);
        }
        if (author != null) {
            Book book = new Book();
            book.setTitle("That a new book");
            book.setYear(1969);
            bookService.createBook(author, book);
        }
        Collection<Book> books = bookService.findBooks(authors, "Fisherman");
        Assertions.assertEquals(books.size(), 2);
    }

    @Test
    @Order(2)
    public void createAuthor() {
        Author author = new Author();
        author.setFirstName("Art");
        author.setLastName("Ant");
        authorService.createAuthor(author);

        author = new Author();
        author.setFirstName("Lisa");
        author.setLastName("Bonz");
        authorService.createAuthor(author);

        Collection<Author> authors = authorService.findAuthors();
        Assertions.assertEquals(authors.size(), 9);
    }

    @Test
    @Order(3)
    public void findAllAuthors() {
        Collection<Author> authors = authorService.findAuthors();
        Assertions.assertEquals(authors.size(), 9);
    }

    @Test
    @Order(4)
    public void createBook() {
        Collection<Author> authors = authorService.findAuthors();
        Author author = authorService.checkAuthor(authors, "John");
        if (author != null) {
            Book book = new Book();
            book.setTitle("Fly to the moon");
            book.setYear(2001);
            bookService.createBook(author, book);
            Collection<Book> books = bookService.findBooks(authors, "John");
            Assertions.assertEquals(books.size(), 2);
        }
    }

    @Test
    @Order(5)
    public void updateAuthor() {
        Collection<Author> authors = authorService.findAuthors();
        for (Author author : authors) {
            if (author.getLastName().equals("Bonz")) {
                author.setFirstName("Lisa");
                author.setLastName("Bonz");
                authorService.updateAuthor(author);
                Assertions.assertEquals("Bonz", author.getLastName());
            }
        }
    }

    @Test
    @Order(6)
    public void removeAuthor() {
       authorService.deleteAuthor("Ant");
       Collection<Author> authors = authorService.findAuthors();
       Assertions.assertEquals(authors.size(), 8);
    }

    @Test
    @Order(7)
    public void removeBook() {
        Collection<Author> authors = authorService.findAuthors();
        Author author = authorService.checkAuthor(authors, "John");
        if (author != null) {
            Book book = bookService.bookCheck(author, "Fly to the moon");
            if (book != null) {
                bookService.deleteBook(author, book.getBookId());
            }
            Assertions.assertNull(author.getBooks()[1]);
        }
    }

    @Test
    @Order(8)
    public void removeAllBooksOfAuthor() {
        Collection<Author> authors = authorService.findAuthors();
        Author author = authorService.checkAuthor(authors, "Fisherman");
        if (author != null) {
            if ((int) Arrays.stream(author.getBooks()).filter(Objects::nonNull).count() != 0) {
                for (Book book : author.getBooks()) {
                    if (book != null) {
                        bookService.deleteBook(author, book.getBookId());
                    }
                }
            }
        } else authorService.errorMessage();
        Collection<Book> books = bookService.findBooks(authors, "Fisherman");
        Assertions.assertNull(books);
    }

    @Test
    @Order(9)
    public void createAuthorEmptyLastName() {
        Author author = new Author();
        author.setFirstName("Zolda");
        author.setLastName("");
        authorService.createAuthor(author);
        Collection<Author> authors = authorService.findAuthors();
        Assertions.assertEquals(authors.size(), 8);
    }

    @Test
    @Order(10)
    public void createAuthorExist() {
        Author author = new Author();
        author.setFirstName("Zolda");
        author.setLastName("John");
        authorService.createAuthor(author);
        Collection<Author> authors = authorService.findAuthors();
        Assertions.assertEquals(authors.size(), 8);
    }

    @Test
    @Order(11)
    public void createBookExist() {
        Collection<Author> authors = authorService.findAuthors();
        Author author = authorService.checkAuthor(authors, "John");
        if (author != null) {
            Book book = new Book();
            book.setTitle("Sea");
            book.setYear(1960);
            bookService.createBook(author, book);
            Collection<Book> books = bookService.findBooks(authors, author.getLastName());
            Assertions.assertEquals(books.size(), 1);
        }
    }

    @Test
    @Order(12)
    public void createBookAuthorNotExist() {
        Collection<Author> authors = authorService.findAuthors();
        Author author = authorService.checkAuthor(authors, "Ant");
        if (author != null) {
            Book book = new Book();
            book.setTitle("Ships");
            book.setYear(1979);
            bookService.createBook(author, book);
            Collection<Book> books = bookService.findBooks(authors);
            Assertions.assertEquals(books.size(), 3);
        }
    }

    @Test
    @Order(13)
    public void deleteBookNotExist() {
        Collection<Author> authors = authorService.findAuthors();
        Author author = authorService.checkAuthor(authors, "John");
        if (author != null) {
            Book book = bookService.bookCheck(author, "Fly to the moon");
            if (book != null) {
                bookService.deleteBook(author, book.getBookId());
            } else bookService.errorMessage();
            Collection<Book> books = bookService.findBooks(authors, author.getLastName());
            Assertions.assertEquals(books.size(), 1);
        }
    }

    @Test
    @Order(14)
    public void createBookTitleNotExist() {
        Collection<Author> authors = authorService.findAuthors();
        Author author = authorService.checkAuthor(authors, "John");
        if (author != null) {
            Book book = new Book();
            book.setTitle("");
            book.setYear(1979);
            bookService.createBook(author, book);
            Collection<Book> books = bookService.findBooks(authors, author.getLastName());
            Assertions.assertEquals(books.size(), 1);
        }
    }

    @Test
    @Order(15)
    public void findAllBooks() {
        Collection<Author> authors = authorService.findAuthors();
        Collection<Book> books = bookService.findBooks(authors);
        Assertions.assertEquals(books.size(), 3);
    }

    @AfterAll
    public static void close() {
        System.out.println(ANSI_GREEN + "\nTests finished \n" + ANSI_RESET);
    }
}
