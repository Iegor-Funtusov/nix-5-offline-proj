import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import obj.Author;
import obj.Book;
import org.junit.jupiter.api.*;
import services.HelpService;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

import static services.AuthorService.AUTHORS;
import static services.BookService.BOOKS;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CommonTest {

    @BeforeAll
    public static void createNewFiles(){
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
    public void ifNoFileExists(){
        HelpService.readAllBooks();
        HelpService.readAllBooks("name");
        HelpService.updateBook("aa", "aa", "aa", 1);
        HelpService.deleteBook("aa", "aa");
        HelpService.readAllAuthors();
        HelpService.readAllAuthors("name");
        HelpService.updateAuthor("aa", "aa", "aa", 1);
        HelpService.deleteAuthor("aa");
    }

    @Test
    @Order(2)
    public void createEntities(){
        Path path = Paths.get(BOOKS);
        Path path1 = Paths.get(AUTHORS);
        try {
            Files.delete(path);
            Files.delete(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        IntStream.range(0, 10).forEach(i -> {
            Book book = new Book();
            book.setName("testBook" + i);
            book.setListOfAuthors("author author" + i);
            HelpService.createBook(book);
            Author author = new Author();
            author.setFirstName("FirstName" + i);
            author.setLastName("LastName" + i);
            author.setListOfBooks("Book" + i);
            HelpService.createAuthor(author);
        });
        int counter;
        try(CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            counter = read.size();
            Assertions.assertEquals(21, counter);

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        counter = 0;
        try(CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            List<String[]> read = reader.readAll();
            for (String[] r : read) {
                counter++;
            }
            Assertions.assertEquals(21, counter);

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }


    @Test
    @Order(3)
    public void creatingOfBooks(){
        for (int i = 0; i < 2; i++) {
            Book book = new Book();
            book.setName("testBook");
            book.setListOfAuthors("author author");
            HelpService.createBook(book);
        }
        Book book = new Book();
        book.setName("testBook with some authors");
        book.setListOfAuthors("aa aa, bb bb");
        HelpService.createBook(book);
    }

    @Test
    @Order(4)
    public void creatingOfAuthors(){
        for (int i = 0; i < 2; i++) {
            Author author = new Author();
            author.setFirstName("FirstName");
            author.setLastName("LastName");
            author.setListOfBooks("Book");
            HelpService.createAuthor(author);
        }

        Author author = new Author();
        author.setFirstName("FirstName");
        author.setLastName("LastName with some books");
        author.setListOfBooks("Book1, Book2");
        HelpService.createAuthor(author);

        author = new Author();
        author.setFirstName("FirstName");
        author.setLastName("LastName without books");
        author.setListOfBooks("");
        HelpService.createAuthor(author);
    }

    @Test
    @Order(5)
    public void findingAllAuthorsOfCertainBook(){
        HelpService.readAllBooks("abababab");
    }

    @Test
    @Order(6)
    public void findingAllBooksOfCertainAuthor(){
        HelpService.readAllAuthors("aaaaa");
    }

    @Test
    @Order(7)
    public void updatingOfBook(){
        HelpService.updateBook("aa", "aa", "aa", 1);

        HelpService.updateBook("testBook", "author author", "testBook", 1);

        HelpService.updateBook("testBook", "author author", "testBookUPDATED", 1);

        Assertions.assertTrue(findAuthors("author", "author", "testBookUPDATED"));
    }

    @Test
    @Order(8)
    public void updatingOfAuthor(){
        HelpService.updateAuthor("aa", "aa aa", "aa", 1);

        HelpService.updateAuthor("testBook", "author author", "testBook", 1);
        HelpService.updateAuthor("testBook", "author author", "author author", 2);

        HelpService.updateAuthor("Book1", "FirstName1 LastName1", "Book1UPDATED", 1);
        HelpService.updateAuthor("Book1UPDATED", "FirstName1 LastName1", "FirstName1UPDATED LastName1UPDATED", 2);

        Assertions.assertTrue(findBooks("Book1UPDATED", "FirstName1UPDATED LastName1UPDATED"));
    }

    @Test
    @Order(8)
    public void deletingOfBook(){
        HelpService.deleteAuthor("aaa aaa");
    }

    @Test
    @Order(9)
    public void deletingOfAuthor(){
        HelpService.deleteAuthor("aaa aaa");
        HelpService.deleteAuthor("bb bb");
        Assertions.assertTrue(findBooks("Test Book with some authors", "aa aa"));
        HelpService.deleteAuthor("aa aa");
        Assertions.assertFalse(findBooks("Test Book with some authors", "aa aa"));
    }

    private boolean findBooks(String name, String authors){
        try(CSVReader reader = new CSVReader(new FileReader(BOOKS))) {
            List<String[]> read = reader.readAll();
            if (read.stream()
                    .anyMatch(r -> r[1]
                    .equalsIgnoreCase(name) && r[2]
                    .contains(authors) && !r[3]
                    .contains("NOTVISIBLE"))) {
                return true;
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean findAuthors(String firstName, String lastName, String books){
        try(CSVReader reader = new CSVReader(new FileReader(AUTHORS))) {
            List<String[]> read = reader.readAll();
            if (read.stream()
                    .anyMatch(r -> r[1]
                    .equalsIgnoreCase(firstName) && r[2]
                    .equalsIgnoreCase(lastName) && r[3]
                    .equalsIgnoreCase(books) && !r[4]
                    .contains("NOTVISIBLE"))) {
                return true;
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return false;
    }
}
