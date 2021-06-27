package ua.com.reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Reader {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public static List<String[]> readCSV(String path) {
        List<String[]> list;
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            try {
                list = reader.readAll();
            } catch (CsvException e) {
                LOGGER_ERROR.error("File is not read");
                throw new RuntimeException("File is not read");
            }
        } catch (IOException e) {
            LOGGER_ERROR.error("File is not find");
            throw new RuntimeException("File is not find");
        }
        return list;
    }
}
