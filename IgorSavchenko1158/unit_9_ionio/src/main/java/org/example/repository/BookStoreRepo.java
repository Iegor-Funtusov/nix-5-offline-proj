package org.example.repository;

import com.opencsv.exceptions.CsvException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.CsvDao;
import org.example.dao.CsvDaoImpl;
import org.example.entity.Author;
import org.example.entity.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookStoreRepo {

    private static final Logger LOG = LogManager.getLogger(BookStoreRepo.class);

    private final CsvDao authorDao = new CsvDaoImpl("library/authors.csv",
            new String[]{"ID", "First name", "Last name", "Visible"});
    private final CsvDao bookDao = new CsvDaoImpl("library/books.csv",
            new String[]{"ID", "Name", "Visible"});
    private final CsvDao authorToBookDao = new CsvDaoImpl("library/authorToBook.csv",
            new String[]{"Author ID", "Book ID"});
    private Long idGenerator = 0L;

    public BookStoreRepo() throws IOException {
    }

    public Long addBook(Book book) {
        LOG.info("Start addBook with " + book);
        book.setId(generateId());
        LOG.debug("Set id to " + book.getId());

        String[] row = bookToRow(book);
        try {
            bookDao.create(row);
        } catch (IOException e) {
            LOG.error(e);
            return null;
        }

        List<Author> authors = book.getAuthors();
        for (Author author : authors) {
            if (getAuthor(author.getId()) != null) {
                try {
                    authorToBookDao.create(new String[]{author.getId().toString(), book.getId().toString()});
                } catch (IOException e) {
                    LOG.error(e);
                }
            }
        }

        return book.getId();
    }

    public Long addAuthor(Author author) {
        LOG.info("Start add author " + author);
        author.setId(generateId());
        LOG.debug("Set id to " + author.getId());

        String[] row = authorToRow(author);
        try {
            authorDao.create(row);
        } catch (IOException e) {
            LOG.error(e);
            return null;
        }

        List<Book> books = author.getBooks();
        for (Book book : books) {
            if (getBook(book.getId()) != null) {
                try {
                    authorToBookDao.create(new String[]{author.getId().toString(), book.getId().toString()});
                } catch (IOException e) {
                    LOG.error(e);
                }
            }
        }

        return author.getId();
    }

    public Book getBook(Long id) {
        LOG.debug("Start getBook with id " + id);
        String[] row = getBookRow(id);
        if (row == null) {
            return null;
        }
        Book book = rowToBook(row);
        book.addAuthors(getAllAuthorsByBook(book.getId()));

        return book;
    }

    public Author getAuthor(Long id) {
        LOG.debug("Start get author with id " + id);

        String[] row = getAuthorRow(id);
        if (row == null) {
            return null;
        }
        Author author = rowToAuthor(row);
        author.addBooks(getAllBooksByAuthor(author.getId()));
        return author;
    }

    public void updateBook(Book book) {
        LOG.info("Start update book " + book);

        List<String[]> rows;
        try {
            rows = bookDao.readAll();
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return;
        }
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i)[0].equals(book.getId().toString()) && rows.get(i)[2].equals("true")) {
                deletePairs(book);
                createPairs(book);
                try {
                    bookDao.update(i, bookToRow(book));
                    LOG.warn("Success update book");
                } catch (IOException | CsvException e) {
                    LOG.error(e);
                }
                return;
            }
        }
    }

    public void updateAuthor(Author author) {
        LOG.info("Start update author " + author);

        List<String[]> rows;
        try {
            rows = authorDao.readAll();
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return;
        }
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i)[0].equals(author.getId().toString()) && rows.get(i)[3].equals("true")) {
                deletePairs(author);
                createPairs(author);
                try {
                    authorDao.update(i, authorToRow(author));
                    LOG.warn("Success update author");
                } catch (IOException | CsvException e) {
                    LOG.error(e);
                }
                return;
            }
        }
    }

    public void deleteBook(Long id) {
        LOG.info("Start delete book with id " + id);

        List<String[]> rows;
        try {
            rows = bookDao.readAll();
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return;
        }
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i)[0].equals(id.toString()) && rows.get(i)[2].equals("true")) {
                String[] toBeDeleted = rows.get(i);
                toBeDeleted[2] = "false";
                deletePairs(rowToBook(toBeDeleted));
                try {
                    bookDao.update(i, toBeDeleted);
                    LOG.warn("Success delete book");
                } catch (IOException | CsvException e) {
                    LOG.error(e);
                }
                return;
            }
        }
    }

    public void deleteAuthor(Long id) {
        LOG.info("Start delete author with id" + id);

        List<String[]> rows;
        try {
            rows = authorDao.readAll();
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return;
        }
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i)[0].equals(id.toString()) && rows.get(i)[3].equals("true")) {
                String[] toBeDeleted = rows.get(i);
                toBeDeleted[3] = "false";
                deletePairs(rowToAuthor(toBeDeleted));
                try {
                    authorDao.update(i, toBeDeleted);
                    LOG.warn("Success delete author");
                } catch (IOException | CsvException e) {
                    LOG.error(e);
                }
                return;
            }
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        List<String[]> rowsOfBooks;
        List<String[]> rowsOfPairs;
        try {
            rowsOfBooks = bookDao.readAll();
            rowsOfBooks = rowsOfBooks.stream().filter(r -> r[2].equals("true")).collect(Collectors.toList());
            rowsOfPairs = authorToBookDao.readAll();
            rowsOfPairs.remove(0);
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return null;
        }
        for (String[] bookRow : rowsOfBooks) {
            Book book = rowToBook(bookRow);
            for (String[] pairRow : rowsOfPairs) {
                if (pairRow[1].equals(book.getId().toString())) {
                    book.addAuthor(getAuthor(Long.parseLong(pairRow[0])));
                }
            }
            books.add(book);
        }
        return books;
    }

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        List<String[]> rowsOfAuthors;
        List<String[]> rowsOfPairs;
        try {
            rowsOfAuthors = authorDao.readAll();
            rowsOfAuthors = rowsOfAuthors.stream().filter(r -> r[3].equals("true")).collect(Collectors.toList());
            rowsOfPairs = authorToBookDao.readAll();
            rowsOfPairs.remove(0);
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return null;
        }
        for (String[] authorRow : rowsOfAuthors) {
            Author author = rowToAuthor(authorRow);
            for (String[] pairRow : rowsOfPairs) {
                if (pairRow[0].equals(author.getId().toString())) {
                    author.addBook(getBook(Long.parseLong(pairRow[1])));
                }
            }
            authors.add(author);
        }
        return authors;
    }

    public List<Book> getAllBooksByAuthor(Long id) {
        LOG.debug("Start getAllBooksByAuthor");
        List<Book> books = new ArrayList<>();

        List<String[]> rowsOfPairs;
        try {
            rowsOfPairs = authorToBookDao.readAll();
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return null;
        }

        for (String[] rowOfPairs : rowsOfPairs) {
            if (rowOfPairs[0].equals(id.toString())) {
//                books.add(getBook(Long.parseLong(rowOfPairs[1])));
                String[] row = getBookRow(Long.parseLong(rowOfPairs[1]));
                Book book = new Book();
                book.setId(Long.parseLong(row[0]));
                book.setName(row[1]);
                books.add(book);
            }

        }
        return books;
    }

    public List<Author> getAllAuthorsByBook(Long id) {
        List<Author> authors = new ArrayList<>();

        List<String[]> rowsOfPairs;
        try {
            rowsOfPairs = authorToBookDao.readAll();
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return null;
        }

        for (String[] rowOfPairs : rowsOfPairs) {
            if (rowOfPairs[1].equals(id.toString())) {
                String[] row = getAuthorRow(Long.parseLong(rowOfPairs[0]));
                Author author = new Author();
                author.setId(Long.parseLong(row[0]));
                author.setFirstName(row[1]);
                author.setLastName(row[2]);
                authors.add(author);
            }
        }
        return authors;
    }

    private Long generateId() {
        return idGenerator++;
    }

    private Book rowToBook(String[] row) {
        LOG.debug("Start row to book with row " + Arrays.toString(row));
        Book book = new Book();
        book.setId(Long.parseLong(row[0]));
        book.setName(row[1]);
        return book;
    }

    private Author rowToAuthor(String[] row) {
        LOG.debug("Start row to author with row " + Arrays.toString(row));
        Author author = new Author();
        author.setId(Long.parseLong(row[0]));
        author.setFirstName(row[1]);
        author.setLastName(row[2]);

        return author;
    }

    private String[] bookToRow(Book book) {
        return new String[]{
                book.getId().toString(),
                book.getName(),
                "true"
        };
    }

    private String[] authorToRow(Author author) {
        return new String[]{
                author.getId().toString(),
                author.getFirstName(),
                author.getLastName(),
                "true"
        };
    }

    private void deletePairs(Book book) {
        Long id = book.getId();
        List<String[]> rows;
        try {
            rows = authorToBookDao.readAll();
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return;
        }
        for (int i = rows.size() - 1; i >= 0; i--) {
            if (rows.get(i)[1].equals(id.toString())) {
                try {
                    authorToBookDao.delete(i);
                } catch (IOException | CsvException e) {
                    LOG.error(e);
                }
            }
        }
    }

    private void deletePairs(Author author) {
        Long id = author.getId();
        List<String[]> rows;
        try {
            rows = authorToBookDao.readAll();
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return;
        }
        for (int i = rows.size() - 1; i >= 0; i--) {
            if (rows.get(i)[0].equals(id.toString())) {
                try {
                    authorToBookDao.delete(i);
                } catch (IOException | CsvException e) {
                    LOG.error(e);
                }
            }
        }
    }

    private void createPairs(Book book) {
        for (Author author : book.getAuthors()) {
            if (getAuthor(author.getId()) != null) {
                try {
                    authorToBookDao.create(new String[]{author.getId().toString(), book.getId().toString()});
                } catch (IOException e) {
                    LOG.error(e);
                }
            }
        }
    }

    private void createPairs(Author author) {
        for (Book book : author.getBooks()) {
            if (getBook(book.getId()) != null) {
                try {
                    authorToBookDao.create(new String[]{author.getId().toString(), book.getId().toString()});
                } catch (IOException e) {
                    LOG.error(e);
                }
            }
        }
    }

    private String[] getBookRow(Long id) {
        List<String[]> rows;
        try {
            rows = bookDao.readAll();
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return null;
        }
        String[] row = rows.stream().filter(r -> r[0].equals(id.toString()) && r[2].equals("true")).findFirst().orElse(null);
        if (row == null) {
            LOG.debug("No such book");
            return null;
        }
        return row;
    }

    private String[] getAuthorRow(Long id) {
        List<String[]> rows;
        try {
            rows = authorDao.readAll();
        } catch (IOException | CsvException e) {
            LOG.error(e);
            return null;
        }
        String[] row = rows.stream().filter(r -> r[0].equals(id.toString()) && r[3].equals("true")).findFirst().orElse(null);
        if (row == null) {
            LOG.debug("No such author");
            return null;
        }
        return row;
    }
}
