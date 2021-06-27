package ua.com.nix;

import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import ua.com.nix.impl.AuthorServiceImpl;
import ua.com.nix.impl.BookServiceImpl;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommonTest {

    private static final AuthorServiceImpl authorService = new AuthorServiceImpl();
    private static final BookServiceImpl bookService = new BookServiceImpl();
    private static final List<Author> authorList = new LinkedList<>();
    private static final List<Book> bookList = new LinkedList<>();

    @BeforeAll
    public static void init() {
        int num = 5;
        Random random = new Random();

        for (int i = 0; i < num; i++) {
            String firstName = "Evgeny" + i;
            String lastName = "Smirnov" + i;

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            authorList.add(author);
            for(int j = 0; j< 2; j++){
                Book b = new Book();
                String title = "testBook" + random.nextInt(200);
                b.setTitle(title);
                b.setIdAuthorsList(Collections.singletonList(author.getId()));
                bookList.add(b);
                bookService.create(b);
            }

            List<Integer> idBooks = new ArrayList<>();
            for (Book book : bookList) {
                idBooks.add(book.getId());
            }
            author.setIdBooks(idBooks);
            authorService.create(author);
        }
        Assertions.assertTrue(CollectionUtils.isNotEmpty(authorService.findAll()));
    }

    @Test
    @Order(1)
    public void createAuthorTest(){
        Author author = new Author();
        author.setFirstName("Yevhen");
        author.setLastName("Smirnenko");
        authorList.add(author);
        for (int i = 0; i< 2; i++){
            Book b = new Book();
            b.setTitle("test" + i);
            b.setIdAuthorsList(Collections.singletonList(author.getId()));
            bookList.add(b);
        }
        List<Integer> idBooks = new ArrayList<>();
        for (Book book : bookList) {
            idBooks.add(book.getId());
        }
        author.setIdBooks(idBooks);
        authorService.create(author);

        Assertions.assertTrue(authorService.isAuthorExist(author));
    }

    @Test
    @Order(2)
    public void createBookTest(){
        Book book = new Book();
        book.setTitle("Knigga");
        bookList.add(book);
        for (int i = 0; i< 2; i++){
            Author a = new Author();
            a.setLastName("test1" + i);
            a.setFirstName("test2"+i);
            a.setIdBooks(Collections.singletonList(book.getId()));
            authorList.add(a);
        }

        List<Integer> idAuthors = new ArrayList<>();
        for (Author a : authorList) {
            idAuthors.add(a.getId());
        }
        book.setIdAuthorsList(idAuthors);
        bookService.create(book);

        Assertions.assertTrue(bookService.isBookByTitleExist(book.getTitle()));
    }

    @Test
    @Order(3)
    public void readAuthorTest(){
        Author a = authorService.findAuthorByFirstNameAndLastName("Yevhen2","Test2");
        authorService.read(a.getId());
    }

    @Test
    @Order(4)
    public void readBookTest(){
        Book b = bookService.findBookByTitle("testBook2");
        bookService.read(b.getId());
    }

    @Test
    @Order(5)
    public void updateAuthorTest(){

        Author a = authorService.findAuthorByFirstNameAndLastName("Yevhen2","Test2");
        a.setFirstName("Iv");
        a.setLastName("Mrafasga");
        authorService.update(a);
        Assertions.assertNotNull(authorService.findAuthorByFirstNameAndLastName("Aggegwg", "kgrkekg"));
    }

    @Test
    @Order(6)
    public void updateBookTest(){
        Book b = bookService.findBookByTitle("testBook2");
        b.setTitle("hghkgkh");
        bookService.update(b);
        Assertions.assertNotNull(bookService.findBookByTitle("hghkgkh"));
    }

    @Test
    @Order(7)
    public void deleteAuthorTest(){

        Author a = authorService.findAuthorByFirstNameAndLastName("Yevhen2","Test2");
        authorService.delete(a.getId());
        Assertions.assertFalse(authorService.isAuthorExist(a));
    }

    @Test
    @Order(8)
    public void deleteBookTest(){
        Book b = bookService.findBookByTitle("testBook2");
        bookService.delete(b.getId());
        Assertions.assertFalse(bookService.isBookByTitleExist(b.getTitle()));
    }
}
