package ua.practice.app;

import java.io.File;

public class ReaderUtil {
    public static void changeWorkingDirectory() {
        File file = new File("");
        String workingDirectoryPath = file.getAbsolutePath() + "\\module2";
        System.setProperty("user.dir", workingDirectoryPath);
    }
}
