package ua.davidenko;

import ua.davidenko.author.Author;
import ua.davidenko.author.AuthorService;
import ua.davidenko.book.Book;
import ua.davidenko.book.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class BookStoreApp {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static AuthorService authorService = new AuthorService();
    static BookService bookService = new BookService();

    public void start() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("1 - Create Book,2 - Update book,3 - Delete book, 4 - Show all books\n" +
                    "5 - Create Author,6 - Update author,7 - Delete author,8 - Show all authors\n" +
                    "9 - Add some authors to one book,10 - Add some books to one author\n" +
                    "11 - Show all books from one author,12 - Show all authors of one book\n" +
                    "13 - Save BookStore to CSV file");
            System.out.println("0 - return to Main menu");
            try {
                String choose = br.readLine();
                switch (choose) {
                    case "1":
                        createBook();
                        break;
                    case "2":
                        updateBook();
                        break;
                    case "3":
                        deleteBook();
                        break;
                    case "4":
                        showAllBooks();
                        break;
                    case "5":
                        createAuthor();
                        break;
                    case "6":
                        updateAuthor();
                        break;
                    case "7":
                        deleteAuthor();
                        break;
                    case "8":
                        showAllAuthors();
                        break;
                    case "9":
                        addAuthorsToOneBook();
                        break;
                    case "10":
                        addBooksToOneAuthor();
                        break;
                    case "11":
                        showAllBooksOneAuthor();

                        break;
                    case "12":
                        showAllAuthorsOneBook();
                        break;
                    case "13":
                        saveToCsvFile();
                        break;
                    case "0":
                       start();
                }
            } catch (IOException e) {
                System.out.println("Wrong input choose");
            }
        }
    }

    private static void createBook() throws IOException {
        System.out.println("Enter a Title of book");
        String bookTitle = br.readLine();
        Book book = new Book();
        book.setTitle(bookTitle);
        bookService.create(book);
    }

    private static void updateBook() throws IOException {
        System.out.println("Enter book Id for update");
        String bookId = br.readLine();
        Book book = bookService.findBookById(bookId);
        System.out.println("Enter new Title for new book");
        String bookTitle = br.readLine();
        book.setTitle(bookTitle);
        bookService.update(bookId);
    }

    private static void deleteBook() throws IOException {
        System.out.println("Enter book Id for delete");
        String bookId = br.readLine();
        bookService.delete(bookService.findBookById(bookId));
    }
    private static void showAllBooks(){
        System.out.println("All Books");
        System.out.println(bookService.readBooks());
    }
    private static void createAuthor() throws IOException {
        System.out.println("Enter author Name");
        String name = br.readLine();
        System.out.println("Enter author SurName");
        String surName = br.readLine();
        Author author= new Author();
        author.setAuthorName(name);
        author.setAuthorSurName(surName);
        authorService.create(author);
    }
    private static void updateAuthor() throws IOException {
        System.out.println("Enter author Id for update");
        String authorId = br.readLine();
        Author author = authorService.findAuthorById(authorId);
        System.out.println("Enter author new Name");
        String newName = br.readLine();
        System.out.println("Enter author new SureName");
        String newSureName = br.readLine();
        author.setAuthorName(newName);
        author.setAuthorSurName(newSureName);
        authorService.update(author);

    }
    private static void deleteAuthor() throws IOException {
        System.out.println("Enter author Id for delete");
        String authorId = br.readLine();
        authorService.delete(authorService.findAuthorById(authorId));
    }
    private static void showAllAuthors(){
        System.out.println("All authors: ");
        System.out.println(authorService.readAuthors());
    }
    private static void addAuthorsToOneBook() throws IOException {
        //List<Author> authors = new ArrayList<>();
        Author[] authors = new Author[5];
        System.out.println("Enter Id first author");
        String firstId = br.readLine();
        System.out.println("Enter Id second author");
        String secondId = br.readLine();
        authors[0] = authorService.findAuthorById(firstId);
        authors[1] = authorService.findAuthorById(secondId);
        System.out.println("Enter Id of book which need add to bouth authors");
        String bookId = br.readLine();
        bookService.findBookById(bookId).setAllAuthors(Arrays.asList(authors));
    }
    private static void addBooksToOneAuthor() throws IOException {
        Book[] books = new Book[5];
        System.out.println("Enter Id first book");
        String firstId = br.readLine();
        System.out.println("Enter Id second book");
        String secondId = br.readLine();
        books[0] = bookService.findBookById(firstId);
        books[1] = bookService.findBookById(secondId);
        System.out.println("Enter Id of author which need add to bouth books");
        String authorId = br.readLine();
        authorService.findAuthorById(authorId).setAllBooks(Arrays.asList(books));
    }
    private static void showAllAuthorsOneBook() throws IOException {
        System.out.println("Enter book Id for show all authors");
        String bookId = br.readLine();
        System.out.println("All authors: ");
        System.out.println(bookService.readAuthors(bookService.findBookById(bookId)));
    }
    private static void showAllBooksOneAuthor() throws IOException {
        System.out.println("Enter author Id for show all books");
        String authorId = br.readLine();
        System.out.println("All books: ");
        System.out.println(authorService.readBooks(authorService.findAuthorById(authorId)));
    }
    private static void saveToCsvFile(){
        List<Book> books = bookService.readBooks();
        List<Author> authors = authorService.readAuthors();
        CvsWriter cvsWriter =  new CvsWriter(books,authors);

    }
}
