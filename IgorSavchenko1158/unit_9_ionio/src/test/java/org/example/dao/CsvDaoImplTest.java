package org.example.dao;


import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CsvDaoImplTest {

    private static CsvDaoImpl dao;

    @Test
    @Order(1)
    void createAndReadTest() throws IOException, CsvException {
        String fileName = "test.csv";
        Files.delete(Path.of(fileName));

        dao = new CsvDaoImpl(fileName, new String[]{"header1", "header2", "header3"});

        dao.create(new String[]{"test4", "test5", "test6"});

        List<String[]> rows;
        rows = dao.readAll();

        assertTrue(Files.exists(Path.of(fileName)));
        assertEquals(2, rows.size());
        assertArrayEquals(new String[]{"header1", "header2", "header3"}, rows.get(0));
        assertArrayEquals(new String[]{"test4", "test5", "test6"}, rows.get(1));
    }

    @Test
    @Order(2)
    void updateTest() throws IOException, CsvException {
        assertArrayEquals(new String[]{"test4", "test5", "test6"}, dao.readAll().get(1));
        dao.update(1, new String[]{"update4", "update5", "update6"});
        assertArrayEquals(new String[]{"update4", "update5", "update6"}, dao.readAll().get(1));
    }

    @Test
    @Order(3)
    void delete() throws IOException, CsvException {
        assertArrayEquals(new String[]{"update4", "update5", "update6"}, dao.readAll().get(1));
        assertEquals(2, dao.readAll().size());

        dao.delete(1);
        assertEquals(1, dao.readAll().size());
    }

}