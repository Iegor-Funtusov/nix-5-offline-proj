package nix.com;

import nix.com.author.Author;
import nix.com.author.AuthorService;
import nix.com.author_book.AuthorsWithBooks;
import nix.com.book.Book;
import nix.com.book.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AppMain {
    private static BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
    private static String choose;
    private static String id;

    private static BookService bookService = new BookService();
    private static Book book;
    private static Book[] books;
    private static String title;
    private static String numPg;

    private static AuthorService authorService = new AuthorService();
    private static Author author;
    private static Author[] authors;
    private static String name;
    private static String age;

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

            choose = enter.readLine();
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
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    try {
                        System.out.println(bookService.findById(id).toString());
                    } catch (Exception e) {
                        System.out.println("Id not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter id for update");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    Book newBook = new Book();
                    System.out.println("Enter new title of book");
                    String newTitle = enter.readLine();
                    System.out.println("Enter new num of pages of book");
                    String newNumPg = enter.readLine();

                    if (newTitle.isBlank() || newNumPg.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    try {
                        Integer.parseInt(newNumPg);
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    try {
                        newBook = bookService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
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
                        continue;
                    }
                    try {
                        bookService.delete(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                    }
                    break;
                case 6:
                    author = new Author();
                    System.out.println("Enter name of author");
                    name = enter.readLine();
                    System.out.println("Enter age of author");
                    age = enter.readLine();
                    if (name.isBlank() || age.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    try {
                        Integer.parseInt(age);
                    } catch (Exception e) {
                        System.out.println("Wrong input");
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
                        continue;
                    }
                    try {
                        System.out.println(authorService.findById(id).toString());
                    } catch (Exception e) {
                        System.out.println("Id not found");
                    }
                    break;
                case 9:
                    System.out.println("Enter id");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    Author newAuthor = new Author();
                    System.out.println("Enter new name of author");
                    String newName = enter.readLine();
                    System.out.println("Enter new age of author");
                    String newAge = enter.readLine();

                    if (newName.isBlank() || newAge.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    try {
                        Integer.parseInt(newAge);
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    try {
                        newAuthor = authorService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
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
                        continue;
                    }
                    try {
                        authorService.delete(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                    }
                    break;
                case 11:
                    System.out.println("Enter id of book");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    Book book1 = new Book();
                    try {
                        book1 = bookService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                    }

                    System.out.println("Enter id of author");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    Author author1 = new Author();
                    try {
                        author1 = authorService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                    }
                    if (!authorService.isParamNull(author1) && !bookService.isParamNull(book1)) {
                        AuthorsWithBooks authorsWithBooks = new AuthorsWithBooks(book1, author1);
                        System.out.println(authorsWithBooks);
                    } else {
                        System.out.println("Wrong input");
                    }
                    break;
                case 12:
                    System.out.println("Enter id of book");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    Book book2 = new Book();
                    try {
                        book1 = bookService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                    }

                    System.out.println("Enter id of author");
                    id = enter.readLine();
                    if (id == null || id.isBlank()) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    Author author2 = new Author();
                    try {
                        author1 = authorService.findById(id);
                    } catch (Exception e) {
                        System.out.println("Id not found");
                    }
                    if (!authorService.isParamNull(author2) && !bookService.isParamNull(book2)) {
                        AuthorsWithBooks authorsWithBooks = new AuthorsWithBooks(author2, book2);
                        System.out.println(authorsWithBooks);
                    } else {
                        System.out.println("Wrong input");
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void readAllAuthors() {
        authors = authorService.readAll();
        System.out.println(Arrays.toString(authors));
    }

    private static void readAllBook() {
        books = bookService.readAll();
        System.out.println(Arrays.toString(books));
    }

    private static void createBook() throws IOException {
        book = new Book();
        System.out.println("Enter title of book");
        title = enter.readLine();
        System.out.println("Enter num of pages of book");
        numPg = enter.readLine();
        if (title.isBlank() || numPg.isBlank()) {
            System.out.println("Wrong input");
            return;
        }
        try {
            Integer.parseInt(numPg);
        } catch (Exception e) {
            System.out.println("Wrong input");
            return;
        }
        book.setTitle(title);
        book.setNumPg(Integer.parseInt(numPg));
        bookService.create(book);
    }
}
