package ua.com.nix;

import ua.com.nix.model.Author;
import ua.com.nix.model.Book;
import ua.com.nix.service.AuthorService;
import ua.com.nix.service.BookService;

import java.util.List;

public class CommonTest {
    final private AuthorService authorService = new AuthorService();
    final private BookService bookService = new BookService();
    final static private String NAME = "Ivan";
    final static private String LAST_NAME = "Ivanov";
    final static private String NEW_NAME = "Vlad";
    final static private String NEW_LAST_NAME = "Zhytnik";
    final static private String BOOK_NAME = "Book";
    final static private String NEW_BOOK_NAME = "New Book";

    public static void main(String[] args) {
        new CommonTest().test();
    }
    public void test() {
        for (int i = 0; i < 3; i++) {
            Author author = new Author();
            author.setFirstName(NAME + i);
            author.setLastName(LAST_NAME + i);
            authorService.create(author);
        }
        List<Author> authors = authorService.readAll();


        for (int i = 0; i < authors.size(); i++) {
                Book book = new Book();
                book.setTitle(BOOK_NAME + i);
                bookService.create(book,authors.get(i));
        }
        authors = authorService.readAll();
        for (Author author : authors) {
            System.out.println(author);
        }
        Author updatedAuthor = authors.get(0);
        updatedAuthor.setFirstName(NEW_NAME);
        updatedAuthor.setLastName(NEW_LAST_NAME);
        authorService.update(updatedAuthor);
        authorService.readAll();
        for (Author author : authors) {
            System.out.println(author);
        }
        authors = authorService.readAll();
        authorService.delete(authorService.read(authors.get(1).getId()).getId());
        authors = authorService.readAll();
        for (Author author : authors) {
            System.out.println(author);
        }
        System.out.println(authorService.readAllBooksByAuthor(authors.get(0)));
        List<Book> books = bookService.readAll();
        for (Book book : books) {
            System.out.println(book);
        }
        Book updatedBook = bookService.read(books.get(0).getId());
        updatedBook.setTitle(NEW_BOOK_NAME);
        bookService.update(updatedBook);
        books = bookService.readAll();
        for (Book book : books) {
            System.out.println(book);
        }
        bookService.delete(bookService.read(books.get(1).getId()).getId());
        books = bookService.readAll();
        for (Book book : books) {
            System.out.println(book);
        }
        books = bookService.readAll();
        System.out.println(bookService.readAllAuthorsByBook(books.get(1)));

    }

}
