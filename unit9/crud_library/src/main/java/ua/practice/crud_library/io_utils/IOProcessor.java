package ua.practice.crud_library.io_utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import ua.practice.crud_library.AccessToClass;
import ua.practice.crud_library.BaseEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOProcessor {
    private static final String FILE_NAME = "_database.csv";

    public static void inputDataToFile(Class<? extends BaseEntity> clazz, List<String[]> csvData, boolean isAppendable) {
        String clazzName = clazz.getSimpleName();
        try (CSVWriter writer = new CSVWriter(new FileWriter(clazzName + FILE_NAME, isAppendable))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readAllData(Class<? extends BaseEntity> clazz) {
        String clazzName = clazz.getSimpleName();
        List<String[]> csvData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(clazzName + FILE_NAME))) {
            String[] row = reader.readNext();
            int isDeletedIndex = 0;
            for (int i = 0; i < row.length; i++) {
                String s = row[i];
                if (s.equals("isVisible")) {
                    isDeletedIndex = i;
                    break;
                }
            }
            for (String[] strings : reader) {
                row = strings;
                if (row[isDeletedIndex].equals("true"))
                    continue;
                csvData.add(row);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return csvData;
    }

    public static void updateDataInFile(BaseEntity object) {
        Class<? extends BaseEntity> clazz = object.getClass();
        String clazzName = clazz.getSimpleName();
        ArrayList<String[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(clazzName + FILE_NAME))) {
            for (String[] strings : reader) {
                if (strings[0].equals(object.getId()))
                    data.add(AccessToClass.addFieldsValuesToCsv(object));
                else
                    data.add(strings);
            }
            inputDataToFile(clazz, data, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDataInFile(String id, Class<? extends BaseEntity> clazz) {
        String clazzName = clazz.getSimpleName();
        ArrayList<String[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(clazzName + FILE_NAME))) {
            for (String[] strings : reader) {
                if (!strings[0].equals(id))
                    data.add(strings);
            }
            inputDataToFile(clazz, data, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
