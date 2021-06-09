package ua.com.alevel.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Author author = new Author();
    AuthorService authorService = new AuthorService();
    Book book = new Book();
    BookService bookService = new BookService();
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public void main() {
        while (true) {
            System.out.print("1.Author\n" +
                    "2.Book\n" +
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
                    default:
                        System.out.println("You entered invalid characters!");
                        LOGGER_ERROR.error("You entered invalid characters in main!");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You entered invalid characters!");
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
                        author.setName(bufferedReader.readLine());

                        System.out.print("Enter Author lastname: ");
                        author.setLastname(bufferedReader.readLine());

                        authorService.createAuthor(author);
                        LOGGER_INFO.info("End create Author");
                        break;
                    case 2:
                        LOGGER_INFO.info("Start read Author");
                        System.out.println("-------------------------------------------------AUTHOR-------------------------------------------------");
                        System.out.println(authorService.readAuthor().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        LOGGER_INFO.info("End read Author");
                        break;
                    case 3:
                        LOGGER_INFO.info("Start update Author");
                        System.out.print("Enter Author ID: ");
                        String id = bufferedReader.readLine();
                        Author currentAuthor = authorService.readAuthor(id);
                        if (currentAuthor != null) {
                            System.out.print("Enter new Author name: ");
                            String name = bufferedReader.readLine();
                            currentAuthor.setName(name);

                            System.out.print("Enter new Author lastname: ");
                            String lastname = bufferedReader.readLine();
                            currentAuthor.setLastname(lastname);

                            authorService.updateAuthor(currentAuthor);
                        }
                        LOGGER_INFO.info("End update Author");
                        break;
                    case 4:
                        LOGGER_INFO.info("Start delete Author");
                        System.out.print("Enter Author ID: ");
                        id = bufferedReader.readLine();

                        authorService.deleteAuthor(id);
                        System.out.println("Author deleted successfully!");
                        LOGGER_INFO.info("End delete Author");
                        break;
                    case 5:
                        System.out.println("--------------------------------------------------BOOK--------------------------------------------------");
                        System.out.println(bookService.readBook().toString());
                        System.out.println("-------------------------------------------------AUTHOR-------------------------------------------------");
                        System.out.println(authorService.readAuthor().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");

                        LOGGER_INFO.info("Start add an Author to a Book");
                        System.out.print("Enter Book ID: ");
                        id = bufferedReader.readLine();
                        author.addBook(bookService.readBook(id));

                        System.out.print("Enter Author ID: ");
                        id = bufferedReader.readLine();
                        book.addAuthor(authorService.readAuthor(id));
                        LOGGER_INFO.info("End add an Author to a Book");
                        break;
                    case 6:
                        System.out.println("--------------------------------------------------BOOK--------------------------------------------------");
                        System.out.println(bookService.readBook().toString());
                        System.out.println("-------------------------------------------------AUTHOR-------------------------------------------------");
                        System.out.println(authorService.readAuthor().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");

                        LOGGER_INFO.info("Start delete an Author from a Book");
                        System.out.print("Enter Book ID: ");
                        id = bufferedReader.readLine();
                        author.deleteBook(bookService.readBook(id));

                        System.out.print("Enter Author ID: ");
                        id = bufferedReader.readLine();
                        book.deleteAuthor(authorService.readAuthor(id));
                        LOGGER_INFO.info("End delete an Author from a Book");
                        break;
                    case 9:
                        main();
                        break;
                    default:
                        System.out.println("You entered invalid characters!");
                        LOGGER_ERROR.error("You entered invalid characters in Author!");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You entered invalid characters!");
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
                        System.out.print("Enter Book: ");
                        book.setTitle(bufferedReader.readLine());

                        bookService.createBook(book);
                        LOGGER_INFO.info("End create Book");
                        break;
                    case 2:
                        LOGGER_INFO.info("Start read Book");
                        System.out.println("--------------------------------------------------BOOK--------------------------------------------------");
                        System.out.println(bookService.readBook().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                        LOGGER_INFO.info("End read Book");
                        break;
                    case 3:
                        LOGGER_INFO.info("Start update Book");
                        System.out.print("Enter Book ID: ");
                        String id = bufferedReader.readLine();
                        Book currentBook = bookService.readBook(id);
                        if (currentBook != null) {
                            System.out.print("Enter new Book title: ");
                            String title = bufferedReader.readLine();
                            currentBook.setTitle(title);

                            bookService.updateBook(currentBook);
                        }
                        LOGGER_INFO.info("End update Book");
                        break;
                    case 4:
                        LOGGER_WARN.warn("Start delete Book");
                        System.out.print("Enter Book ID: ");
                        id = bufferedReader.readLine();

                        bookService.deleteBook(id);
                        System.out.println("Book deleted successfully!");
                        LOGGER_WARN.warn("End delete Book");
                        break;
                    case 5:
                        System.out.println("-------------------------------------------------AUTHOR-------------------------------------------------");
                        System.out.println(authorService.readAuthor().toString());
                        System.out.println("--------------------------------------------------BOOK--------------------------------------------------");
                        System.out.println(bookService.readBook().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");

                        LOGGER_INFO.info("Start add a Book to an Author");
                        System.out.print("Enter Author ID: ");
                        id = bufferedReader.readLine();
                        book.addAuthor(authorService.readAuthor(id));

                        System.out.print("Enter Book ID: ");
                        id = bufferedReader.readLine();
                        author.addBook(bookService.readBook(id));
                        LOGGER_INFO.info("End add a Book to an Author");
                        break;
                    case 6:
                        System.out.println("-------------------------------------------------AUTHOR-------------------------------------------------");
                        System.out.println(authorService.readAuthor().toString());
                        System.out.println("--------------------------------------------------BOOK--------------------------------------------------");
                        System.out.println(bookService.readBook().toString());
                        System.out.println("--------------------------------------------------------------------------------------------------------");

                        LOGGER_INFO.info("Start delete a Book from an Author");
                        System.out.print("Enter Author ID: ");
                        id = bufferedReader.readLine();
                        book.deleteAuthor(authorService.readAuthor(id));

                        System.out.print("Enter Book ID: ");
                        id = bufferedReader.readLine();
                        author.deleteBook(bookService.readBook(id));
                        LOGGER_INFO.info("End delete a Book from an Author");
                        break;
                    case 9:
                        main();
                        break;
                    default:
                        System.out.println("You entered invalid characters!");
                        LOGGER_ERROR.error("You entered invalid characters in Book!");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You entered invalid characters!");
                LOGGER_ERROR.error("You entered invalid characters in Book!");
            }
        }
    }
}
