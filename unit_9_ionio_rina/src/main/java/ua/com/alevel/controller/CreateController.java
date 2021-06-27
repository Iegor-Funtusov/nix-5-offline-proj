package ua.com.alevel.controller;

import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CreateController {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static AuthorService authorService = new AuthorService();
    static BookService bookService = new BookService();
    public static void createBook(){
        try {
            System.out.println("Enter book ID: ");
            Book book = new Book();
            book.setId(reader.readLine());
            System.out.println("Enter book NAME: ");
            book.setName(reader.readLine());
            List<Author> authors = createAuthorList();
            book.setAuthors(authors);
            for(Author a : authors){
                saveAuthor(a, book);
            }
            bookService.createBook(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveAuthor(Author a, Book book){
        List<Book> books = new ArrayList<>();
        books.add(book);
        if(authorService.readAuthorById(a.getId()) == null){
            a.setBookList(books);
            authorService.createAuthor(a);
        } else {
            Author a1 = authorService.readAuthorById(a.getId());
            books = a1.getBookList();
            books.add(book);
            a.setBookList(books);
            authorService.updateAuthor(a);
        }
    }

    private static List<Author> createAuthorList() throws IOException{
        List<Author> authors = new ArrayList<>();
        System.out.println("Enter number of authors: ");
        int numberOfAuthors = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfAuthors; i++) {
            Author author = createAuthor();
            authors.add(author);
        }
        return authors;
    }

    private static Author createAuthor() throws IOException{
        Author author = new Author();
        System.out.println("Enter author ID: ");
        author.setId(reader.readLine());
        System.out.println("Enter first name: ");
        author.setFirstName(reader.readLine());
        System.out.println("Enter last name: ");
        author.setLastName(reader.readLine());
        return author;
    }
}