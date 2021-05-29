package nix.com;

import nix.com.author.Author;
import nix.com.author.AuthorService;
import nix.com.author_book.AuthorsWithBooks;
import nix.com.book.Book;
import nix.com.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AppMain {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private static final BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));

    private static final BookService bookService = new BookService();

    private static final AuthorService authorService = new AuthorService();

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println(" " +
                    "Menu\n 1. Add book\n " +
                    "2. Display all book\n " +
                    "3. Find book by id\n " +
                    "4. Update book\n " +
                    "5. Delete book by id\n " +
                    "\n 6. Add author\n " +
                    "7. Display all authors\n " +
                    "8. Find author by id\n " +
                    "9. Update author\n " +
                    "10.Delete author by id\n " +
                    "\n 11. Connect book to author \n " +
                    "12. Connect author to book \n " +
                    "\n 0. Exit");

            String choose = enter.readLine();
            try {
                Integer.parseInt(choose);
            } catch (Exception e) {
                System.out.println("Wrong input");
                continue;
            }

            switch (Integer.parseInt(choose)) {
                case 1:
                    createBook();
                    break;
                case 2:
                    readAllBook();
                    break;
                case 3:
                    System.out.println("Enter id");
                    String id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input id");
                        continue;
                    }
                    try {
                        System.out.println(bookService.findById(id).toString());
                    } catch (Exception e) {
                        System.out.println("Id not found");
                        LOGGER_ERROR.error("Id not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter id for update");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input id");
                        continue;
                    }
                    Book newBook = new Book();
                    System.out.println("Enter new title of book");
                    String newTitle = enter.readLine();
                    System.out.println("Enter new num of pages of book");
                    String newNumPg = enter.readLine();

                    if (newTitle.isBlank() || newNumPg.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input title or num pages");
                        continue;
                    }
                    try {
                        Integer.parseInt(newNumPg);
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input num pages");
                        continue;
                    }
                    try {
                        newBook = bookService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                        LOGGER_ERROR.error("Id not found");
                    }
                    newBook.setTitle(newTitle);
                    newBook.setNumPg(Integer.parseInt(newNumPg));
                    bookService.update(newBook);
                    break;
                case 5:
                    System.out.println("Enter id");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Id not found");
                        continue;
                    }
                    try {
                        bookService.delete(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                    }
                    break;
                case 6:
                    Author author = new Author();
                    System.out.println("Enter name of author");
                    String name = enter.readLine();
                    System.out.println("Enter age of author");
                    String age = enter.readLine();
                    if (name.isBlank() || age.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input name or age");
                        continue;
                    }
                    try {
                        Integer.parseInt(age);
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input age");
                        continue;
                    }
                    author.setName(name);
                    author.setAge(Integer.parseInt(age));
                    authorService.create(author);
                    break;
                case 7:
                    readAllAuthors();
                    break;
                case 8:
                    System.out.println("Enter id");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input id");
                        continue;
                    }
                    try {
                        System.out.println(authorService.findById(id).toString());
                    } catch (Exception e) {
                        System.out.println("Id not found");
                        LOGGER_ERROR.error("Id not found");
                    }
                    break;
                case 9:
                    System.out.println("Enter id");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input id");
                        continue;
                    }
                    Author newAuthor = new Author();
                    System.out.println("Enter new name of author");
                    String newName = enter.readLine();
                    System.out.println("Enter new age of author");
                    String newAge = enter.readLine();

                    if (newName.isBlank() || newAge.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input new name or new age");
                        continue;
                    }
                    try {
                        Integer.parseInt(newAge);
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input new age");
                        continue;
                    }
                    try {
                        newAuthor = authorService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                        LOGGER_ERROR.error("Id not found");
                    }
                    newAuthor.setName(newName);
                    newAuthor.setAge(Integer.parseInt(newAge));
                    authorService.update(newAuthor);
                    break;
                case 10:
                    System.out.println("Enter id");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input id");
                        continue;
                    }
                    try {
                        authorService.delete(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                        LOGGER_ERROR.error("Id not found");
                    }
                    break;
                case 11:
                    System.out.println("Enter id of book");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("Wrong input id");
                        continue;
                    }
                    Book book1 = new Book();
                    try {
                        book1 = bookService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                        LOGGER_ERROR.error("book (11) Wrong input id");
                    }

                    System.out.println("Enter id of author");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("author (11) Wrong input id");
                        continue;
                    }
                    Author author1 = new Author();
                    try {
                        author1 = authorService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                        LOGGER_ERROR.error("author (11) Wrong input id");
                    }
                    if (!authorService.isParamNull(author1) && !bookService.isParamNull(book1)) {
                        AuthorsWithBooks authorsWithBooks = new AuthorsWithBooks(book1, author1);
                        System.out.println(authorsWithBooks);
                    } else {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("author (11) Wrong input id");
                    }
                    break;
                case 12:
                    System.out.println("Enter id of book");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("author (12) Wrong input id");
                        continue;
                    }
                    Book book2 = new Book();
                    try {
                        book1 = bookService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                        LOGGER_ERROR.error("book (12) Wrong input id");
                    }

                    System.out.println("Enter id of author");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("author (12) Wrong input id");
                        continue;
                    }
                    Author author2 = new Author();
                    try {
                        author1 = authorService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                        LOGGER_ERROR.error("author (12) Wrong input id");
                    }
                    if (!authorService.isParamNull(author2) && !bookService.isParamNull(book2)) {
                        AuthorsWithBooks authorsWithBooks = new AuthorsWithBooks(author2, book2);
                        System.out.println(authorsWithBooks);
                    } else {
                        System.out.println("Wrong input");
                        LOGGER_ERROR.error("author (12) Wrong input id");
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void readAllAuthors() {
        Author[] authors = authorService.readAll();
        System.out.println(Arrays.toString(authors));
    }

    private static void readAllBook() {
        Book[] books = bookService.readAll();
        System.out.println(Arrays.toString(books));
    }

    private static void createBook() throws IOException {
        Book book = new Book();
        System.out.println("Enter title of book");
        String title = enter.readLine();
        System.out.println("Enter num of pages of book");
        String numPg = enter.readLine();
        if (title.isBlank() || numPg.isBlank()) {
            System.out.println("Wrong input");
            LOGGER_ERROR.error("create book Wrong input id");
            return;
        }
        try {
            Integer.parseInt(numPg);
        } catch (Exception e) {
            System.out.println("Wrong input");
            LOGGER_ERROR.error("create book Wrong input id");
            return;
        }
        book.setTitle(title);
        book.setNumPg(Integer.parseInt(numPg));
        bookService.create(book);
    }
}
