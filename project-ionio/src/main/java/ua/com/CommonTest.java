package ua.com;

import ua.com.csv.AuthorCSVService;
import ua.com.csv.BookCSVService;
import ua.com.csv.BooksAndAuthorsCSVService;
import ua.com.model.Author;
import ua.com.model.Book;

public class CommonTest {
    public static void main(String[] args) {
        BookCSVService bookCSV = new BookCSVService();
        AuthorCSVService authorCSV = new AuthorCSVService();
        BooksAndAuthorsCSVService booksAndAuthorsCSVService = new BooksAndAuthorsCSVService();
        Author author1 = new Author("William", "Shakespeare");
        Author author2 = new Author("Jack", "London");
        Author author3 = new Author("Lev", "Tolstoy");
        Author author4 = new Author("Nick", "Slavko");
        Author author5 = new Author("Roman", "Ihnatov");
        Book book1 = new Book("Romeo and Juliet");
        Book book2 = new Book("White Fang");
        Book book3 = new Book("War and Peace");
        bookCSV.create(book1);
        bookCSV.create(book2);
        bookCSV.create(book3);
        authorCSV.create(author1);
        authorCSV.create(author2);
        authorCSV.create(author3);
        authorCSV.create(author4);
        booksAndAuthorsCSVService.create(book1,author1);
        booksAndAuthorsCSVService.create(book2,author2);
        booksAndAuthorsCSVService.create(book2,author4);
        booksAndAuthorsCSVService.create(book2,author5); //Author does not exist
        booksAndAuthorsCSVService.create(book2,author3);
        booksAndAuthorsCSVService.create(book3,author3);
        bookCSV.delete(book1.getId());
        authorCSV.delete(author1.getId());
        booksAndAuthorsCSVService.delete(book3.getId(), author3.getId());
        book2.setTitle("Test");
        bookCSV.update(book2);
        System.out.println(bookCSV.read(book2.getId()));
        System.out.println(booksAndAuthorsCSVService.readBookAuthors(book2.getId()));
        System.out.println(booksAndAuthorsCSVService.readAuthorBooks(author4.getId()));
    }
}
