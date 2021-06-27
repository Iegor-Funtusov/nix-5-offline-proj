package ua.com.nix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import ua.com.nix.impl.AuthorServiceImpl;
import ua.com.nix.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorBookTest {

    private static final AuthorServiceImpl authorService = new AuthorServiceImpl();
    private static final BookServiceImpl bookService = new BookServiceImpl();
    private static final List<Author> authorList = new LinkedList<>();
    private static final List<Book> bookList = new LinkedList<>();
    private static final Book  book = new Book() ;
    private static final Author author = new Author();

    @Test
    @Order(1)
    public void createAuthorTest() {

        author.setFirstName("Evgeny");
        author.setLastName("Smirnov");
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

        book.setTitle("Kamasutra");
        bookList.add(book);

        for (int i = 0; i< 2; i++){
            Author a = new Author();
            a.setLastName("Magomedov" + i);
            a.setFirstName("David"+i);
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
        authorService.read(author.getId());
    }

    @Test
    @Order(4)
    public void readBookTest() {

        bookService.read(book.getId());

    }

    @Test
    @Order(5)
    public void updateAuthorTest() {

        author.setFirstName("Abdulmanap");
        author.setLastName("Nurmagomedov");
        authorService.update(author);
        Assertions.assertNull(authorService.findAuthorByFirstNameAndLastName("Abdulmanap", "Nurmagomedov"));

    }

    @Test
    @Order(6)
    public void updateBookTest() {

        book.setTitle("Yegor Funtusov - azbuka Scala");
        bookService.update(book);
        Assertions.assertNotNull(bookService.findBookByTitle("Yegor Funtusov - azbuka Scala"));

    }

    @Test
    @Order(7)
    public void deleteAuthorTest(){

        authorService.delete(author.getId());
        Assertions.assertFalse(authorService.isAuthorExist(author));

    }

    @Test
    @Order(8)
    public void deleteBookTest(){

        bookService.delete(book.getId());
        Assertions.assertFalse(bookService.isBookByTitleExist(book.getTitle()));

    }



}
