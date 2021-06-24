package com.nix;

import com.nix.control.ControlAuthor;
import com.nix.control.ControlBook;
import com.nix.csv.CSVwriter;
import com.nix.pojo_objects.Author;
import com.nix.pojo_objects.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IoNioMain {

    private static final ControlAuthor CONTROL_AUTHOR = new ControlAuthor();
    private static final ControlBook CONTROL_BOOK = new ControlBook();
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        while (true) {
            showMenu();
            try {
                String choose = BUFFERED_READER.readLine();

                switch (Integer.parseInt(choose)) {
                    case 0:
                        return;
                    case 1:
                        createBook();
                        break;
                    case 2:
                        createAuthor();
                        break;
                    case 3:
                        updateBook();
                        break;
                    case 4:
                        updateAuthor();
                        break;
                    case 5:
                        deleteBook();
                        break;
                    case 6:
                        deleteAuthor();
                        break;
                    case 7:
                        displayBook();
                        break;
                    case 8:
                        displayAuthor();
                        break;
                    case 9:
                        displayListOfAuthors();
                        break;
                    case 10:
                        displayBooksFromAuthor();
                        break;
                    case 11:
                        saveToCSV();
                        break;
                    case 12:
                        addListToBook();
                        break;
                    case 13:
                        addListToAuthor();
                        break;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
    }

    private static void addListToAuthor() {
        List<Book> books = new ArrayList<>();
        System.out.println("Enter id of books(for stop write \"break\")");
        try {
            while (true) {
                String id = BUFFERED_READER.readLine();
                if (id.equals("break")) {
                    break;
                }
                books.add(findByIdBook(id));
            }
            System.out.println("Enter id of author to add books");
            String id = BUFFERED_READER.readLine();
            findByIdAuthor(id).setBookList(books);
        } catch (IOException | RuntimeException e) {
            System.out.println("Wrong input");
        }
    }

    private static void addListToBook() {
        List<Author> authors = new ArrayList<>();
        System.out.println("Enter id of authors(for stop write \"break\")");
        try {
            while (true) {
                String id = BUFFERED_READER.readLine();
                if (id.equals("break")) {
                    break;
                }
                authors.add(findByIdAuthor(id));
            }
            System.out.println("Enter id of book to add authors");
            String id = BUFFERED_READER.readLine();
            findByIdBook(id).setAuthorList(authors);
        } catch (IOException | RuntimeException e) {
            System.out.println("Wrong input");
        }
    }

    private static void displayBooksFromAuthor() {
        System.out.println("Enter id of author");
        String id;
        try {
            id = BUFFERED_READER.readLine();
            System.out.println(CONTROL_AUTHOR.readList(findByIdAuthor(id)));
        } catch (IOException | RuntimeException e) {
            System.out.println("Wrong input");
        }
    }

    private static void displayListOfAuthors() {
        System.out.println("Enter id of book");
        String id;
        try {
            id = BUFFERED_READER.readLine();
            System.out.println(CONTROL_BOOK.readList(findByIdBook(id)));
        } catch (IOException | RuntimeException e) {
            System.out.println("Wrong input");
        }
    }

    private static void displayAuthor() {
        System.out.println(CONTROL_AUTHOR.read());
    }

    private static void deleteAuthor() {
        System.out.println("Enter id for delete");
        try {
            String id = BUFFERED_READER.readLine();
            CONTROL_AUTHOR.delete(findByIdAuthor(id));
        } catch (IOException | RuntimeException e) {
            System.out.println("Wrong input");
        }
    }

    private static void updateAuthor() {
        System.out.println("Enter id of author");
        try {
            String id = BUFFERED_READER.readLine();
            System.out.println("Enter new first name");
            String firstName = BUFFERED_READER.readLine();
            System.out.println("Enter new last name");
            String lastName = BUFFERED_READER.readLine();
            Author author = findByIdAuthor(id);
            author.setFirstName(firstName);
            author.setLastName(lastName);

            CONTROL_AUTHOR.update(findByIdAuthor(id));
        } catch (IOException | RuntimeException e) {
            System.out.println("Wrong input");
        }
    }

    private static void createAuthor() {
        System.out.println("Enter first name");
        try {
            String firstName = BUFFERED_READER.readLine();
            System.out.println("Enter last name");
            String lastName = BUFFERED_READER.readLine();

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            CONTROL_AUTHOR.create(author);
        } catch (IOException | RuntimeException e) {
            System.out.println("Wrong input");
        }
    }

    private static void displayBook() {
        System.out.println(CONTROL_BOOK.read());
    }

    private static void deleteBook() {
        System.out.println("Enter id for delete");
        try {
            String id = BUFFERED_READER.readLine();
            CONTROL_BOOK.delete(findByIdBook(id));
        } catch (IOException | RuntimeException e) {
            System.out.println("Wrong input");
        }
    }

    private static void updateBook() {
        System.out.println("Enter id for update");
        try {
            String id = BUFFERED_READER.readLine();
            System.out.println("Enter new title");
            String title = BUFFERED_READER.readLine();
            Book book = findByIdBook(id);
            book.setTitle(title);
            CONTROL_BOOK.update(id);
        } catch (IOException | RuntimeException e) {
            System.out.println("Wrong input");
        }
    }

    private static void createBook() {
        System.out.println("Enter title");
        try {
            String title = BUFFERED_READER.readLine();
            Book book = new Book();
            book.setTitle(title);
            CONTROL_BOOK.create(book);
        } catch (IOException | RuntimeException e) {
            System.out.println("Wrong input");
        }

    }

    private static void showMenu() {
        System.out.println("1. Create Book");
        System.out.println("2. Create Author");
        System.out.println("3. Update Book");
        System.out.println("4. Update Author");
        System.out.println("5. Delete Book");
        System.out.println("6. Delete Author");
        System.out.println("7. Display all Books");
        System.out.println("8. Display all Authors");
        System.out.println("9. Display all authors who write this book");
        System.out.println("10. Display all books which wrote by author ");
        System.out.println("11. Save all to CSV (BookAuthor.csv)");
        System.out.println("12. Add list of authors to book");
        System.out.println("13. Add list of books to author");
        System.out.println("0. Exit");
        System.out.println("Choose the item of menu");
    }

    private static void saveToCSV() {
        List<Author> authors;
        List<Book> books;

        authors = CONTROL_AUTHOR.read();
        books = CONTROL_BOOK.read();
        try {
            new CSVwriter(books, authors);
        } catch (RuntimeException ex) {
            System.out.println("Books || Authors is null");
        }
    }

    private static Book findByIdBook(String id) {
        Book current = CONTROL_BOOK.read().stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
        if (current == null) {
            throw new RuntimeException("This id does not exist");
        }
        return current;
    }

    private static Author findByIdAuthor(String id) {
        Author current = CONTROL_AUTHOR.read().stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
        if (current == null) {
            throw new RuntimeException("This id does not exist");
        }
        return current;
    }
}
