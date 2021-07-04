package nix.com.date_editor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateService {

    private final List<Date> list = new ArrayList<>();
    private final Pattern PATTERN_D_M_Y = Pattern.compile ("^(?:(?:31(\\/|-)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
    private final Pattern PATTERN_M_D_Y = Pattern.compile ("^(1[0-2]|[1-9])\\/(3[01]|[12][0-9]|[1-9])\\/(\\d{4})$");
    private final Pattern PATTERN_TIME = Pattern.compile ("^(\\d\\d:\\d\\d)$");

    public void create (String dateStr) throws RuntimeException{
        Date date;
        String subDateStr = dateStr.substring(0, dateStr.length() - 6);
        Matcher matcherD_M_Y = PATTERN_D_M_Y.matcher(subDateStr);
        Matcher matcherM_D_Y = PATTERN_M_D_Y.matcher(subDateStr);
        if (matcherD_M_Y.find() || matcherM_D_Y.find()) {
            date = new Date();
            String[] splitTime = dateStr.split((" "));
            String timePattern = splitTime[1];
            Matcher matcherTIME = PATTERN_TIME.matcher(timePattern);
            if (matcherTIME.find()) {
                splitTime = splitTime[1].split(":");
                date.setHour(Integer.parseInt(splitTime[0]));
                date.setMinute(Integer.parseInt(splitTime[1]));
            } else {
                throw new RuntimeException();
            }
            String[] splitDate = dateStr.split("[-/]");
            date.setDay(splitDate[0]);
            date.setMonth(splitDate[1]);
            if (Integer.parseInt(splitDate[2].substring(0, splitDate[2].length() - 6)) < 2000) {
                splitDate[2] = String.valueOf(Integer.parseInt(splitDate[2].substring(0, splitDate[2].length() - 6)) + 2000);
            }
            date.setYear(splitDate[2].substring(0, splitDate[2].length() - 6));
            list.add(date);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Date> readAll () {
        return list;
    }


}
