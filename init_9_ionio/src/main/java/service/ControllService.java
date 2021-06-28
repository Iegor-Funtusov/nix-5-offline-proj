package service;

import data.Author;
import data.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllService {
    public static void runApp() {
        System.out.println("Welcome to the Library");
        AllService allService = new AllService();
        Scanner scanner = new Scanner(System.in);
        allService.initFiles();

        while (true) {
            System.out.println("A - operations with Authors (crud)");
            System.out.println("B - operations with Books (crud)");
            System.out.println("C - general operations (get authors by book, get books by author.)");
            System.out.println("T - start COMMON TEST");
            System.out.println("X- exit");
            String a = scanner.next();
            char[] cur = a.toCharArray();

            switch (cur[0]) {
                case 'A': {

                    System.out.println("Working with Authors:\n");
                    System.out.println("A - add author");
                    System.out.println("B - change author data");
                    System.out.println("B - change author data");
                    System.out.println("D - get info about all authors");
                    System.out.println("X - exit");
                    a = scanner.next();
                    cur = a.toCharArray();

                    switch (cur[0]) {
                        case 'A': {
                            Author author = new Author();
                            System.out.println("Enter Author Name and press Enter:");
                            author.setFirstName(scanner.next());
                            System.out.println("Enter the Surname of the author and press Enter:");
                            author.setLastName(scanner.next());
                            author.setVisibleFlag(true);
                            allService.createAuthor(author);
                            System.out.println("Author Created");
                            break;
                        }
                        case 'B': {
                            System.out.println("Enter Author ID");
                            String id = scanner.next();
                            if ((allService.findAuthorById(id)) == null) {
                                System.out.println("Invalid ID, please try again");
                                break;
                            }
                            Author author = allService.findAuthorById(id);
                            System.out.println("N-change Name");
                            System.out.println("A-change Surname");
                            System.out.println("X - exit");
                            String b = scanner.next();
                            char[] cur_e = b.toCharArray();
                            switch (cur_e[0]) {
                                case 'N': {
                                    System.out.println("Enter a new Name");
                                    author.setFirstName(scanner.next());
                                    allService.updateAuthor(author);
                                    System.out.println("Successfully changed to" + author.getFirstName());
                                    break;
                                }
                                case 'A': {
                                    System.out.println("Enter a new Surname");
                                    author.setLastName(scanner.next());
                                    allService.updateAuthor(author);
                                    System.out.println("Successfully changed to" + author.getLastName());
                                    break;
                                }
                                case 'X': {
                                    System.exit(0);
                                    break;
                                }
                                default:
                                    System.out.println("Invalid entry");

                            }
                            break;

                        }
                        case 'C': {
                            System.out.println("Enter Author ID");
                            try {
                                allService.deleteAuthor(scanner.next());
                            } catch (RuntimeException ex) {
                                System.err.println("Invalid ID, please try again");
                            }
                            System.out.println("Success");
                            break;
                        }
                        case 'D': {
                            List<Author> authors = allService.readAllAuthor();
                            for (Author author : authors) {
                                System.out.println(author);
                            }
                            break;
                        }
                        case 'X': {
                            System.out.println("Go to the main menu ...");
                            break;
                        }
                        default: {
                            System.out.println("None of the options match the suggested ones !!!");
                            break;
                        }
                    }
                    break;

                }


                case 'B': {
                    System.out.println("Working with Books:");
                            System.out.println("A - add book");
                            System.out.println("B - change the title of the book");
                            System.out.println("C - delete book (visible = false)");
                            System.out.println("D - get info about all books");
                            System.out.println("X- exit");

                    a = scanner.next();
                    cur = a.toCharArray();

                    switch (cur[0]) {
                        case 'A': {
                            Book book = new Book();
                            System.out.println("Enter the title of the book and press Enter:");
                            book.setTitle(scanner.next());
                            book.setVisibleFlag(true);

                            List<String> autId = new ArrayList<>();
                            System.out.println("Enter how many authors the book has (at least 1) and press Enter:");
                            int i = scanner.nextInt();
                            for (int j = 0; j < i; j++) {
                                System.out.println("enter author ID and press Enter");
                                String s = scanner.next();
                                autId.add(s);
                            }
                            book.setAuthors(autId);
                            allService.createBook(book, autId);
                            System.out.println("Book added");
                            break;
                        }
                        case 'B': {

                            System.out.println("Enter Book ID");
                            String id = scanner.next();
                            if ((allService.findBookById(id)) == null) {
                                System.out.println("Invalid ID, please try again");
                                break;
                            }
                            Book book = allService.findBookById(id);
                            System.out.println("N-change Name");
                            System.out.println("X - exit");
                            String b = scanner.next();
                            char[] cur_e = b.toCharArray();
                            switch (cur_e[0]) {
                                case 'N': {
                                    System.out.println("Enter a new Name");
                                    book.setTitle(scanner.next());
                                    allService.updateBook(book);
                                    System.out.println("Successfully changed to" + book.getTitle());
                                    break;
                                }
                                case 'X': {
                                    System.exit(0);
                                    break;
                                }
                                default:
                                    System.out.println("Invalid entry");

                            }
                            break;


                        }
                        case 'C': {
                            System.out.println("Enter Book ID");
                            try {
                                allService.deleteBook(scanner.next());
                            } catch (RuntimeException ex) {
                                System.err.println("Invalid ID, please try again");
                            }
                            System.out.println("Success");
                            break;
                        }
                        case 'D': {
                            List<Book> books = allService.readAllBook();
                            for (Book book : books) {
                                System.out.println(book);
                            }
                            break;
                        }
                        case 'X': {
                            System.out.println("Go to the main menu ...");
                            System.exit(0);
                            break;
                        }
                        default: {
                            System.out.println("None of the options match the suggested ones !!!");
                        }
                    }
                    break;
                }


                case 'C': {
                    System.out.println("Working with general operations:");
                    System.out.println("A - find books by author");
                    System.out.println("B - find authors by book");
                    System.out.println("X- exit");
                    a = scanner.next();
                    cur = a.toCharArray();

                    switch (cur[0]) {
                        case 'A': {
                            System.out.println("Enter author ID and press Enter:");
                            String na = scanner.next();
                            if (allService.findAuthorById(na) == null) {
                                System.out.println("there is no author with this ID");
                                break;
                            }
                            List<Book> books = allService.findBookByAut(na);
                            for (Book book : books) {
                                System.out.println(book);
                            }
                            if (books.get(0) == null) {
                                System.out.println("This author has no books");
                                break;
                            }
                            break;

                        }
                        case 'B': {
                            System.out.println("Enter the ID of the book and press Enter:");
                            String na = scanner.next();
                            if (allService.findBookById(na) == null) {
                                System.out.println("there is no book with this ID");
                                break;
                            }
                            List<Author> authors = allService.findAutByBook(na);
                            for (Author author : authors) {
                                System.out.println(author);
                            }
                            break;
                        }
                        case 'X': {
                            System.out.println("Go to the main menu ...");
                            System.exit(0);
                            break;
                        }
                        default: {
                            System.out.println("None of the options match the suggested ones !!!");
                        }
                    }
                    break;
                }

                case 'T': {
                    System.out.println("Test run\n");
                    System.out.println("Creation of 10 authors (there are more from the tests in the file)");
                    for (int i = 0; i < 10; i++) {
                        Author author = new Author();
                        author.setFirstName("TestAuthorFname" + i);
                        author.setLastName("TestAuthorLname" + i);
                        author.setVisibleFlag(true);
                        allService.createAuthor(author);
                    }
                    System.out.println("Reading authors from file");
                    List<Author> authors = allService.readAllAuthor();
                    for (Author author : authors) {
                        System.out.println(author);
                    }
                    System.out.println("Creation of 5 books");
                    for (int i = 0; i < 5; i++) {
                        Author author = allService.readAllAuthor().get(i);
                        Author author2 = allService.readAllAuthor().get((i * 2));
                        List<String> aId = new ArrayList<>();
                        aId.add(author.getId());
                        aId.add(author2.getId());
                        Book book = new Book();
                        book.setTitle("Test Book" + i);
                        book.setVisibleFlag(true);
                        book.setAuthors(aId);
                        allService.createBook(book, aId);
                    }
                    System.out.println("Reading books from a file");
                    List<Book> books = allService.readAllBook();
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    System.out.println("Displaying the book by ID");
                    Book book = allService.readAllBook().get(4);
                    System.out.println(book);
                    System.out.println("We display the authors of this book, according to the list of ID authors");
                    System.out.println("As you can see, ID books have been added in the authors");
                    List<String> aId = book.getAuthors();
                    for (String id : aId) {
                        Author author = allService.findAuthorById(id);
                        System.out.println(author);
                    }
                    System.out.println("We display the authors of this book, using the function - Display authors by the book");
                    System.out.println("This book's ID" + book.getId());
                    List<Author> aut = allService.findAutByBook(book.getId());
                    for (Author author : aut) {
                        System.out.println(author);
                    }
                    String idOfaut = aut.get(0).getId();
                    System.out.println("Display author's books using the function - Display books by author");
                    System.out.println("This author's ID" + idOfaut);
                    List<Book> bookList = allService.findBookByAut(idOfaut);
                    for (Book book1 : bookList) {
                        System.out.println(book1);
                    }
                    System.out.println("Further functions of the circle will be performed with this author and this book");
                    System.out.println("________________________________________________________ \n\n");
                    System.out.println("The book is the original view");
                    System.out.println(allService.findBookById(book.getId()));
                    System.out.println("Updating the book (in this case, changing the title to Nazvanie)");
                    book.setTitle("Name");
                    allService.updateBook(book);
                    System.out.println("Reading this book from the file");
                    System.out.println(allService.findBookById(book.getId()));
                    System.out.println("Removing the book (Visible flag)");
                    allService.deleteBook(book.getId());
                    System.out.println("Reading this book from the file");
                    System.out.println(allService.findBookById(book.getId()));
                    System.out.println("________________________________________________________ \n\n");
                    System.out.println("Author - original view");
                    System.out.println(allService.findAuthorById(idOfaut));
                    System.out.println("Updating the author (in this case, changing the Name and Surname to Ivan Ivanov)");
                    Author author123 = allService.findAuthorById(idOfaut);
                    author123.setFirstName("Ivan");
                    author123.setLastName("Ivanov");
                    allService.updateAuthor(author123);
                    System.out.println("Reading from the file of the given author");
                    System.out.println(allService.findAuthorById(idOfaut));
                    System.out.println("Removing the author (Visible flag)");
                    allService.deleteBook(idOfaut);
                    System.out.println("Reading from the file of the given author");
                    System.out.println(allService.findAuthorById(idOfaut));

                    System.out.println("_________________________________");
                    System.out.println("END");
                    break;

                }


                case 'X': {
                    System.out.println("bye");
                    System.exit(0);
                    break;
                }


                default: {
                    System.out.println("Incorrectly entered");
                    break;
                }

            }
        }

    }

}
