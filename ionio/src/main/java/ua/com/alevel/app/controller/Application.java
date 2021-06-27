package ua.com.alevel.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.app.dao.Csv;
import ua.com.alevel.app.service.author.AuthorCrudFactoryService;
import ua.com.alevel.app.service.author.AuthorService;
import ua.com.alevel.app.service.book.BookCrudFactoryService;
import ua.com.alevel.app.service.book.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String EXCEPTION = "You entered invalid characters!";
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private static final AuthorCrudFactoryService authorCrudFactoryService = new AuthorCrudFactoryService();
    private static final BookCrudFactoryService bookCrudFactoryService = new BookCrudFactoryService();
    AuthorService authorService = new AuthorService();
    BookService bookService = new BookService();
    List<BookService> books = new ArrayList<>();
    List<AuthorService> authors = new ArrayList<>();

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public void main() {
        while (true) {
            System.out.print("1.Author\n" +
                    "2.Book\n" +
                    "3.Save AuthorAndBook to CSV\n" +
                    "Exit(0)\n" +
                    "Select a level number or press 0 to exit: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                        author();
                        break;
                    case 2:
                        book();
                        break;
                    case 3:
                        authors = authorCrudFactoryService.read();
                        books = bookCrudFactoryService.read();
                        try {
                            new Csv(books, authors);
                        } catch (RuntimeException ex) {
                            System.out.println("AuthorAndBook is not exist!");
                        }
                        break;
                    default:
                        System.out.println(EXCEPTION);
                        LOGGER_ERROR.error("You entered invalid characters in main!");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println(EXCEPTION);
                LOGGER_ERROR.error("You entered invalid characters in main!");
            }
        }
    }

    public void author() {
        while (true) {
            System.out.print("*************************************************AUTHOR*************************************************\n" +
                    "1.Create Author\n" +
                    "2.Read Author\n" +
                    "3.Update Author\n" +
                    "4.Delete Author\n" +
                    "5.Add a Book by id\n" +
                    "6.Delete a Book by id\n" +
                    "Back(9)\n" +
                    "Exit(0)\n" +
                    "Select a level number or press 0 to exit: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                        LOGGER_INFO.info("Start create Author");
                        System.out.print("Enter Author name: ");
                        try {
                            String name = bufferedReader.readLine();
                            System.out.print("Enter Author lastname: ");
                            String lastName = bufferedReader.readLine();

                            authorService.setName(name);
                            authorService.setLastname(lastName);
                            authorCrudFactoryService.create(authorService);
                        } catch (IOException | RuntimeException e) {
                            System.out.println(EXCEPTION);
                        }
                        System.out.println("Author created successfully!");
                        LOGGER_INFO.info("End create Author");
                        break;
                    case 2:
                        LOGGER_INFO.info("Start read Author");
                        System.out.println("-------------------------------------------------AUTHOR-------------------------------------------------");
                        System.out.println(authorCrudFactoryService.read().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        LOGGER_INFO.info("End read Author");
                        break;
                    case 3:
                        LOGGER_INFO.info("Start update Author");
                        System.out.print("Enter Author ID: ");
                        try {
                            String id = bufferedReader.readLine();
                            System.out.print("Enter Author new name: ");
                            String firstName = bufferedReader.readLine();
                            System.out.print("Enter Author new lastname: ");
                            String lastName = bufferedReader.readLine();
                            AuthorService authorService = findByIdAuthor(id);
                            authorService.setName(firstName);
                            authorService.setLastname(lastName);

                            authorCrudFactoryService.update(findByIdAuthor(id));
                        } catch (IOException | RuntimeException e) {
                            System.out.println(EXCEPTION);
                        }
                        LOGGER_INFO.info("End update Author");
                        break;
                    case 4:
                        LOGGER_INFO.info("Start delete Author");
                        System.out.print("Enter Author ID: ");
                        try {
                            String id = bufferedReader.readLine();
                            authorCrudFactoryService.delete(findByIdAuthor(id));
                        } catch (IOException | RuntimeException e) {
                            System.out.println(EXCEPTION);
                        }
                        System.out.println("Author deleted successfully!");
                        LOGGER_INFO.info("End delete Author");
                        break;
                    case 5:
                        System.out.println("--------------------------------------------------BOOK--------------------------------------------------");
                        System.out.println(bookCrudFactoryService.read().toString());
                        System.out.println("-------------------------------------------------AUTHOR-------------------------------------------------");
                        System.out.println(authorCrudFactoryService.read().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");

                        LOGGER_INFO.info("Start add an Author to a Book");
                        System.out.print("Stop(s)\nEnter Book ID: ");
                        try {
                            while (true) {
                                String id = bufferedReader.readLine();
                                if (id.equals("s")) {
                                    break;
                                }
                                books.add(findByIdBook(id));
                            }
                            System.out.print("Enter id an Author to add a Book: ");
                            String id = bufferedReader.readLine();
                            findByIdAuthor(id).setBookList(books);
                        } catch (IOException | RuntimeException e) {
                            System.out.println(EXCEPTION);
                        }
                        LOGGER_INFO.info("End add an Author to a Book");
                        break;
                    case 6:
                        System.out.println("--------------------------------------------------BOOK--------------------------------------------------");
                        System.out.println(bookCrudFactoryService.read().toString());
                        System.out.println("-------------------------------------------------AUTHOR-------------------------------------------------");
                        System.out.println(authorCrudFactoryService.read().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");

                        LOGGER_INFO.info("Start delete an Author from a Book");

                        System.out.print("Stop(s)\nEnter Book ID: ");
                        try {
                            while (true) {
                                String id = bufferedReader.readLine();
                                if (id.equals("s")) {
                                    break;
                                }
                                books.remove(findByIdBook(id));
                            }
                            System.out.print("Enter id an Author to remove a Book: ");
                            String id = bufferedReader.readLine();
                            findByIdAuthor(id).setBookList(books);
                        } catch (IOException | RuntimeException e) {
                            System.out.println(EXCEPTION);
                        }
                        LOGGER_INFO.info("End delete an Author from a Book");
                        break;
                    case 9:
                        main();
                        break;
                    default:
                        System.out.println(EXCEPTION);
                        LOGGER_ERROR.error("You entered invalid characters in Author!");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println(EXCEPTION);
                LOGGER_ERROR.error("You entered invalid characters in Author!");
            }
        }
    }

    public void book() {
        while (true) {
            System.out.print("**************************************************BOOK**************************************************\n" +
                    "1.Create Book\n" +
                    "2.Read Book\n" +
                    "3.Update Book\n" +
                    "4.Delete Book\n" +
                    "5.Add a Author by id\n" +
                    "6.Delete a Author by id\n" +
                    "Back(9)\n" +
                    "Exit(0)\n" +
                    "Select a level number or press 0 to exit: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                        LOGGER_INFO.info("Start create Book");
                        System.out.print("Enter Book title: ");
                        try {
                            String title = bufferedReader.readLine();
                            bookService.setTitle(title);
                            bookCrudFactoryService.create(bookService);
                        } catch (IOException | RuntimeException e) {
                            System.out.println(EXCEPTION);
                        }
                        System.out.println("Book created successfully!");
                        LOGGER_INFO.info("End create Book");
                        break;
                    case 2:
                        LOGGER_INFO.info("Start read Book");
                        System.out.println("--------------------------------------------------BOOK--------------------------------------------------");
                        System.out.println(bookCrudFactoryService.read().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        LOGGER_INFO.info("End read Book");
                        break;
                    case 3:
                        System.out.println("Enter id of book");
                        try {
                            String id = bufferedReader.readLine();
                            System.out.print("Enter new title: ");
                            String title = bufferedReader.readLine();
                            BookService bookService = findByIdBook(id);
                            bookService.setTitle(title);

                            bookCrudFactoryService.update(String.valueOf(findByIdBook(id)));
                        } catch (IOException | RuntimeException e) {
                            System.out.println(EXCEPTION);
                        }
                        LOGGER_INFO.info("End update Book");
                        break;
                    case 4:
                        LOGGER_WARN.warn("Start delete Book");
                        System.out.print("Enter Book ID: ");
                        try {
                            String id = bufferedReader.readLine();
                            bookCrudFactoryService.delete(findByIdBook(id));
                        } catch (IOException | RuntimeException e) {
                            System.out.println(EXCEPTION);
                        }
                        System.out.println("Book deleted successfully!");
                        LOGGER_WARN.warn("End delete Book");
                        break;
                    case 5:
                        System.out.println("-------------------------------------------------AUTHOR-------------------------------------------------");
                        System.out.println(authorCrudFactoryService.read().toString());
                        System.out.println("--------------------------------------------------BOOK--------------------------------------------------");
                        System.out.println(bookCrudFactoryService.read().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");

                        LOGGER_INFO.info("Start add a Book to an Author");
                        System.out.print("Stop(s)\nEnter Author ID: ");
                        try {
                            while (true) {
                                String id = bufferedReader.readLine();
                                if (id.equals("s")) {
                                    break;
                                }
                                authors.add(findByIdAuthor(id));
                            }
                            System.out.print("Enter id a Book to add an Author: ");
                            String id = bufferedReader.readLine();
                            findByIdBook(id).setAuthorList(authors);
                        } catch (IOException | RuntimeException e) {
                            System.out.println(EXCEPTION);
                        }
                        LOGGER_INFO.info("End add a Book to an Author");
                        break;
                    case 6:
                        System.out.println("-------------------------------------------------AUTHOR-------------------------------------------------");
                        System.out.println(authorCrudFactoryService.read().toString());
                        System.out.println("--------------------------------------------------BOOK--------------------------------------------------");
                        System.out.println(bookCrudFactoryService.read().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");

                        LOGGER_INFO.info("Start delete a Book from an Author");
                        System.out.print("Stop(s)\nEnter Author ID: ");
                        try {
                            while (true) {
                                String id = bufferedReader.readLine();
                                if (id.equals("s")) {
                                    break;
                                }
                                authors.remove(findByIdAuthor(id));
                            }
                            System.out.print("Enter id a Book to remove an Author: ");
                            String id = bufferedReader.readLine();
                            findByIdBook(id).setAuthorList(authors);
                        } catch (IOException | RuntimeException e) {
                            System.out.println(EXCEPTION);
                        }
                        LOGGER_INFO.info("End delete a Book from an Author");
                        break;
                    case 9:
                        main();
                        break;
                    default:
                        System.out.println(EXCEPTION);
                        LOGGER_ERROR.error("You entered invalid characters in Book!");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println(EXCEPTION);
                LOGGER_ERROR.error("You entered invalid characters in Book!");
            }
        }
    }

    private static AuthorService findByIdAuthor(String id) {
        AuthorService current = authorCrudFactoryService.read().stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
        if (current == null) {
            throw new RuntimeException("Author is not exist!");
        }
        return current;
    }

    private static BookService findByIdBook(String id) {
        BookService current = bookCrudFactoryService.read().stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
        if (current == null) {
            throw new RuntimeException("Book is not exist!");
        }
        return current;
    }
}