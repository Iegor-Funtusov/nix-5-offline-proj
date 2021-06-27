package ua.com.nix.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import ua.com.nix.Author;
import ua.com.nix.AuthorDao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    @Override
    public void create(Author base) {

        List<String[]> authorsData = readFromAuthorCsv();

        try (CSVWriter writer = new CSVWriter(new FileWriter("datafiles/src/main/java/ua/com/nix/authors.csv"))) {
            if (authorsData.size() < 1) {
                base.setId(1);
                String[] header = {"ID\t", "First name\t", "Last name\t", "Books\t", "Visible\t"};
                writer.writeNext(header);
            } else if (authorsData.size() == 1) base.setId(1);
            String[] body = new String[5];

            body[0] = String.valueOf(base.getId());
            body[1] = base.getFirstName();
            body[2] = base.getLastName();
            StringBuilder builder = new StringBuilder();
            for (Integer integer : base.getIdBooks()) {
                builder.append(integer);
                builder.append(";");
            }
            body[3] = builder.toString();
            body[4] = String.valueOf(base.isVisible());

            writer.writeNext(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Author base) {
        List<String[]> authorsData = readFromAuthorCsv();

        for (int i = 1; i < authorsData.size(); i++) {
            if (Integer.parseInt(authorsData.get(i)[0]) == (base.getId())) {
                String[] author = new String[5];
                author[0] = String.valueOf(base.getId());
                author[1] = base.getFirstName();
                author[2] = base.getLastName();

                StringBuilder builder = new StringBuilder();
                for (Integer integer : base.getIdBooks()) {
                    builder.append(integer);
                    builder.append(";");
                }
                author[3] = builder.toString();
                author[4] = String.valueOf(base.isVisible());
                authorsData.set(i, author);
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("datafiles/src/main/java/ua/com/nix/authors.csv"))) {
            writer.writeAll(authorsData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Author read(int id) {
        List<String[]> authorssData = readFromAuthorCsv();

        if (authorssData.size() >= 2) {
            for (int i = 1; i < authorssData.size(); i++) {
                if (authorssData.get(i)[3].equals("true") && Integer.parseInt(authorssData.get(i)[0]) == id) {
                    Author author = new Author();
                    author.setId(Integer.parseInt(authorssData.get(i)[0]));
                    author.setFirstName(authorssData.get(i)[1]);
                    author.setLastName(authorssData.get(i)[2]);
                    String[] inputID = authorssData.get(i)[3].split(";");
                    List<Integer> bookssID = new ArrayList<>();
                    for (String s : inputID) {
                        bookssID.add(Integer.parseInt(s));
                    }
                    author.setIdBooks(bookssID);
                    author.setVisible(true);
                    return author;
                }
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        List<String[]> authorsData = readFromAuthorCsv();

        if (authorsData.size() >= 2) {
            for (String[] authorsDatum : authorsData) {
                if (Integer.parseInt(authorsDatum[0]) == id) {
                    authorsDatum[3] = "false";
                }
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("datafiles/src/main/java/ua/com/nix/authors.csv"))) {
            writer.writeAll(authorsData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Author> findALl() {
        List<Author> authorList = new ArrayList<>();
        List<String[]> authorsData = readFromAuthorCsv();

        for (int i = 1; i < authorsData.size(); i++) {
            Author author = new Author();
            author.setId(Integer.parseInt(authorsData.get(i)[0]));
            author.setFirstName(authorsData.get(i)[1]);
            author.setLastName(authorsData.get(i)[2]);

            String[] inputID = authorsData.get(i)[3].split(";");
            List<Integer> booksID = new ArrayList<>();
            for (String s : inputID) {
                booksID.add(Integer.parseInt(s));
            }
            author.setIdBooks(booksID);
            author.setVisible(Boolean.getBoolean(authorsData.get(i)[4]));
            authorList.add(author);
        }
        return authorList;
    }

    @Override
    public List<Author> findByBook(int idBook) {
        List<Author> authorList = findALl();
        List<Author> resultList = new ArrayList<>();
        for (Author author : authorList) {
            if (author.getIdBooks().stream().anyMatch(integer -> integer == idBook)) {
                resultList.add(author);
            }
        }
        return resultList;
    }

    private List<String[]> readFromAuthorCsv() {
        List<String[]> authorsData = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader("datafiles/src/main/java/ua/com/nix/authors.csv"))) {
            authorsData = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return authorsData;
    }

    @Override
    public Author findAuthorByFirstNameAndLastName(String fName, String lName) {

        List<String[]> authorsData = readFromAuthorCsv();

        for (int i = 1; i < authorsData.size(); i++) {
            if (authorsData.get(i)[1].equals(fName) && authorsData.get(i)[2].equals(lName)) {
                Author author = new Author();
                author.setId(Integer.parseInt(authorsData.get(i)[0]));
                author.setFirstName(authorsData.get(i)[1]);
                author.setLastName(authorsData.get(i)[2]);

                String[] inputID = authorsData.get(i)[3].split(";");
                List<Integer> booksID = new ArrayList<>();
                for (String s : inputID) {
                    booksID.add(Integer.parseInt(s));
                }

                author.setIdBooks(booksID);
                author.setVisible(Boolean.getBoolean(authorsData.get(i)[4]));
                return author;
            }
        }
        return null;
    }

    @Override
    public boolean isAuthorExist(String firstName, String lastName) {
        List<Author> authorList = findALl();
        for (Author author : authorList) {
            if (author.getFirstName().equals(firstName) && author.getLastName().equals(lastName)) return true;
        }
        return false;
    }
}
