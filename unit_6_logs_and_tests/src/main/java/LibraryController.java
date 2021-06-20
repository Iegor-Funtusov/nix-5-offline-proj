import dataclasses.Author;
import dataclasses.Book;
import service.AuthorService;
import service.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LibraryController {

    AuthorService authorService = new AuthorService();
    BookService bookService = new BookService();

    public void readConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hi it's library");
        System.out.println("Please input your chose");
        System.out.println("1 - input information");
        System.out.println("2 - show content");
        System.out.println("3 - update information");
        System.out.println("4 - delete information");
        System.out.println("0 - exit");
        String input = reader.readLine();
        while (!"0".equals(input)) {
            switch (input) {
                case "1":
                    createInfo(reader);
                    break;
                case "2":
                    readInfo(reader);
                    break;
                case "3":
                    updateInfo(reader);
                    break;
                case "4":
                    deleteInfo(reader);
                    break;
                default:
                    throw new IllegalArgumentException("Bad input");
            }
            System.out.println("Please input your chose");
            System.out.println("1 - input information");
            System.out.println("2 - show content");
            System.out.println("3 - update information");
            System.out.println("4 - delete information");
            System.out.println("0 - exit");
            input = reader.readLine();
        }
    }

    private void createInfo(BufferedReader reader) throws IOException {
        System.out.println("Please input your chose");
        System.out.println("1 - create author");
        System.out.println("2 - create book");
        System.out.println("0 - exit");
        String input = reader.readLine();
        while (!"0".equals(input)) {
            switch (input) {
                case "1":
                    createAuthor(reader);
                    break;
                case "2":
                    createBook(reader);
                    break;
                default:
                    throw new IllegalArgumentException("Bad input");
            }
            System.out.println("Please input your chose");
            System.out.println("1 - create author");
            System.out.println("2 - create book");
            System.out.println("0 - exit");
            input = reader.readLine();
        }
    }

    private void readInfo(BufferedReader reader) throws IOException {
        System.out.println("Please input your chose");
        System.out.println("1 - show all authors");
        System.out.println("2 - search author");
        System.out.println("3 - show author books");
        System.out.println("4 - search book");
        System.out.println("5 - show all books");
        System.out.println("0 - exit");
        String input = reader.readLine();
        while (!"0".equals(input)) {
            switch (input) {
                case "1":
                    readAllAuthors();
                    break;
                case "2":
                    findAuthor(reader);
                    break;
                case "3":
                    readBooksByAuthor(reader);
                    break;
                case "4":
                    findBook(reader);
                    break;
                case "5":
                    readAllBooks();
                    break;
                default:
                    throw new IllegalArgumentException("Bad input");
            }
            System.out.println("Please input your chose");
            System.out.println("1 - show all authors");
            System.out.println("2 - search author");
            System.out.println("3 - show author books");
            System.out.println("4 - search book");
            System.out.println("5 - show all books");
            System.out.println("0 - exit");
            input = reader.readLine();
        }
    }

    private void updateInfo(BufferedReader reader) throws IOException {
        System.out.println("Please input your chose");
        System.out.println("1 - update author");
        System.out.println("2 - update book");
        System.out.println("0 - exit");
        String input = reader.readLine();
        while (!"0".equals(input)) {
            switch (input) {
                case "1":
                    updateAuthor(reader);
                    break;
                case "2":
                    updateBook(reader);
                    break;
                default:
                    throw new IllegalArgumentException("Bad input");
            }
            System.out.println("Please input your chose");
            System.out.println("1 - update author");
            System.out.println("2 - update book");
            System.out.println("0 - exit");
            input = reader.readLine();
        }
    }

    private void deleteInfo(BufferedReader reader) throws IOException {
        System.out.println("Please input your chose");
        System.out.println("1 - delete author");
        System.out.println("2 - delete book");
        System.out.println("3 - delete all author books");
        System.out.println("0 - exit");
        String input = reader.readLine();
        while (!"0".equals(input)) {
            switch (input) {
                case "1":
                    deleteAuthor(reader);
                    break;
                case "2":
                    deleteBook(reader);
                    break;
                case "3":
                    deleteAllBooks(reader);
                    break;
                default:
                    throw new IllegalArgumentException("Bad input");
            }
            System.out.println("Please input your chose");
            System.out.println("1 - delete author");
            System.out.println("2 - delete book");
            System.out.println("3 - delete all author books");
            System.out.println("0 - exit");
            input = reader.readLine();
        }
    }

    private void createAuthor(BufferedReader reader) throws IOException {
        Author author = new Author();
        System.out.println("input author first name");
        String name = reader.readLine();
        author.setFirstName(name);
        System.out.println("input author last name");
        String surname = reader.readLine();
        author.setLastName(surname);
        authorService.createAuthor(author);
    }

    private void createBook(BufferedReader reader) throws IOException {
        Collection<Author> list = authorService.findAuthors();
        System.out.println("input author last name");
        String name = reader.readLine();
        Author bookAuthor = authorService.checkAuthor(list, name);
        if (bookAuthor != null) {
            Book book = new Book();
            System.out.println("input book name");
            String title = reader.readLine();
            book.setTitle(title);
            System.out.println("input the year of publishing");
            int year = Integer.parseInt(reader.readLine());
            book.setYear(year);
            bookService.createBook(bookAuthor, book);
        } else bookService.errorCreateBookMessage();
    }

    private void readAllAuthors() {
        Collection<Author> list = authorService.findAuthors();
        list.forEach(System.out::println);
    }

    private void readAllBooks() {
        Collection<Author> list = authorService.findAuthors();
        bookService.findBooks(list);
    }

    private void readBooksByAuthor(BufferedReader reader) throws IOException {
        Collection<Author> list = authorService.findAuthors();
        System.out.println("input author last name");
        String name = reader.readLine();
        bookService.findBooks(list, name);
    }

    private void updateAuthor(BufferedReader reader) throws IOException {
        Collection<Author> list = authorService.findAuthors();
        System.out.println("input author last name for update");
        String name = reader.readLine();
        Author bookAuthor = authorService.checkAuthor(list, name);
        if (bookAuthor != null) {
            System.out.println("Please input your chose");
            System.out.println("1 - update author first name");
            System.out.println("2 - update author last name");
            System.out.println("0 - exit");
            String input = reader.readLine();
            while (!"0".equals(input)) {
                switch (input) {
                    case "1":
                        System.out.println("input new first author name");
                        bookAuthor.setFirstName(reader.readLine());
                        authorService.updateAuthor(bookAuthor);
                        break;
                    case "2":
                        System.out.println("input new last author name");
                        bookAuthor.setLastName(reader.readLine());
                        authorService.updateAuthor(bookAuthor);
                        break;
                    default:
                        throw new IllegalArgumentException("Bad input");
                }
                System.out.println("Please input your chose");
                System.out.println("1 - update author first name");
                System.out.println("2 - update author last name");
                System.out.println("0 - exit");
                input = reader.readLine();
            }
            System.out.println("Author updated " + bookAuthor.getLastName() + " " + bookAuthor.getFirstName());
        } else System.out.println("Author don't exist");
    }

    private void updateBook(BufferedReader reader) throws IOException {
        Collection<Author> list = authorService.findAuthors();
        System.out.println("input last author name");
        String name = reader.readLine();
        Author bookAuthor = authorService.checkAuthor(list, name);
        if (bookAuthor != null) {
            System.out.println("input book name");
            String title = reader.readLine();
            Book bookBook = bookService.bookCheck(bookAuthor, title);
            if (bookBook != null) {
                System.out.println("Please input your chose");
                System.out.println("1 - update book name");
                System.out.println("2 - update the year of publishing");
                System.out.println("0 - exit");
                String input = reader.readLine();
                while (!"0".equals(input)) {
                    switch (input) {
                        case "1":
                            System.out.println("input new book name");
                            bookBook.setTitle(reader.readLine());
                            bookService.updateBook(bookAuthor, bookBook);
                            break;
                        case "2":
                            System.out.println("input new the year of publishing");
                            bookBook.setYear(Integer.parseInt(reader.readLine()));
                            bookService.updateBook(bookAuthor, bookBook);
                            break;
                        default:
                            throw new IllegalArgumentException("Bad input");
                    }
                    System.out.println("Please input your chose");
                    System.out.println("1 - update book name");
                    System.out.println("2 - update the year of publishing");
                    System.out.println("0 - exit");
                    input = reader.readLine();
                }
                System.out.println("Book " + "\"" + title + "\"" + " updated");
            } else System.out.println("Book don't exist");
        } else System.out.println("Author don't exist");
    }

    private void deleteAuthor(BufferedReader reader) throws IOException {
        System.out.println("input author last name for delete ");
        String name = reader.readLine();
        authorService.deleteAuthor(name);
    }

    private void deleteBook(BufferedReader reader) throws IOException {
        Collection<Author> list = authorService.findAuthors();
        System.out.println("input author last name");
        String name = reader.readLine();
        Author bookAuthor = authorService.checkAuthor(list, name);
        if (bookAuthor != null) {
            System.out.println("input book name");
            String title = reader.readLine();
            Book bookBook = bookService.bookCheck(bookAuthor, title);
            if (bookBook != null) {
                bookService.deleteBook(bookAuthor, bookBook.getBookId());
                System.out.println("Book " + "\"" + title + "\"" + " deleted");
            } else System.out.println("Book don't exist");
        } else System.out.println("Author don't exist");
    }

    private void deleteAllBooks(BufferedReader reader) throws IOException {
        Collection<Author> list = authorService.findAuthors();
        System.out.println("input author last name");
        String name = reader.readLine();
        Author bookAuthor = authorService.checkAuthor(list, name);
        if (bookAuthor != null) {
            if ((int) Arrays.stream(bookAuthor.getBooks()).filter(Objects::nonNull).count() != 0) {
                for (Book book : bookAuthor.getBooks()) {
                    if (book != null) {
                        bookService.deleteBook(bookAuthor, book.getBookId());
                    }
                }
                System.out.println("Books deleted");
            } else System.out.println("That author dont have books");
        } else System.out.println("Author don't exist");
    }

    private void findAuthor(BufferedReader reader) throws IOException {
        Collection<Author> list = authorService.findAuthors();
        System.out.println("input author last name");
        String name = reader.readLine();
        Author bookAuthor = authorService.checkAuthor(list, name);
        if (bookAuthor != null) {
            System.out.println(bookAuthor);
        } else System.out.println("Author don't exist");
    }

    private void findBook(BufferedReader reader) throws IOException {
        Collection<Author> list = authorService.findAuthors();
        System.out.println("input author last name");
        String name = reader.readLine();
        Author bookAuthor = authorService.checkAuthor(list, name);
        if (bookAuthor != null) {
            System.out.println("input book name");
            String title = reader.readLine();
            Book bookBook = bookService.bookCheck(bookAuthor, title);
            if (bookBook != null) {
                System.out.println(bookBook);
            } else bookService.errorMessage();
        } else System.out.println("Author don't exist");
    }
}
