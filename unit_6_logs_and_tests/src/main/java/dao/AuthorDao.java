package dao;

import entity.Author;
import entity.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class AuthorDao {

    Author[] authors = new Author[10];
    private int curId = 0;
    private int lastIndex = 9;

    public void changeLength() {

        if (authors.length <= lastIndex) {

            Author[] bufferAr = new Author[authors.length + 1];
            bufferAr = Arrays.copyOf(authors, authors.length + 1);
            authors = bufferAr;
        }
    }

    public void create(String name) {

        changeLength();

        Author author = new Author();
        author.setId(++curId);
        author.setName(name);

        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = author;

                if (lastIndex == i) {
                    lastIndex = lastIndex + 1;
                }
                break;
            }
        }
    }

    public Author read(int id) {
        for (int i = 0; i < authors.length; i++) {

            if (authors[i] == null) {
                continue;
            }
            if (authors[i].getId() == id) {
                System.out.println("entity.Author: id - " + id + ", name - " + authors[i].getName());
                return authors[i];
            }
        }

        System.out.println("author with the given id not found ");
        return null;
    }

    public ArrayList<Author> readAll() {
        ArrayList<Author> authorsAr= new ArrayList<>();
        String s = "Authors: ";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < authors.length; i++) {

            if (authors[i] == null) {
                continue;
            }
            builder.append(s);
            builder.append(" id - " );
            builder.append(authors[i].getId());
            builder.append(" name - " );
            builder.append(authors[i].getName());
            s = ", ";
            authorsAr.add(authors[i]);
        }

        System.out.println(builder.toString());
        return authorsAr;
    }


    public void update(int id, String newName) {
        for (int i = 0; i < authors.length; i++) {

            if (authors[i] == null) {
                continue;
            }
            if (authors[i].getId() == id) {
                authors[i].setName(newName);
                System.out.println("author updated");

                break;
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < authors.length; i++) {

            if (authors[i] == null) {
                continue;
            }
            if (authors[i].getId() == id) {

                //checkBooks();

                authors[i] = null;
                System.out.println("entity.Author deleted");
                break;
            }
        }
    }
    public ArrayList<Author> findByName(String name) {
        ArrayList<Author> authorsAr = new ArrayList<>();
        for (int i = 0; i < authors.length; i++) {

            if (authors[i] == null) {
                continue;
            }
            if (authors[i].getName().equals(name)) {
                authorsAr.add(authors[i]);
            }
        }

        return authorsAr;
    }
}
