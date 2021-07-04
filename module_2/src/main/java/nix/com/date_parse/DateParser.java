package nix.com.date_parse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {

    private final Pattern PATTERN_D_M_Y = Pattern.compile ("^(?:(?:31(\\/|-)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
    private final Pattern PATTERN_M_D_Y = Pattern.compile ("^(1[0-2]|[1-9])\\/(3[01]|[12][0-9]|[1-9])\\/(\\d{4})$");
    private final Pattern PATTERN_Y_M_D1 = Pattern.compile ("^(\\d{4})\\/(0[1-9]|1[1-2]|[1-9])\\/(3[0-1]|0[0-9]|[12][0-9]|[1-9])$");
    private final Pattern PATTERN_Y_M_D2 = Pattern.compile ("^(\\d{4})-(0[1-9]|1[1-2]|[1-9])-(3[0-1]|0[0-9]|[12][0-9]|[1-9])$");
    List<String> dateList = new ArrayList<>();


    public List<String> parseDate() {
        File file = new File("dates.txt");

        try (FileReader fr = new FileReader(file);
             BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                Matcher matcherD_M_Y = PATTERN_D_M_Y.matcher(line);
                Matcher matcherM_D_Y = PATTERN_M_D_Y.matcher(line);
                Matcher matcherY_M_D1 = PATTERN_Y_M_D1.matcher(line);
                Matcher matcherY_M_D2 = PATTERN_Y_M_D2.matcher(line);

                if (matcherD_M_Y.find() || matcherM_D_Y.find() || matcherY_M_D1.find() || matcherY_M_D2.find()){
                    String date = line.replace("-", "").replace("/", "");
                    dateList.add(date);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Wrong input");
        }
        return dateList;
    }
}
