package ua.practice.app.io_processor;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import ua.practice.app.data_base_creator.DatabaseCreator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IOProcessor {
    private static final String FILE_NAME = "_database.csv";

    public static void inputDataToFile(Class<?> clazz, String[] csvData, boolean isAppendable) {
        String clazzName = clazz.getSimpleName();
        try (CSVWriter writer = new CSVWriter(new FileWriter(clazzName + FILE_NAME, isAppendable))) {
            if (!isAppendable)
                writer.writeNext(DatabaseCreator.addFieldsNamesToHeader(clazz));
            writer.writeNext(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateDataToFile(Class<?> clazz, List<String[]> csvData) {
        String clazzName = clazz.getSimpleName();
        try (CSVWriter writer = new CSVWriter(new FileWriter(clazzName + FILE_NAME, false))) {
            writer.writeNext(DatabaseCreator.addFieldsNamesToHeader(clazz));
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readAllData(Class<?> clazz) {
        String clazzName = clazz.getSimpleName();
        List<String[]> csvData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(clazzName + FILE_NAME))) {
            reader.readNext();
            for (String[] strings : reader) {
                csvData.add(strings);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return csvData;
    }
}
