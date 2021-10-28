package org.example.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class CsvDaoImpl implements CsvDao {

    private static final Logger LOG = LogManager.getLogger(CsvDaoImpl.class);

    private final Path path;
    private final int columns;
    private CSVWriter writer;

    public CsvDaoImpl(String fileName, String[] header) throws IOException {
        LOG.warn("Init with filename " + fileName + " and header " + Arrays.toString(header));
        this.path = Path.of(fileName);
        Files.deleteIfExists(path);
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }
        Files.createFile(path);

        writer = new CSVWriter(new FileWriter(path.toFile()));
        this.columns = header.length;
        create(header);
        LOG.debug("Finish init");
    }

    @Override
    public void create(String[] row) throws IOException {
        LOG.info("Start create with row " + Arrays.toString(row));
        if (row.length != this.columns) {
            LOG.error("Row does not match header");
            throw new IllegalArgumentException();
        }

        writer.writeNext(row);
        writer.flush();
        LOG.debug("Finish create");
    }

    @Override
    public List<String[]> readAll() throws IOException, CsvException {
        LOG.debug("Start readAll");
        return new CSVReader(new FileReader(path.toFile())).readAll();
    }

    @Override
    public void update(int rowNumber, String[] row) throws IOException, CsvException {
        LOG.warn("Start update with row number " + rowNumber + " and row " + Arrays.toString(row));
        if (row.length != this.columns) {
            LOG.error("Row does not match header");
            throw new IllegalArgumentException();
        }
        if (rowNumber == 0) {
            LOG.error("Cannot update header");
            throw new IllegalArgumentException();
        }

        List<String[]> temp = readAll();
        temp.set(rowNumber, row);
        writer = new CSVWriter(new FileWriter(path.toFile()));
        writer.writeAll(temp);
        writer.flush();
        LOG.debug("Finish update");
    }

    @Override
    public void delete(int rowNumber) throws IOException, CsvException {
        LOG.warn("Start delete with row number " + rowNumber);
        if (rowNumber == 0) {
            LOG.error("Cannot update header");
            throw new IllegalArgumentException();
        }

        List<String[]> temp = readAll();
        temp.remove(rowNumber);
        writer = new CSVWriter(new FileWriter(path.toFile()));
        writer.writeAll(temp);
        writer.flush();
        LOG.debug("Finish delete");
    }
}
