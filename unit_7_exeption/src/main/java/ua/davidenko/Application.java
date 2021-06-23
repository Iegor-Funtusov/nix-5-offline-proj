package ua.davidenko;


import ua.davidenko.formatter.*;
import ua.davidenko.formatter.Formatter;
import ua.davidenko.date.Date;
import ua.davidenko.date.DateDifference;
import ua.davidenko.date.DateSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Application {

    private static final Map<Integer, Formatter> FORMATTERS = new HashMap<>();
    private static Formatter userFormatter;


    private static void init() {
        FORMATTERS.put(1, new DayMonthYearFormatter());
        FORMATTERS.put(2, new MonthDayYearFormatter());
        FORMATTERS.put(3, new MonthNameDayYearFormatter());
        FORMATTERS.put(4, new DateTimeFormatter());
    }

    public static void app()  {

        init();
        Date userDate = null;

        System.out.println("Select date format:");
        System.out.println("1 - dd/mm/yy (example: 01/12/21)");
        System.out.println("2 - m/d/yyyy (example: 3/4/2021)");
        System.out.println("3 - mmm-d-yy (example: Март-4-21)");
        System.out.println("4 - dd-mmm-yyyy 00:00 (example: 09-Апрель-1789 00:00)");

        int formatterId = new Scanner(System.in).nextInt();

        userFormatter = FORMATTERS.get(formatterId);

        System.out.println("Enter date:");
        String dateAsString = null;
        try {
            dateAsString = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userDate = userFormatter.parse(dateAsString);
        System.out.println("Your date is: " + userDate);


        while (true) {
            System.out.println("Available options:");
            System.out.println("1 - enter new date and find difference");
            System.out.println("2 - add time");
            System.out.println("3 - subtract time");
            System.out.println("4 - enter a list of dates and sort them");
            int selectedOption = new Scanner(System.in).nextInt();
            switch (selectedOption) {
                case 1:
                    try {
                        dateDifference(userDate);
                    } catch (IOException e) {
                        System.out.println("Wrong input");
                    }
                    break;
                case 2:
                    try {
                        addToDate(userDate);
                    } catch (IOException e) {
                        System.out.println("Wrong input");;
                    }
                    break;
                case 3:
                    try {
                        subtractFromDate(userDate);
                    } catch (IOException e) {
                        System.out.println("Wrong input");
                    }
                    break;
                case 4:
                    try {
                        datesSort();
                    } catch (IOException e) {
                        System.out.println("Wrong input");
                    }
                    break;
                default:
                    System.out.println("Unknown option, try again");
            }
        }
    }

    private static void dateDifference(Date date) throws IOException {
        System.out.println("Enter a new date fo find difference");
        Date nextDate;
        String nextDateAsString = new BufferedReader(new InputStreamReader(System.in)).readLine();
        nextDate = userFormatter.parse(nextDateAsString);
        System.out.println("Find difference in: \n" +
                "1 - Years,2 - Months,3 - Days,4 - Hours,5 - Minutes,6 - Seconds");
        int selectedOption = new Scanner(System.in).nextInt();
        switch (selectedOption) {
            case 1:
                double yearDiff = DateDifference.differenceInYears(date, nextDate);
                System.out.println("Difference is: " + yearDiff);
                break;
            case 2:
                double monthDiff = DateDifference.differenceInMonths(date, nextDate);
                System.out.println("Difference is: " + monthDiff);
                break;
            case 3:
                double dayDiff = DateDifference.differenceInDays(date, nextDate);
                System.out.println("Difference is: " + dayDiff);
                break;
            case 4:
                double hourDiff = DateDifference.differenceInHours(date, nextDate);
                System.out.println("Difference is: " + hourDiff);
                break;
            case 5:
                double minuteDiff = DateDifference.differenceInMinutes(date, nextDate);
                System.out.println("Difference is: " + minuteDiff);
                break;
            case 6:
                double secondDiff = DateDifference.differenceInSeconds(date, nextDate);
                System.out.println("Difference is: " + secondDiff);
                break;
            default:
                System.out.println("Wrong input");
        }
    }

    private static void addToDate(Date date) throws IOException {
        System.out.println("What you wont ADD to date?" +
                "1 - Seconds,2 - Minutes,3 - Hours,4 - Days,5 - Month,6 - Years");
        int selectedOption = new Scanner(System.in).nextInt();
        System.out.println("Enter a count for ADD");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        switch (selectedOption) {
            case 1:
                date.addSeconds(time);
                System.out.println("Your NEW date is: " + date);
                break;
            case 2:
                date.addMinutes(time);
                System.out.println("Your NEW date is: " + date);
                break;
            case 3:
                date.addHours(time);
                System.out.println("Your NEW date is: " + date);
                break;
            case 4:
                date.addDays(time);
                System.out.println("Your NEW date is: " + date);
                break;
            case 5:
                date.addMonths(time);
                System.out.println("Enter a count of Months");
                System.out.println("Your NEW date is: " + date);
                break;
            case 6:
                date.addYears(time);
                System.out.println("Your NEW date is: " + date);
                break;
            default:
                System.out.println("Wrong input");

        }
    }

    private static void subtractFromDate(Date date) throws IOException {
        System.out.println("What you wont SUBTRACT from date?" +
                "1 - Seconds,2 - Minutes,3 - Hours,4 - Days,5 - Month,6 - Years");
        int selectedOption = new Scanner(System.in).nextInt();
        System.out.println("Enter a count for SUBTRACT");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        switch (selectedOption) {
            case 1:
                date.minusSeconds(time);
                System.out.println("Your NEW date is: " + date);
                break;
            case 2:
                date.minusMinutes(time);
                System.out.println("Your NEW date is: " + date);
                break;
            case 3:
                date.minusHours(time);
                System.out.println("Your NEW date is: " + date);
                break;
            case 4:
                date.minusDays(time);
                System.out.println("Your NEW date is: " + date);
                break;
            case 5:
                date.minusMonths(time);
                System.out.println("Your NEW date is: " + date);
                break;
            case 6:
                date.minusYears(time);
                System.out.println("Your NEW date is: " + date);
                break;
            default:
                System.out.println("Wrong input");
        }
    }

    private static void datesSort() throws IOException {

        Date date;
        List<Date> dateList = new ArrayList<>();
        System.out.println("Input your date for sort. ENTER ''s'' to start sort ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String dateAsString = br.readLine();
            if (dateAsString.equalsIgnoreCase("s")) {
                break;
            } else {
                date = userFormatter.parse(dateAsString);
                dateList.add(date);
            }
            System.out.println(dateList);
        }
            System.out.println("Choose sort type: \n1 - Descending sort,2 - Ascending sort");
            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
            switch (str) {
                    case "1":
                        DateSort.sortByDesc(dateList);
                        for (ua.davidenko.date.Date dates:dateList){
                            System.out.println(dates);
                        }
                        break;
                    case "2":
                        DateSort.sortByAsc(dateList);
                        for (Date dates:dateList){
                            System.out.println(dates);
                        }
                        break;
                    default:
                        System.out.println("Wrong input");
                }
            }
        }





