package ua.com.writer;

import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public static void writeCSV(List<String[]> list, String path) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            writer.writeAll(list);
        } catch (IOException e) {
            LOGGER_ERROR.error("CSVWriter is not created");
            throw new RuntimeException("CSVWriter is not created");
        }
    }

    public static void writeLineCSV(String[] line, String path){
        try (CSVWriter writer = new CSVWriter(new FileWriter(path, true))) {
            writer.writeNext(line);
        } catch (IOException e) {
            LOGGER_ERROR.error("CSVWriter is not created");
            throw new RuntimeException("CSVWriter is not created");
        }
    }

}
