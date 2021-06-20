package ua.practice.crud_library;

import com.opencsv.CSVWriter;
import org.reflections.Reflections;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IOProcessor {
    private static final String FILE_NAME = "database.csv";

    private static void changeWorkingDirectory() {
        File file = new File("");
        String workingDirectoryPath = file.getAbsolutePath() + "\\unit9";
        System.setProperty("user.dir", workingDirectoryPath);
    }

    public static void createDataBasesIfNotExist(Class<?> mainClazz) {
        changeWorkingDirectory();
        Reflections reflections = new Reflections(mainClazz.getPackage().getName() + ".entity");
        Set<Class<? extends BaseEntity>> entities = reflections.getSubTypesOf(BaseEntity.class);
        for (Class<? extends BaseEntity> entity : entities) {
            File file = new File(entity.getSimpleName() + "_" + FILE_NAME);
            if(!file.exists())
            {
                try {
                    file.createNewFile();
                    List<String[]> fieldsName = new ArrayList<>();
                    AccessToClass.addFieldsNamesToHeader(entity, fieldsName);
                    inputDataToFile(entity, fieldsName);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void inputDataToFile(Class<? extends BaseEntity> clazz, List<String[]> csvData) {
        String clazzName = clazz.getSimpleName() + "_";
        try (CSVWriter writer = new CSVWriter(new FileWriter(clazzName + FILE_NAME, true))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
