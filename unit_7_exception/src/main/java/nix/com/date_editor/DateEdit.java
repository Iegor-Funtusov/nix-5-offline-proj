package nix.com.date_editor;

import java.util.List;

public class DateEdit {
    DateService dateService = new DateService();

    public String[] differenceDate (Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return null;
        }
        long difference = date1.getMils() - date2.getMils();
        String[] allInfo = new String[9];
        if (difference < 0) {
            difference *= -1;
        }
        long seconds = difference / (1000);
        allInfo[0] = "seconds = " + seconds;

        long minutes = difference / (1000 * 60);
        allInfo[1] = "minute = " + minutes;

        long hours = difference / (1000 * 60 * 60);
        allInfo[2] = "hour = " + hours;

        long days = (difference / (24 * 60 * 60 * 1000));
        allInfo[3] = "days = " + days;

        long month = (long) (difference * (0.0000000003858));
        allInfo[4] = "month = " + month;

        long year = (long) (difference * (0.0000000000317));
        allInfo[5] = "year = " + year;

        return allInfo;
    }

    public String[] compareDates (List<Date> dateList) throws RuntimeException {
        if (dateList == null) {
            throw new RuntimeException();
        }
        List<Date> dates = dateList;
        Date[] datesArr = new Date[dates.size()];
        String[] allInfo = new String[dates.size()];

        int i = 0;
        for (Date date : dates) {
            datesArr[i] = date;
            i++;
        }
        i = 0;
        for (i = dates.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (datesArr[j].getMils() > datesArr[j + 1].getMils()) {
                    Date tmpDate = datesArr[j];
                    datesArr[j] = datesArr[j + 1];
                    datesArr[j + 1] = tmpDate;
                }
            }
        }
        i = 0;
        for (Date date : datesArr) {
            allInfo[i] = date.toString();
            i++;
        }

        return allInfo;
    }
}
