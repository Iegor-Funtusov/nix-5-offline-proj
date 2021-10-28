package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repository.BookStoreRepo;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class CommonTest {
    @Test
    void commonTest() throws IOException {
        final BookStoreRepo bookStore = new BookStoreRepo();
        Author author1 = new Author();
        author1.setFirstName("Lev");
        author1.setLastName("Tolstoy");
        bookStore.addAuthor(author1);

        Author author2 = new Author();
        author2.setFirstName("Thomas");
        author2.setLastName("Cormen");
        bookStore.addAuthor(author2);

        Author author3 = new Author();
        author3.setFirstName("Charles");
        author3.setLastName("Leiserson");
        bookStore.addAuthor(author3);

        Book book1 = new Book();
        book1.setName("Voyna i mir");
        book1.addAuthor(author1);
        bookStore.addBook(book1);

        Book book2 = new Book();
        book2.setName("Anna Karenina");
        book2.addAuthor(author1);
        bookStore.addBook(book2);

        Book book3 = new Book();
        book3.setName("Introduction to Algorithms");
        book3.addAuthor(author2);
        bookStore.addBook(book3);

        System.out.println("All authors: " + bookStore.getAllAuthors());
        System.out.println("All books: " + bookStore.getAllBooks());
        System.out.println("=======");
        System.out.println("Assigning Charles Leiserson as author of Intro to Algorithms");
        author3.addBook(book3);
        bookStore.updateAuthor(author3);
        System.out.println("All authors: " + bookStore.getAllAuthors());
        System.out.println("All books: " + bookStore.getAllBooks());
        System.out.println("=======");
        System.out.println("Deleting Lev Tolstoy");
        bookStore.deleteAuthor(author1.getId());
        System.out.println("All authors: " + bookStore.getAllAuthors());
        System.out.println("All books: " + bookStore.getAllBooks());
        System.out.println("=======");
        System.out.println("Deleting Intro to Algorithms");
        bookStore.deleteBook(book3.getId());
        System.out.println("All authors: " + bookStore.getAllAuthors());
        System.out.println("All books: " + bookStore.getAllBooks());
    }
}
