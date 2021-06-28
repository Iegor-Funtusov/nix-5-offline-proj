import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import obj.Author;
import obj.Book;
import org.junit.jupiter.api.*;
import services.HelpService;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertThrows;
import static services.AuthorService.AUTHORS;
import static services.BookService.BOOKS;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class crudTest {

    @BeforeAll
    public static void createNewFiles() {
        Path path = Paths.get(BOOKS);
        Path path1 = Paths.get(AUTHORS);
        try {
            Files.delete(path);
            Files.delete(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertFalse(Files.exists(path) && Files.exists(path1));
    }

    @Test
    @Order(1)
    public void createBook() {
        Book book = new Book();
        book.setName("testBook");
        String authors = "author1 author1, author2 author2";
        book.setListOfAuthors(authors);
        HelpService.createBook(book);
        boolean flag1 = false;
        if (new File(BOOKS).exists()) {
            flag1 = true;
        }
        Assertions.assertTrue(flag1 && findBooks("testBook", "author1 author1, author2 author2"));
    }

    @Test
    @Order(2)
    public void readAllBooks() {
        int counter;
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            counter = read.size();
            Assertions.assertEquals(2, counter);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    public void readAuthorsOfBook() {
        String[] authors;
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            for (int i = 0; i < read.size(); i++) {
                String[] r = read.get(i);
                if (r[1].equalsIgnoreCase("testBook")) {
                    authors = r[2].split(",");
                    Assertions.assertEquals(2, authors.length);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(4)
    public void updateBook() {
        HelpService.updateBook("testBook", "author1 author1, author2 author2", "testThisBook", 1);
        Assertions.assertTrue(findBooks("testThisBook", "author1 author1, author2 author2"));
    }

    @Test
    @Order(5)
    public void deleteBook() {
        HelpService.deleteBook("testThisBook", "author author");
        Assertions.assertFalse(findBooks("testThisBook", "author author"));
    }

    @Test
    @Order(6)
    public void createAuthor() {
        Author author = new Author();
        author.setFirstName("FirstName");
        author.setLastName("LastName");
        author.setListOfBooks("Book1, Book2, Book3");
        HelpService.createAuthor(author);
        Assertions.assertTrue(findAuthors("FirstName", "LastName", "Book1, Book2, Book3"));
    }

    @Test
    @Order(7)
    public void readAllAuthors() {
        int counter;
        try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            List<String[]> read = reader.readAll();
            counter = (int) read.stream().filter(r -> !r[3].equals("NOTVISIBLE")).count();
            System.out.println(counter);
            Assertions.assertEquals(4, counter);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(8)
    public void readAuthorsBooks() {
        String books = "";
        int counter;
        try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            List<String[]> read = reader.readAll();
            for (int i = 0; i < read.size(); i++) {
                String[] r = read.get(i);
                if (r[1].contains("FirstName") && r[2].contains("LastName")) {
                    books += r[3];
                }
            }
            String[] arrBooks = books.split(",");
            counter = (int) IntStream.range(0, arrBooks.length).count();
            Assertions.assertEquals(3, counter);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(9)
    public void updateAuthor() {
        HelpService.updateAuthor("Book1", "FirstName LastName", "testThisBook", 1);
        HelpService.updateAuthor("", "FirstName LastName", "author author", 2);
        Assertions.assertTrue(findAuthors("author", "author", "testTestBook, Book2, Book3"));
    }

    @Test
    @Order(10)
    public void deleteAuthor() {
        HelpService.deleteAuthor("author author");
        Assertions.assertFalse(findAuthors("author", "author", "testThisBook, Book2, Book3"));

    }

    @Test
    @Order(11)
    public void checkExceptionWithNull() {
        assertThrows(NullPointerException.class, () -> HelpService.createBook(null));
        assertThrows(NullPointerException.class, () -> HelpService.createAuthor(null));
    }

    private boolean findBooks(String name, String authors) {
        try (CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            if (read.stream().anyMatch(r -> r[1].equalsIgnoreCase(name) && r[2].equalsIgnoreCase(authors) && !r[3].contains("NOTVISIBLE"))) {
                return true;
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean findAuthors(String firstName, String lastName, String books) {
        try (CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            List<String[]> read = reader.readAll();
            if (read.stream().anyMatch(r -> r[1].equalsIgnoreCase(firstName) && r[2].equalsIgnoreCase(lastName)
                    && r[3].equalsIgnoreCase(books) && !r[4].contains("NOTVISIBLE"))) {
                return true;
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return false;
    }
}
