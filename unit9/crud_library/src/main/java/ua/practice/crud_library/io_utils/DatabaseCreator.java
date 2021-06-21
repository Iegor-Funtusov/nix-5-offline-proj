package ua.practice.crud_library.io_utils;

import ua.practice.crud_library.AccessToClass;
import ua.practice.crud_library.BaseEntity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCreator {
    private static final String FILE_NAME = "_database.csv";

    private static void changeWorkingDirectory() {
        File file = new File("");
        String workingDirectoryPath = file.getAbsolutePath() + "\\unit9";
        System.setProperty("user.dir", workingDirectoryPath);
    }

    public static void createDataBasesIfNotExist(Class<? extends BaseEntity> mainClazz) {
        changeWorkingDirectory();
            File file = new File(mainClazz.getSimpleName() + FILE_NAME);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    List<String[]> fieldsName = new ArrayList<>();
                    AccessToClass.addFieldsNamesToHeader(mainClazz, fieldsName);
                    IOProcessor.inputDataToFile(mainClazz, fieldsName, true);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
        }
    }
}
