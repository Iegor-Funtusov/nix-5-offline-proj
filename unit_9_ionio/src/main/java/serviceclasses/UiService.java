package serviceclasses;

import dataclasses.Author;
import dataclasses.Book;
import dataclasses.EntityWrapper;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UiService {
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BookManagementService managementService = new BookManagementService();

    public static void mainInterface() throws IOException {
        String str;
        do {
            System.out.println("1 Create Author - \"1\"");
            System.out.println("2 Create Book - \"2\"");
            System.out.println("3 Create new Relation \"3\"");
            System.out.println("4 Update Author - \"4\"");
            System.out.println("5 Update Book - \"5\"");
            System.out.println("6 Delete Author - \"6\"");
            System.out.println("7 Delete Book - \"7\"");
            System.out.println("8 Get Author - \"8\"");
            System.out.println("9 Get Book - \"9\"");
            System.out.println("10 Print all Authors - \"10\"");
            System.out.println("11 Print all Books - \"11\"");
            System.out.println("12 AUTO TEST!!! - \"12\"");
            System.out.println("13 Read from file - \"12\"");
            System.out.println("14 Write all objects to file - \"12\"");
            System.out.println("0 Exit - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-1][0-4]") || checkRegExp(str, "[0-9]")) {
                switch (str) {
                    case "1":
                        createAuthor();
                        break;
                    case "2":
                        createBook();
                        break;
                    case "3":
                        setNewRelation();
                        break;
                    case "4":
                        updateAuthor();
                        break;
                    case "5":
                        updateBook();
                        break;
                    case "6":
                        deleteAuthor();
                        break;
                    case "7":
                        deleteBook();
                        break;
                    case "8":
                        findAuthor();
                        break;
                    case "9":
                        findBook();
                        break;
                    case "10":
                        printAuthors();
                        break;
                    case "11":
                        printBooks();
                        break;
                    case "12":
                        generate();
                        break;
                    case "13":
                        readFromFile();
                        break;
                    case "14":
                        writeToFile();
                        break;
                }
            } else {
                System.out.println("Wrong input");
                LOGGER_ERROR.error("Wrong input menu");
            }
        } while (!str.equals("0"));
    }

    private static void createAuthor() throws IOException {
        System.out.println("Please enter the author's name");
        String firstName;
        firstName = reader.readLine();
        if (firstName.isBlank() || firstName.isEmpty()) {
            System.out.println("Wrong input name");
            LOGGER_ERROR.error("Wrong input name");
            return;
        }
        System.out.println("Please enter the author's last name");
        String lastName;
        lastName = reader.readLine();
        if (lastName.isBlank() || lastName.isEmpty()) {
            System.out.println("Wrong input last name");
            LOGGER_ERROR.error("Wrong input last name");
            return;
        }
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        managementService.createAuthor(author);
        System.out.println("You added an author: " + author);
        System.out.println();
    }

    private static void createBook() throws IOException {
        System.out.println("Please enter the book's title");
        String title;
        title = reader.readLine();
        if (title.isBlank() || title.isEmpty()) {
            System.out.println("Wrong input title");
            LOGGER_ERROR.error("Wrong input title");
            return;
        }
        Book book = new Book();
        book.setTitle(title);
        managementService.createBook(book);
        System.out.println("You added a book: " + book);
        System.out.println();
    }

    private static void setNewRelation() throws IOException {
        System.out.println("Attention, you can only create a relationship for existing authors and books!!!");
        System.out.println("Please select a book (\"5\")");
        int num = checkBooksNum();
        if (num == -1) return;
        Book book = managementService.getAllBooks()[num - 1];
        System.out.println("Select the author you want to connect the book with (\"5\")");
        num = checkAuthorsNum();
        if (num == -1) return;
        Author author = managementService.getAllAuthors()[num - 1];
        managementService.setRelation(book, author);
        System.out.println(book);
        System.out.println(author);
        System.out.println();
    }

    private static void updateAuthor() throws IOException {
        System.out.println("Select the author you want to update (\"5\")");
        int num = checkAuthorsNum();
        if (num == -1) return;
        Author author = managementService.getAllAuthors()[num - 1];
        String menu;
        do {
            System.out.println("1 Change name - \"1\"");
            System.out.println("2 Set new Relation - \"2\"");
            System.out.println("3 Delete Relation \"3\"");
            System.out.println("0 Exit - \"0\"");
            menu = reader.readLine();
            if (checkRegExp(menu, "[0-3]")) {
                switch (menu) {
                    case "1":
                        System.out.println("Please enter the author's name");
                        String name;
                        name = reader.readLine();
                        if (name.isBlank() || name.isEmpty()) {
                            System.out.println("Wrong input name");
                            LOGGER_ERROR.error("Wrong input name");
                            return;
                        }
                        author.setFirstName(name);
                        managementService.updateAuthor(author);
                        System.out.println(author);
                        System.out.println();
                        break;
                    case "2":
                        System.out.println("Please select a book (\"5\")");
                        num = checkBooksNum();
                        if (num == -1) return;
                        Book book = managementService.getAllBooks()[num - 1];
                        managementService.setRelation(book, author);
                        System.out.println(book);
                        System.out.println(author);
                        System.out.println();
                        break;
                    case "3":
                        System.out.println("Please select a book (\"5\")");
                        for (int i = 0; i < author.getBooks().length; i++) {
                            System.out.println(i + 1 + " " + author.getBooks()[i]);
                        }
                        String number = reader.readLine();
                        try {
                            Integer.parseInt(number);
                        } catch (Exception e) {
                            System.out.println("Wrong input number");
                            LOGGER_ERROR.error("Wrong input number");
                            return;
                        }
                        num = Integer.parseInt(number);
                        if (num > author.getBooks().length || num <= 0) {
                            System.out.println("Wrong input number");
                            LOGGER_ERROR.error("Wrong input number");
                            return;
                        }
                        if (managementService.hasBook(author.getBooks()[num - 1])) {
                            book = managementService.getBookById(author.getBooks()[num - 1].getId());
                            author.setBooks(ArrayUtils.remove(author.getBooks(), num - 1));
                            for (int i = 0; i < book.getAuthors().length; i++) {
                                if (book.getAuthors()[i].equals(author)) {
                                    num = i;
                                }
                            }
                            book.setAuthors(ArrayUtils.remove(book.getAuthors(), num));
                            managementService.updateAuthor(author);
                            managementService.updateBook(book);
                            System.out.println(author);
                        } else {
                            author.setBooks(ArrayUtils.remove(author.getBooks(), num - 1));
                            managementService.updateAuthor(author);
                            System.out.println(author);
                        }
                        System.out.println();
                        break;
                }
            } else {
                System.out.println("Wrong input");
                LOGGER_ERROR.error("Wrong input menu");
            }
        } while (!menu.equals("0"));
    }

    private static void updateBook() throws IOException {
        System.out.println("Select the book you want to update (\"5\")");
        int num = checkBooksNum();
        if (num == -1) return;
        Book book = managementService.getAllBooks()[num - 1];
        String menu;
        do {
            System.out.println("1 Change title - \"1\"");
            System.out.println("2 Set new Relation - \"2\"");
            System.out.println("3 Delete Relation \"3\"");
            System.out.println("0 Exit - \"0\"");
            menu = reader.readLine();
            if (checkRegExp(menu, "[0-3]")) {
                switch (menu) {
                    case "1":
                        System.out.println("Please enter the book's title");
                        String title;
                        title = reader.readLine();
                        if (title.isBlank() || title.isEmpty()) {
                            System.out.println("Wrong input name");
                            LOGGER_ERROR.error("Wrong input name");
                            return;
                        }
                        book.setTitle(title);
                        managementService.updateBook(book);
                        System.out.println(book);
                        System.out.println();
                        break;
                    case "2":
                        System.out.println("Please select an author (\"5\")");
                        num = checkAuthorsNum();
                        if (num == -1) return;
                        Author author = managementService.getAllAuthors()[num - 1];
                        managementService.setRelation(book, author);
                        System.out.println(book);
                        System.out.println(author);
                        System.out.println();
                        break;
                    case "3":
                        System.out.println("Please select an author (\"5\")");
                        for (int i = 0; i < book.getAuthors().length; i++) {
                            System.out.println(i + 1 + " " + book.getAuthors()[i]);
                        }
                        String number = reader.readLine();
                        try {
                            Integer.parseInt(number);
                        } catch (Exception e) {
                            System.out.println("Wrong input number");
                            LOGGER_ERROR.error("Wrong input number");
                            return;
                        }
                        num = Integer.parseInt(number);
                        if (num > book.getAuthors().length || num <= 0) {
                            System.out.println("Wrong input number");
                            LOGGER_ERROR.error("Wrong input number");
                            return;
                        }
                        if (managementService.hasAuthor(book.getAuthors()[num - 1])) {
                            author = managementService.getAuthorById(book.getAuthors()[num - 1].getId());
                            book.setAuthors(ArrayUtils.remove(book.getAuthors(), num - 1));
                            for (int i = 0; i < author.getBooks().length; i++) {
                                if (author.getBooks()[i].equals(book)) {
                                    num = i;
                                }
                            }
                            author.setBooks(ArrayUtils.remove(author.getBooks(), num));
                            managementService.updateBook(book);
                            managementService.updateAuthor(author);
                            System.out.println(book);
                        } else {
                            book.setAuthors(ArrayUtils.remove(book.getAuthors(), num - 1));
                            managementService.updateBook(book);
                            System.out.println(book);
                        }
                        System.out.println();
                        break;
                }
            } else {
                System.out.println("Wrong input");
                LOGGER_ERROR.error("Wrong input menu");
            }
        } while (!menu.equals("0"));
    }

    private static void deleteAuthor() throws IOException {
        System.out.println("Attention, when you delete an author, it will only be removed from the general list, " +
                "but it will remain in the book entries!!! To delete an entry about an author from a book, " +
                "go to the \"update book\" menu.");
        System.out.println("Select the author you want to delete (\"5\")");
        int num = checkAuthorsNum();
        if (num == -1) return;
        Author author = managementService.getAllAuthors()[num - 1];
        managementService.deleteAuthor(author);
        System.out.println("The author was deleted");
        printAuthors();
    }

    private static void deleteBook() throws IOException {
        System.out.println("Attention, when you delete a book, it will only be removed from the general list, " +
                "but it will remain in the author entries!!! To delete an entry about a book from an author, " +
                "go to the \"update author\" menu.");
        System.out.println("Select the book you want to delete (\"5\")");
        int num = checkBooksNum();
        if (num == -1) return;
        Book book = managementService.getAllBooks()[num - 1];
        managementService.deleteBook(book);
        System.out.println("The book was deleted");
        printBooks();
    }

    private static void findAuthor() throws IOException {
        System.out.println("Enter author ID");
        String id = reader.readLine();
        if (!checkRegExp(id, "^[A-Za-z0-9]+$")) {
            System.out.println("Wrong input ID");
            LOGGER_ERROR.error("Wrong input ID");
            return;
        }
        if (managementService.getAuthorById(id) == null) {
            System.out.println("ID is not exist");
            LOGGER_ERROR.error("ID is not exist");
            return;
        }
        System.out.println(managementService.getAuthorById(id));
        System.out.println();
    }

    private static void findBook() throws IOException {
        System.out.println("Enter book ID");
        String id = reader.readLine();
        if (!checkRegExp(id, "^[A-Za-z0-9]+$")) {
            System.out.println("Wrong input ID");
            LOGGER_ERROR.error("Wrong input ID");
            return;
        }
        if (managementService.getBookById(id) == null) {
            System.out.println("ID is not exist");
            LOGGER_ERROR.error("ID is not exist");
            return;
        }
        System.out.println(managementService.getBookById(id));
        System.out.println();
    }

    private static void printAuthors() {
        for (int i = 0; i < managementService.getAllEntityAuthors().length; i++) {
            System.out.println(i + 1 + " " + managementService.getAllEntityAuthors()[i]);
        }
        System.out.println();
    }

    private static void printBooks() {
        for (int i = 0; i < managementService.getAllEntityBooks().length; i++) {
            System.out.println(i + 1 + " " + managementService.getAllEntityBooks()[i]);
        }
        System.out.println();
    }

    private static int checkAuthorsNum() throws IOException {
        printAuthors();
        String number = reader.readLine();
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            System.out.println("Wrong input number");
            LOGGER_ERROR.error("Wrong input number");
            return -1;
        }
        int num = Integer.parseInt(number);
        if (num > managementService.getAllAuthors().length || num <= 0) {
            System.out.println("Wrong input number");
            LOGGER_ERROR.error("Wrong input number");
            return -1;
        }
        return num;
    }

    private static int checkBooksNum() throws IOException {
        printBooks();
        String number = reader.readLine();
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            System.out.println("Wrong input number");
            LOGGER_ERROR.error("Wrong input number");
            return -1;
        }
        int num = Integer.parseInt(number);
        if (num > managementService.getAllBooks().length || num <= 0) {
            System.out.println("Wrong input number");
            LOGGER_ERROR.error("Wrong input number");
            return -1;
        }
        return num;
    }

    private static void readFromFile(){
        System.out.println("Read from file");
        managementService.addAuthors(CsvIO.CsvAuthorReader());
        managementService.addBooks(CsvIO.CsvBookReader());

        for (EntityWrapper<Book> entityBook : managementService.getAllEntityBooks()) {
            Book tempBook = new Book(entityBook.getEntity().getId());
            tempBook.setTitle(entityBook.getEntity().getTitle());
            for (int i = 0; i < entityBook.getEntity().getAuthors().length; i++) {
                tempBook.setAuthor(managementService.getAuthorById(entityBook.getEntity().getAuthors()[i].getId()));
            }
            managementService.updateBook(tempBook);
        }

        for (EntityWrapper<Author> entityAuthor : managementService.getAllEntityAuthors()) {
            Author tempAuthor = new Author(entityAuthor.getEntity().getId());
            tempAuthor.setFirstName(entityAuthor.getEntity().getFirstName());
            tempAuthor.setLastName(entityAuthor.getEntity().getLastName());
            for (int i = 0; i < entityAuthor.getEntity().getBooks().length; i++) {
                tempAuthor.setBook(managementService.getBookById(entityAuthor.getEntity().getBooks()[i].getId()));
            }
            managementService.updateAuthor(tempAuthor);
        }

        printAuthors();
        printBooks();
    }

    private static void writeToFile(){
        printAuthors();
        printBooks();
        System.out.println("Write to file");
        CsvIO.CsvAuthorWriter(managementService.getAllEntityAuthors());
        CsvIO.CsvBookWriter(managementService.getAllEntityBooks());
    }

    private static void generate() {
        readFromFile();

        System.out.println("Create new authors");
        Author author1 = new Author();
        Author author2 = new Author();
        author1.setFirstName("NEW");
        author1.setLastName("author1");
        author2.setFirstName("NEW");
        author2.setLastName("author2");
        managementService.createAuthor(author1);
        managementService.createAuthor(author2);
        printAuthors();
        System.out.println("Create new Books");
        Book book1 = new Book();
        Book book2 = new Book();
        book1.setTitle("666");
        book2.setTitle("777");
        managementService.createBook(book1);
        managementService.createBook(book2);
        printBooks();
        System.out.println("Update (set relation)");
        managementService.setRelation(book1, author1);
        managementService.setRelation(book1, author2);
        managementService.setRelation(book2, author2);
        printAuthors();
        printBooks();
        System.out.println("Delete Author and Book");
        managementService.deleteAuthor(author1);
        managementService.deleteBook(book1);
        writeToFile();
    }

    private static boolean checkRegExp(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}