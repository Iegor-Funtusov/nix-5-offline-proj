package ua.davidenko.date;

import java.util.Collections;
import java.util.List;

public class DateSort {

    public static List<Date> sortByAsc(List<Date> dateList) {
        Collections.sort(dateList);
        return dateList;
    }

    public static List<Date> sortByDesc(List<Date> dateList) {
        dateList.sort(Collections.reverseOrder());
        return dateList;
    }
}
