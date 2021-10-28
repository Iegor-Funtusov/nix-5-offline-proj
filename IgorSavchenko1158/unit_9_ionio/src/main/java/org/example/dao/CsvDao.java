package org.example.dao;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public interface CsvDao {

    void create(String[] row) throws IOException;
    List<String[]> readAll() throws IOException, CsvException;
    void update(int rowNumber, String[] row) throws IOException, CsvException;
    void delete(int rowNumber) throws IOException, CsvException;

}
