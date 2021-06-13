import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalendarUI {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Pattern DATE_PATTERN_DMY = Pattern.compile("^(?:(?:31([/\\-.])(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)([/\\-.])(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29([/\\-.])(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/|-|\\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
    private static final Pattern DATE_PATTERN_MDY = Pattern.compile("^(?:(?:(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec))([/\\-.])31)\\1|(?:(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))([/\\-.])(?:29|30)\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:(?:0?2|(?:Feb))([/\\-.])29\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))([/\\-.])(?:0?[1-9]|1\\d|2[0-8])\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
    private static final Pattern DATE_PATTERN_DMY_simple = Pattern.compile("^[0-3]?[0-9]?([/\\-.])[0-1]?[0-9]?([/\\-.])(?:[0-9]{2})?(?:[0-9]{2})?$");
    private static final Pattern DATE_PATTERN_MDY_simple = Pattern.compile("^[0-1]?[0-9]?([/\\-.])[0-3]?[0-9]?([/\\-.])(?:[0-9]{2})?(?:[0-9]{2})?$");
    private static final Pattern TIME_PATTERN_HMS = Pattern.compile("(?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)");
    private static final Pattern TIME_PATTERN_MS = Pattern.compile("(?:[012345]\\d):(?:[012345]\\d)");
    private static boolean isDMY = true;

    public static void mainInterface() throws IOException {
        String str;
        do {
            if (isDMY) {
                System.out.println("Date format is: dd/mm/yyyy");
            } else {
                System.out.println("Date format is: mm/dd/yyyy");
            }
            System.out.println("1 View all date formats, change date format");
            System.out.println("2 Auto test");
            System.out.println("3 Find the difference between dates");
            System.out.println("4 Add to date");
            System.out.println("5 Subtract from date");
            System.out.println("6 Compare the list of dates");
            System.out.println("0 Exit - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-6]")) {
                switch (str) {
                    case "1":
                        viewDateFormat();
                        break;
                    case "2":
                        autoTest();
                        break;
                    case "3":
                        differenceBetweenDates();
                        break;
                    case "4":
                        addToDate();
                        break;
                    case "5":
                        subtractFromDate();
                        break;
                    case "6":
                        compareList();
                        break;
                }
            } else {
                System.out.println("Wrong input");
            }
        } while (!str.equals("0"));
    }

    private static void viewDateFormat() throws IOException {
        System.out.println("The system works with the next date formats:");
        System.out.println("1/10/34 - October 1, 1934 0 hours 0 minutes 0 seconds;");
        System.out.println("1/10/15 - October 1, 2015 0 hours 0 minutes 0 seconds;");
        System.out.println("/5/47 00:24:00 - May 1, 1947 0 hours 24 minutes 0 seconds;");
        System.out.println("/2/ - February 1, 2021 0 hours 0 minutes 0 seconds;");
        System.out.println("1256 59:59 - January 1, 1256 0 hours 59 minutes 59 seconds;");
        System.out.println("01/Jan/2000 - January 1, 2000 0 hours 0 minutes 0 seconds;");
        System.out.println("Apr/01/2000 - April 1, 2000 0 hours 0 minutes 0 seconds;");
        System.out.println("!!!YOU CAN SEPARATE THE DATE WITH \"-\", \"/\", or \".\"");
        System.out.println("!!!YOU SHOULD SEPARATE THE TIME USING ONLY \":\"");
        System.out.println("!!!YOU MUST SEPARATE THE TIME FROM THE DATE USING A SPACE");
        System.out.println();
        System.out.println("Please select the date format:");
        System.out.println("1: dd/mm/yyyy");
        System.out.println("2: mm/dd/yyyy");
        String format = reader.readLine();
        if (checkRegExp(format, "[1-2]")) {
            isDMY = format.equals("1");
        } else {
            System.out.println("Wrong input");
        }
    }

    private static void autoTest() {
        Date date1 = new Date(0, 8, 9, 4, 0, 0);
        Date date2 = new Date(2021, 6, 11, 12, 1, 1);
        System.out.println(date1);
        System.out.println(date2);

        System.out.println("Difference in years between dates " + DateOperations.differenceInYears(date1, date2));
        System.out.println("Difference in months between dates " + DateOperations.differenceInMonths(date1, date2));
        System.out.println("Difference in days between dates " + DateOperations.differenceInDays(date1, date2));
        System.out.println("Difference in hours between dates " + DateOperations.differenceInHours(date1, date2));
        System.out.println("Difference in minutes between dates " + DateOperations.differenceInMinutes(date1, date2));
        System.out.println("Difference in seconds between dates " + DateOperations.differenceInSeconds(date1, date2));
        System.out.println();
        System.out.println("Add 1998 years to first date " + DateOperations.addYear(date1, 1998));
        System.out.println("Add 16 months to first date " + DateOperations.addMonth(date1, 16));
        System.out.println("Add 382 days to first date " + DateOperations.addDay(date1, 382));
        System.out.println("Add 121 hours to first date " + DateOperations.addHour(date1, 121));
        System.out.println("Add 1000 minutes to first date " + DateOperations.addMinute(date1, 1000));
        System.out.println("Add 8399 seconds to first date " + DateOperations.addSecond(date1, 8399));
        System.out.println();
        System.out.println("Add 1 second to first date " + DateOperations.addSecond(date1, 1));
        System.out.println();
        System.out.println("Subtract 1 second from first date " + DateOperations.subtractSecond(date1, 1));
        System.out.println("Subtract 8399 seconds from first date " + DateOperations.subtractSecond(date1, 8399));
        System.out.println("Subtract 1000 minutes from first date " + DateOperations.subtractMinute(date1, 1000));
        System.out.println("Subtract 121 hours from first date " + DateOperations.subtractHour(date1, 121));
        System.out.println("Subtract 382 days from first date " + DateOperations.subtractDay(date1, 382));
        System.out.println("Subtract 16 months from first date " + DateOperations.subtractMonth(date1, 16));
        System.out.println("Subtract 1998 years from first date " + DateOperations.subtractYear(date1, 1998));

        Date date3 = new Date(1600, 12, 31, 6, 11, 51);
        Date date4 = new Date(1888, 2, 29, 1, 0, 43);
        Date date5 = new Date(500, 10, 15, 14, 33, 18);
        Date date6 = new Date(955, 3, 8, 22, 27, 0);
        Date date7 = new Date(1888, 2, 29, 0, 59, 43);
        List<Date> list = new ArrayList<>();
        list.add(date1);
        list.add(date2);
        list.add(date3);
        list.add(date4);
        list.add(date5);
        list.add(date6);
        list.add(date7);
        System.out.println("List of dates:");
        for (Date date : list) {
            System.out.println(date);
        }
        System.out.println("List of dates SORTED:");
        Collections.sort(list);
        for (Date date : list) {
            System.out.println(date);
        }
        System.out.println();
    }

    private static void differenceBetweenDates() throws IOException {
        Date date1;
        Date date2;
        System.out.println("Please enter the first date:");
        String str = reader.readLine();
        if (validation(str) != null) {
            date1 = new Date(validation(str));
        } else {
            System.out.println("Wrong input date");
            return;
        }
        System.out.println("Please enter the second date:");
        str = reader.readLine();
        if (validation(str) != null) {
            date2 = new Date(validation(str));
        } else {
            System.out.println("Wrong input date");
            return;
        }
        System.out.println("Your dates are: ");
        System.out.println(date1);
        System.out.println(date2);
        System.out.println("Choose what you want to calculate the difference in");
        do {
            System.out.println("1 In years");
            System.out.println("2 In months");
            System.out.println("3 In days");
            System.out.println("4 In hours");
            System.out.println("5 In minutes");
            System.out.println("6 In seconds");
            System.out.println("0 Back - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-6]")) {
                switch (str) {
                    case "1":
                        System.out.println(DateOperations.differenceInYears(date1, date2));
                        break;
                    case "2":
                        System.out.println(DateOperations.differenceInMonths(date1, date2));
                        break;
                    case "3":
                        System.out.println(DateOperations.differenceInDays(date1, date2));
                        break;
                    case "4":
                        System.out.println(DateOperations.differenceInHours(date1, date2));
                        break;
                    case "5":
                        System.out.println(DateOperations.differenceInMinutes(date1, date2));
                        break;
                    case "6":
                        System.out.println(DateOperations.differenceInSeconds(date1, date2));
                        break;
                }
            } else {
                System.out.println("Wrong input");
            }
        } while (!str.equals("0"));
    }

    private static void addToDate() throws IOException {
        Date date;
        System.out.println("Please enter the date:");
        String str = reader.readLine();
        if (validation(str) != null) {
            date = new Date(validation(str));
        } else {
            System.out.println("Wrong input date");
            return;
        }

        System.out.println("Your dates is: ");
        System.out.println(date);
        System.out.println("Select what you want to add to the date");
        do {
            System.out.println("1 Years");
            System.out.println("2 Months");
            System.out.println("3 Days");
            System.out.println("4 Hours");
            System.out.println("5 Minutes");
            System.out.println("6 Seconds");
            System.out.println("0 Back - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-6]")) {
                switch (str) {
                    case "1":
                        System.out.println("Enter the number of Years");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.addYear(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                    case "2":
                        System.out.println("Enter the number of Months");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.addMonth(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                    case "3":
                        System.out.println("Enter the number of Days");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.addDay(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                    case "4":
                        System.out.println("Enter the number of Hours");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.addHour(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                    case "5":
                        System.out.println("Enter the number of Minutes");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.addMinute(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                    case "6":
                        System.out.println("Enter the number of Seconds");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.addSecond(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                }
            } else {
                System.out.println("Wrong input");
            }
        } while (!str.equals("0"));
    }

    private static void subtractFromDate() throws IOException {
        Date date;
        System.out.println("Please enter the date:");
        String str = reader.readLine();
        if (validation(str) != null) {
            date = new Date(validation(str));
        } else {
            System.out.println("Wrong input date");
            return;
        }

        System.out.println("Your dates is: ");
        System.out.println(date);
        System.out.println("Select what you want to subtract from the date");
        do {
            System.out.println("1 Years");
            System.out.println("2 Months");
            System.out.println("3 Days");
            System.out.println("4 Hours");
            System.out.println("5 Minutes");
            System.out.println("6 Seconds");
            System.out.println("0 Back - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-6]")) {
                switch (str) {
                    case "1":
                        System.out.println("Enter the number of Years");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.subtractYear(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                    case "2":
                        System.out.println("Enter the number of Months");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.subtractMonth(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                    case "3":
                        System.out.println("Enter the number of Days");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.subtractDay(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                    case "4":
                        System.out.println("Enter the number of Hours");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.subtractHour(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                    case "5":
                        System.out.println("Enter the number of Minutes");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.subtractMinute(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                    case "6":
                        System.out.println("Enter the number of Seconds");
                        str = reader.readLine();
                        if (checkRegExp(str, "^[0-9]{1,6}$")) {
                            System.out.println(DateOperations.subtractSecond(date, Integer.parseInt(str)));
                        } else {
                            System.out.println("Wrong input number. Too big number");
                            break;
                        }
                        break;
                }
            } else {
                System.out.println("Wrong input");
            }
        } while (!str.equals("0"));
    }

    private static void compareList() throws IOException {
        String str;
        List<Date> list = new ArrayList<>();
        System.out.println("Please enter multiple dates");
        do {
            System.out.println("1 Add another date ");
            System.out.println("2 Display a list of dates");
            System.out.println("3 Display a sorted list of dates");
            System.out.println("0 Back - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-3]")) {
                switch (str) {
                    case "1":
                        System.out.println("Please enter the date:");
                        str = reader.readLine();
                        if (validation(str) != null) {
                            list.add(new Date(validation(str)));
                        } else {
                            System.out.println("Wrong input date");
                            break;
                        }
                        break;
                    case "2":
                        System.out.println("List of dates:");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(list.get(i));
                        }
                        break;
                    case "3":
                        System.out.println("List of dates SORTED:");
                        Collections.sort(list);
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(list.get(i));
                        }
                        break;

                }
            } else {
                System.out.println("Wrong input");
            }
        } while (!str.equals("0"));
    }

    private static Date validation(String inputDate) {
        Date date = new Date();

        if (inputDate.contains(" ")) {
            if (count(inputDate, " ") == 1) {
                String[] words = inputDate.split(" ");
                if (words.length == 2 && dateValidation(words[0]) != null && timeValidation(words[1]) != null) {
                    Date tempD = new Date(dateValidation(words[0]));
                    Date tempT = new Date(timeValidation(words[1]));
                    date.setYear(tempD.getYear());
                    date.setMonth(tempD.getMonth());
                    date.setDay(tempD.getDay());
                    date.setHour(tempT.getHour());
                    date.setMinute(tempT.getMinute());
                    date.setSecond(tempT.getSecond());
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else if (dateValidation(inputDate) != null) {
            Date tempD = new Date(dateValidation(inputDate));
            date.setYear(tempD.getYear());
            date.setMonth(tempD.getMonth());
            date.setDay(tempD.getDay());
        } else {
            return null;
        }
        return date;
    }

    private static Date dateValidation(String inputDate) {
        Date date = new Date();
        if (checkRegExp(inputDate, "[0-9]?[0-9]?[0-9]?[0-9]")) {
            date.setYear(Integer.parseInt(inputDate));
            return date;
        }

        if (isDMY && (checkRegExp(inputDate, DATE_PATTERN_DMY) || checkRegExp(inputDate, DATE_PATTERN_DMY_simple))) {
            String[] dateParts = inputDate.split("(\\/|-|\\.)");
            if (dateParts.length > 1 && !dateParts[1].isEmpty() && dateParts[1].length() > 2) {
                if (monthNumber(dateParts[1]) < 1 || monthNumber(dateParts[1]) > 12) {
                    return null;
                }
                date.setMonth(monthNumber(dateParts[1]));
            } else if (dateParts.length > 1 && !dateParts[1].isEmpty()) {
                if (Integer.parseInt(dateParts[1]) < 1 || Integer.parseInt(dateParts[1]) > 12) {
                    return null;
                }
                date.setMonth(Integer.parseInt(dateParts[1]));
            }
            if (dateParts.length > 0 && !dateParts[0].isEmpty()) {
                if (Integer.parseInt(dateParts[0]) < 1 || Integer.parseInt(dateParts[0]) > 31 || Integer.parseInt(dateParts[0]) > DateOperations.daysInMonth(date.getMonth())) {
                    return null;
                }
                date.setDay(Integer.parseInt(dateParts[0]));
            }
            if (dateParts.length > 2 && !dateParts[2].isEmpty()) {
                if (Integer.parseInt(dateParts[2]) < 0) {
                    return null;
                }
                date.setYear(Integer.parseInt(dateParts[2]));
            }

        } else if (!isDMY && (checkRegExp(inputDate, DATE_PATTERN_MDY) || checkRegExp(inputDate, DATE_PATTERN_MDY_simple))) {
            String[] dateParts = inputDate.split("(\\/|-|\\.)");
            if (dateParts.length > 0 && !dateParts[0].isEmpty() && dateParts[0].length() > 2) {
                if (monthNumber(dateParts[0]) < 1 || monthNumber(dateParts[0]) > 12) {
                    return null;
                }
                date.setMonth(monthNumber(dateParts[0]));
            } else if (dateParts.length > 0 && !dateParts[0].isEmpty()) {
                if (Integer.parseInt(dateParts[0]) < 1 || Integer.parseInt(dateParts[0]) > 12) {
                    return null;
                }
                date.setMonth(Integer.parseInt(dateParts[0]));
            }
            if (dateParts.length > 1 && !dateParts[1].isEmpty()) {
                if (Integer.parseInt(dateParts[1]) < 1 || Integer.parseInt(dateParts[1]) > 31 || Integer.parseInt(dateParts[1]) > DateOperations.daysInMonth(date.getMonth())) {
                    return null;
                }
                date.setDay(Integer.parseInt(dateParts[1]));
            }
            if (dateParts.length > 2 && !dateParts[2].isEmpty()) {
                if (Integer.parseInt(dateParts[2]) < 0) {
                    return null;
                }
                date.setYear(Integer.parseInt(dateParts[2]));
            }
        } else {
            return null;
        }
        return date;
    }

    private static Date timeValidation(String inputTime) {
        Date date = new Date();
        if ((checkRegExp(inputTime, TIME_PATTERN_HMS) || checkRegExp(inputTime, TIME_PATTERN_MS))) {
            String[] dateParts = inputTime.split(":");
            if (dateParts.length == 2) {
                date.setMinute(Integer.parseInt(dateParts[0]));
                date.setSecond(Integer.parseInt(dateParts[1]));
            } else if (dateParts.length == 3) {
                date.setHour(Integer.parseInt(dateParts[0]));
                date.setMinute(Integer.parseInt(dateParts[1]));
                date.setSecond(Integer.parseInt(dateParts[2]));
            } else {
                return null;
            }
        } else {
            return null;
        }
        return date;
    }

    private static boolean checkRegExp(String str, Pattern p) {
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

    private static int monthNumber(String month) {
        switch (month) {
            case "Jan":
                return 1;
            case "Feb":
                return 2;
            case "Mar":
                return 3;
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "Jun":
                return 6;
            case "Jul":
                return 7;
            case "Aug":
                return 8;
            case "Sep":
                return 9;
            case "Oct":
                return 10;
            case "Nov":
                return 11;
            case "Dec":
                return 12;
        }
        return -1;
    }

    private static boolean checkRegExp(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}

