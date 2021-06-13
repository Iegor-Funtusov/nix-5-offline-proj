package org.example.mydateandtime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFormatter {
    public enum DateFormats {
        DD_MM_YY("dd/mm/yy"), M_D_YYYY("m/d/yyyy"), MMM_D_YY("mmm-d-yy"), DD_MMM_YYYY("dd-mmm-yyyy");
        public final String format;

        DateFormats(String format) {
            this.format = format;
        }
    }

    public static String[] monthNames = {
            "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
    };

    public static String format(MyDateAndTime dt, DateFormats format) {
        String day;
        String month;
        String year;

        switch (format) {
            case DD_MM_YY: {
                day = (dt.getDay() < 10 ? "0" : "") + dt.getDay();
                month = (dt.getMonth() < 10 ? "0" : "") + dt.getMonth();
                char[] temp = String.valueOf(dt.getYear()).toCharArray();
                year = "" + (temp.length == 1 ? "" : temp[temp.length - 2]);
                year += "" + temp[temp.length - 1];
                return "" + day + "/"
                        + month + "/"
                        + year + " "
                        + formatTime(dt);
            }
            case M_D_YYYY: {
                day = "" + dt.getDay();
                month = "" + dt.getMonth();
                year = "" + dt.getYear();
                return month + "/" + day + "/" + year + " " + formatTime(dt);
            }
            case MMM_D_YY: {
                day = "" + dt.getDay();
                month = "" + monthNames[dt.getMonth() - 1];
                char[] temp = String.valueOf(dt.getYear()).toCharArray();
                year = "" + (temp.length == 1 ? "" : temp[temp.length - 2]);
                year += "" + temp[temp.length - 1];
                return month + "-" + day + "-" + year + " " + formatTime(dt);
            }
            case DD_MMM_YYYY: {
                day = (dt.getDay() < 10 ? "0" : "") + dt.getDay();
                month = "" + monthNames[dt.getMonth() - 1];
                year = "" + dt.getYear();
                return day + "-" + month + "-" + year + " " + formatTime(dt);
            }
            default:
                return "Unrecognized format";
        }
    }

    public static MyDateAndTime parse(String dateString, String timeString) {
        int year = 2021;
        int month = 1;
        int day = 1;

        if (dateString == null) {
            dateString = "";
        }

        String regex = "([\\d]*)/([\\d]*)/([\\d]*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateString);
        if (matcher.find()) {
            if (!matcher.group(1).isEmpty()) {
                day = Integer.parseInt(matcher.group(1));
            }
            if (!matcher.group(2).isEmpty()) {
                month = Integer.parseInt(matcher.group(2));
            }
            if (!matcher.group(3).isEmpty()) {
                if (matcher.group(3).length() == 2) {
                    year = +Integer.parseInt("19" + matcher.group(3));
                } else {
                    year = Integer.parseInt(matcher.group(3));
                }
            }
        } else {
            year = Integer.parseInt(dateString);
        }

        int hour = 0;
        int minute = 0;
        int second = 0;

        if (timeString != null) {
            regex = "(\\d+):(\\d+):?(\\d*)";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(timeString);
            if (matcher.find()) {
                hour = Integer.parseInt(matcher.group(1));
                minute = Integer.parseInt(matcher.group(2));
                if (!matcher.group(3).isEmpty()) {
                    second = Integer.parseInt(matcher.group(3));
                }

            }
        }

        return new MyDateAndTime(year, month, day, hour, minute, second);
    }

    private static String formatTime(MyDateAndTime dt) {
        String hour;
        String minute;
        String second;
        hour = (dt.getHour() < 10 ? "0" : "") + dt.getHour();
        minute = (dt.getMinute() < 10 ? "0" : "") + dt.getMinute();
        second = (dt.getSecond() < 10 ? "0" : "") + dt.getSecond();

        return hour + ":" + minute + ":" + second;
    }
}
