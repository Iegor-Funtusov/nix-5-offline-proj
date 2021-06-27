package ua.com.alevel.dao;

import ua.com.alevel.dao.util.ReadCsv;
import ua.com.alevel.entity.Author;

import com.opencsv.CSVWriter;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDao {

    public void create(Author author) {
        List<String[]> csvData = new LinkedList<>();

        try(CSVWriter writer = new CSVWriter(new FileWriter("authors.csv",true))) {
            csvData.add(authorToStringArray(author));
            writer.writeAll(csvData);
        } catch (IOException ex){
            System.out.println("Can`t reach csv");
        }
    }

    public void update(Author author) {
        List<Author> authors = ReadCsv.readCSVAuthor();
        new File("authors.csv").delete();
        for(Author a : authors){
            if(a.getId().equals(author.getId())){
                if(author.getFirstName() != null){
                    a.setFirstName(author.getFirstName());
                }
                if(author.getLastName() != null){
                    a.setLastName(author.getLastName());
                }
                if(author.getBookList() != null){
                    a.setBookList(author.getBookList());
                }
            }
            create(a);
        }
    }

    public void delete(String id){
        List<Author> authors = ReadCsv.readCSVAuthor();
        new File("authors.csv").delete();
        for(Author a : authors){
            if(a.getId().equals(id)){
                a.setVisible(false);
            }
            create(a);
        }
    }

    public Author readById(String id) {
        return readAll()
                .stream()
                .filter(b -> b.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public List<Author> readAll(){
        return ReadCsv.readCSVAuthor()
                .stream()
                .filter(Author::isVisible)
                .collect(Collectors.toList());
    }

    private String[] authorToStringArray(Author author){
        String[] strings = new String[5];
        strings[0] = author.getId();
        strings[1] = author.getFirstName();
        strings[2] = author.getLastName();
        strings[3] = author.getBookList()
                .stream()
                .map(o -> o.getId()+"/"+o.getName())
                .collect(Collectors.joining(","));
        strings[4] = Boolean.toString(author.isVisible());
        return strings;
    }
}