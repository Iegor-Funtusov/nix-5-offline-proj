package ua.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalendarController {
    private static final BufferedReader reader;
    private static final String REGEX_CONST = "^[0-9]$";
    private static final String REGEX_NUMBER = "^[0-9]+$";
    private static final String REGEX_TIME = "^(\\d\\d:\\d\\d)$";
    private static final String REGEX_DD_MM_YYYY = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])\\/(0[1-9]|1[0-2])\\/(\\d{4})$";
    private static final String REGEX_M_D_YYYY = "^(1[0-2]|[1-9])\\/(3[01]|[12][0-9]|[1-9])\\/(\\d{4})$";
    private static final String PATTERN_1 = "dd/mm/yyyy";
    private static final String PATTERN_2 = "m/d/yyyy";


    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void differenceBetweenDates() {
        messageForDifference();
        switch (inputConstant()) {
            case "1": {
                System.out.println(createDate().getDiffYears(createDate()));
                break;
            }
            case "2": {
                System.out.println(createDate().getDiffMonths(createDate()));
                break;
            }
            case "3": {
                System.out.println(createDate().getDiffDays(createDate()));
                break;
            }
            case "4": {
                System.out.println(createDate().getDiffHours(createDate()));
                break;
            }
            case "5": {
                System.out.println(createDate().getDiffMinutes(createDate()));
                break;
            }
            case "6": {
                System.out.println(createDate().getDiffSeconds(createDate()));
                break;
            }
        }
    }

    public void plusOrMinusAmountToDate(int x) {
        Calendar date = createDate();
        messageForPlusOrMinusOperation();
        switch (inputConstant()) {
            case "1": {
                if (x == 1) {
                    date.plusYears(inputNumber("years"));

                } else if (x == 2) {
                    date.minusYears(inputNumber("years"));
                }
                System.out.println("New date: " + date);
                break;
            }
            case "2": {
                if (x == 1) {
                    date.plusMonths(inputNumber("months"));

                } else if (x == 2) {
                    date.minusMonths(inputNumber("months"));
                }
                System.out.println("New date: " + date);
                break;
            }
            case "3": {
                if (x == 1) {
                    date.plusDays(inputNumber("days"));

                } else if (x == 2) {
                    date.minusDays(inputNumber("days"));
                }
                System.out.println("New date: " + date);
                break;
            }
            case "4": {
                if (x == 1) {
                    date.plusHours(inputNumber("hours"));

                } else if (x == 2) {
                    date.minusHours(inputNumber("hours"));
                }
                System.out.println("New date: " + date);
                break;
            }
            case "5": {
                if (x == 1) {
                    date.plusMinutes(inputNumber("minutes"));

                } else if (x == 2) {
                    date.minusMinutes(inputNumber("minutes"));
                }
                System.out.println("New date: " + date);
                break;
            }
            case "6": {
                if (x == 1) {
                    date.plusSeconds(inputNumber("seconds"));

                } else if (x == 2) {
                    date.minusSeconds(inputNumber("seconds"));
                }
                System.out.println("New date: " + date);
                break;
            }
        }
    }

    public void sortDatesByLong() {
        List<Calendar> list = new ArrayList<>();
        int x = inputNumber("dates");
        Calendar date;
        for (int i = 0; i < x; i++) {
            date = createDate();
            list.add(date);
        }
        setActionForSort(list);
        System.out.println(list);
    }

    private Calendar createDate() {
        System.out.println("Create a date");
        Calendar date = new Calendar();
        setActionForCreate(date);
        System.out.println("success");
        messageForTime();
        if (inputConstant().equals("1")) {
            inputTime(date);
        }
        return date;
    }

    private void setActionForSort(List<Calendar> list) {
        System.out.println("Choose a action:\n" +
                "1 - Sort by increasing\n" +
                "2 - Sort by descending");
        switch (inputConstant()) {
            case "1": {
                list.sort(Comparator.comparing(Calendar::getDateInSeconds));
                break;
            }
            case "2": {
                list.sort(Comparator.comparing(Calendar::getDateInSeconds).reversed());
                break;
            }
            case "0": {
            }
        }
    }

    private void setActionForCreate(Calendar date) {
        System.out.println("Choose a format:\n" +
                "1 - dd/mm/yyyy\n" +
                "2 - m/d/yyyy");
        switch (inputConstant()) {
            case "1": {
                parserDate1(inputDate(PATTERN_1, REGEX_DD_MM_YYYY), date);
                break;
            }
            case "2": {
                parserDate2(inputDate(PATTERN_2, REGEX_M_D_YYYY), date);
            }
        }
    }

    private void parserDate1(String text, Calendar date) {
        String[] array = text.split("/");
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].charAt(0) == '0') {
                array[i] = array[i].substring(1);
            }
        }
        while (array[2].charAt(0) == '0') {
            array[2] = array[2].substring(1);
        }
        date.setDay(Integer.parseInt(array[0]));
        date.setMonth(Integer.parseInt(array[1]));
        date.setYear(Integer.parseInt(array[2]));
    }

    private void parserDate2(String text, Calendar date) {
        String[] array = text.split("/");
        while (array[2].charAt(0) == '0') {
            array[2] = array[2].substring(1);
        }
        date.setDay(Integer.parseInt(array[1]));
        date.setMonth(Integer.parseInt(array[0]));
        date.setYear(Integer.parseInt(array[2]));
    }

    private String inputDate(String pattern, String regex) {
        String input;
        do {
            System.out.println("Please write a date like: " + pattern);
            try {
                input = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("Failed to read date", e);
            }
        } while (!input.matches(regex));
        return input;
    }

    private void inputTime(Calendar date) {
        String input;
        String[] array;
        do {
            do {
                System.out.println("Write a time of day like '01:01' please:");
                try {
                    input = reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException("Failed to read date", e);
                }
            } while (!input.matches(REGEX_TIME));
            array = input.split(":");
            for (int i = 0; i < array.length; i++) {
                if (array[i].charAt(0) == '0') {
                    array[i] = String.valueOf(array[i].charAt(1));
                }
            }
        } while (Integer.parseInt(array[0]) > 23 || Integer.parseInt(array[1]) > 59);
        date.setHour(Integer.parseInt(array[0]));
        date.setMinute(Integer.parseInt(array[1]));
    }

    private int inputNumber(String time) {
        String num;
        do {
            try {
                System.out.println("Write amount of " + time);
                num = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("failed to read input", e);
            }
        } while (!num.matches(REGEX_NUMBER));
        return Integer.parseInt(num);
    }

    private String inputConstant() {
        String constant;
        do {
            System.out.println("Number:");
            try {
                constant = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("failed to read input", e);
            }
        } while (!constant.matches(REGEX_CONST));
        return constant;
    }

    private void messageForDifference() {
        System.out.println("Please, choose the difference format:\n" +
                "1 - In years\n" +
                "2 - In months\n" +
                "3 - In days\n" +
                "4 - In hours\n" +
                "5 - In minutes\n" +
                "6 - In seconds");
    }

    private void messageForPlusOrMinusOperation() {
        System.out.println("Please, choose the format which we will change:\n" +
                "1 - Years\n" +
                "2 - Months\n" +
                "3 - Days\n" +
                "4 - Hours\n" +
                "5 - Minutes\n" +
                "6 - Seconds");
    }

    private void messageForTime() {
        System.out.println("Please write '1' if you want to add time, or other number for continue");
    }

}
