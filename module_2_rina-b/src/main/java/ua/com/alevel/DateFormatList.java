package  ua.com.alevel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DateFormatList {
    private static final String YYYY_MM_DD = "^\\d{4}[\\/](0?[1-9]|1[012])[\\/](0?[1-9]|[12][0-9]|3[01])$";
    private static final String DD_MM_YYYY = "^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]\\d{4}$";
    private static final String MM_DD_YYYY = "^(0?[1-9]|1[012])[\\-](0?[1-9]|[12][0-9]|3[01])[\\-]\\d{4}$";


    public static List<String> formattedDate(){
        File file = new File("date.txt");
        List<String> dateList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                if (line.matches(YYYY_MM_DD)){
                    String[] s = line.split("/");
                    dateList.add(s[0]+s[1]+s[2]);
                }
                else if (line.matches(DD_MM_YYYY)){
                    String[] s = line.split("/");
                    dateList.add(s[2]+s[1]+s[0]);
                }
                else if (line.matches(MM_DD_YYYY)){
                    String[] s = line.split("-");
                    dateList.add(s[2]+s[0]+s[1]);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Wrong input");
        }
        return dateList;
    }

}