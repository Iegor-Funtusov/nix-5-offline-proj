package ua.practice.app.data_base_creator;

import ua.practice.app.io_processor.IOProcessor;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class DatabaseCreator {
    private static final String FILE_NAME = "_database.csv";

    private static void changeWorkingDirectory() {
        File file = new File("");
        String workingDirectoryPath = file.getAbsolutePath() + "\\unit9";
        System.setProperty("user.dir", workingDirectoryPath);
    }

    public static void createDataBasesIfNotExist(Class<?> mainClazz) {
        changeWorkingDirectory();
        File file = new File(mainClazz.getSimpleName() + FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                String[] header = addFieldsNamesToHeader(mainClazz);
                IOProcessor.inputDataToFile(mainClazz, header, true);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static String[] addFieldsNamesToHeader(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        String[] header = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            header[i] = fields[i].getName();
        }
        return header;
    }
}
