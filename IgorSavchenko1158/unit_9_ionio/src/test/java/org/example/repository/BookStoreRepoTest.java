package org.example.repository;

import org.example.entity.Author;
import org.example.entity.Book;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookStoreRepoTest {

    private static BookStoreRepo bookStore;

    @Test
    @BeforeAll
    static void setUp() throws IOException {
        bookStore = new BookStoreRepo();
        assertTrue(Files.exists(Path.of("library/authors.csv")));
        assertTrue(Files.exists(Path.of("library/books.csv")));
    }

    @Test
    @Order(1)
    void addBookAndGetBookTest() {
        Book book1 = new Book();
        book1.setName("ABC");
        Long id1 = bookStore.addBook(book1);
        Book book2 = new Book();
        book2.setName("DEFG");
        Long id2 = bookStore.addBook(book2);

        assertEquals(book1, bookStore.getBook(id1));
        assertEquals(book2, bookStore.getBook(id2));
    }

    @Test
    @Order(2)
    void updateBook() {
        Book book = new Book();
        book.setName("StartName");
        Long id = bookStore.addBook(book);

        book = new Book();
        book.setId(id);
        book.setName("UpdatedName");
        bookStore.updateBook(book);

        assertEquals(book, bookStore.getBook(id));
    }

    @Test
    @Order(3)
    void deleteBook() {
        Book book = new Book();
        book.setName("StartName");
        Long id = bookStore.addBook(book);

        bookStore.deleteBook(id);

        assertNull(bookStore.getBook(id));
    }

    @Test
    @Order(4)
    void addAuthorAndGetAuthorTest() {
        Author author1 = new Author();
        author1.setFirstName("Ftest1");
        author1.setLastName("Ltest1");
        Long id1 = bookStore.addAuthor(author1);
        Author author2 = new Author();
        author2.setFirstName("Ftest2");
        author2.setLastName("Ltest2");
        Long id2 = bookStore.addAuthor(author2);

        assertEquals(author1, bookStore.getAuthor(id1));
        assertEquals(author2, bookStore.getAuthor(id2));
    }

    @Test
    @Order(5)
    void updateAuthor() {
        Author author = new Author();
        author.setFirstName("Foriginal");
        author.setLastName("Loriginal");
        Long id = bookStore.addAuthor(author);

        author = new Author();
        author.setId(id);
        author.setFirstName("Fupdated");
        author.setLastName("Lupdated");
        bookStore.updateAuthor(author);

        assertEquals(author, bookStore.getAuthor(id));
    }

    @Test
    @Order(6)
    void deleteAuthor() {
        Author author = new Author();
        author.setFirstName("Vova");
        author.setLastName("Vovanov");
        Long id = bookStore.addAuthor(author);

        bookStore.deleteAuthor(id);

        assertNull(bookStore.getAuthor(id));
    }

    @Test
    @Order(7)
    void getAllBooksByAuthor() {
        Author author = new Author();
        author.setFirstName("Lev");
        author.setLastName("Tolstoy");
        bookStore.addAuthor(author);

        Book book1 = new Book();
        book1.setName("Anna Karenina");
        book1.addAuthor(author);
        bookStore.addBook(book1);

        Book book2 = new Book();
        book2.setName("Voyna i mir");
        book2.addAuthor(author);
        bookStore.addBook(book2);

        List<Book> allBooks = bookStore.getAllBooksByAuthor(author.getId());

        assertEquals(2, allBooks.size());
        assertEquals("Anna Karenina", allBooks.get(0).getName());
        assertEquals("Voyna i mir", allBooks.get(1).getName());
    }

    @Test
    @Order(8)
    void getAllAuthorsByBook() {
        Author author1 = new Author();
        author1.setFirstName("Thomas");
        author1.setLastName("Cormen");
        bookStore.addAuthor(author1);

        Author author2 = new Author();
        author2.setFirstName("Charles");
        author2.setLastName("Leiserson");
        bookStore.addAuthor(author2);

        Book book = new Book();
        book.setName("Introduction to Algorithms");
        book.addAuthors(List.of(author1, author2));
        bookStore.addBook(book);

        List<Author> allAuthors = bookStore.getAllAuthorsByBook(book.getId());
        assertEquals(2, allAuthors.size());
        assertEquals("Cormen", allAuthors.get(0).getLastName());
        assertEquals("Leiserson", allAuthors.get(1).getLastName());
    }

}