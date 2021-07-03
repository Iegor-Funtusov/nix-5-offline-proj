package services;

import java.util.ArrayList;
import java.util.List;

public class DateConverter {
    public List<String> converter(List<String> dates) {
        List<String> convertedDates = new ArrayList<>();
        dates.stream()
                .map(this::convertDate)
                .forEach(convertedDates::addAll);
        return convertedDates;
    }

    private List<String> convertDate(String date) {
        List<String> convertedDates = new ArrayList<>();
        int[] dateArray = new int[3];
        if (days(date)) {
            if (date.contains("-") && !date.contains("/")) {
                String[] numbers = date.split("-");
                dateArray[0] = Integer.parseInt(numbers[0]);
                dateArray[1] = Integer.parseInt(numbers[1]);
                dateArray[2] = Integer.parseInt(numbers[2]);
                if (correctDate(dateArray)) {
                    if (dateArray[0] > 0 && dateArray[0] < 10 && dateArray[1] > 0 && dateArray[1] < 10)
                        convertedDates.add(dateArray[2] + "0" + dateArray[0] + "0" + dateArray[1]);
                    else if (dateArray[1] > 0 && dateArray[1] < 10)
                        convertedDates.add(dateArray[2] + "" + dateArray[0] + "0" + dateArray[1]);
                    else if (dateArray[0] >= 10 && dateArray[1] >= 10)
                        convertedDates.add(dateArray[2] + "" + dateArray[0] + "" + dateArray[1]);
                    else if (dateArray[0] > 0 && dateArray[0] < 10)
                        convertedDates.add(dateArray[2] + "0" + dateArray[0] + "" + dateArray[1]);
                }
            } else if (date.contains("/") && !date.contains("-")) {
                String[] numbers = date.split("/");
                dateArray[0] = Integer.parseInt(numbers[0]);
                dateArray[1] = Integer.parseInt(numbers[1]);
                dateArray[2] = Integer.parseInt(numbers[2]);
                if (correctDate(dateArray)) {
                    if (dateArray[0] > 0 && dateArray[0] < 10 && dateArray[1] > 0 && dateArray[1] < 10)
                        convertedDates.add(dateArray[2] + "0" + dateArray[0] + "0" + dateArray[1]);
                    else if (dateArray[1] > 0 && dateArray[1] < 10)
                        convertedDates.add(dateArray[2] + "" + dateArray[0] + "0" + dateArray[1]);
                    else if (dateArray[0] > 0 && dateArray[0] < 10)
                        convertedDates.add(dateArray[2] + "0" + dateArray[0] + "" + dateArray[1]);
                    else if (dateArray[0] >= 10 && dateArray[1] >= 10)
                        convertedDates.add(dateArray[2] + "" + dateArray[0] + "" + dateArray[1]);

                }
            }
        } else if (years(date)) {
            String[] numbers = date.split("/");
            dateArray[0] = Integer.parseInt(numbers[1]);
            dateArray[1] = Integer.parseInt(numbers[2]);
            dateArray[2] = Integer.parseInt(numbers[0]);
            if (correctDate(dateArray))
                convertedDates.add(date.replace("/", ""));
        }
        return convertedDates;
    }

    private boolean days(String s) {
        int counter = 0;
        if (s.length() < 7)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 2 || i == 5) {
                if (s.charAt(i) == '/' && (counter != 0 || counter != 1)) {
                    counter = 1;
                } else if (s.charAt(i) == '-' && (counter != 0 || counter != 2))
                    counter = 2;
                else
                    return false;
                continue;
            }
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean years(String s) {
        if (s.length() < 7)
            return false;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                if (s.charAt(i) == '/') {
                    counter++;
                    if (counter == 2 && s.charAt(i - 3) == '/' && s.length() - i - 1 == 2) {
                        if (Character.isDigit(s.charAt(i + 1)) && Character.isDigit(s.charAt(i + 2)))
                            return true;
                        else
                            return false;
                    }
                } else
                    return false;
            }
        }
        return false;
    }

    private boolean correctDate(int[] date) {
        int day = date[0];
        int month = date[1];
        int year = date[2];
        if (month >= 1 && month <= 12) {
            if ((month <= 7 && month % 2 == 1) || (month >= 8 && month % 2 == 0)) {
                if (day >= 1 && day <= 31) {
                    return true;
                } else {
                    return false;
                }
            } else if (month == 2 && year % 400 == 0) {
                if (day >= 1 && day <= 29) {
                    return true;
                } else {
                    return false;
                }
            } else if (month == 2 && year % 100 == 0) {
                if (day >= 1 && day <= 28) {
                    return true;
                } else {
                    return false;
                }
            } else if (month == 2 && year % 4 == 0) {
                if (day >= 1 && day <= 29) {
                    return true;
                } else {
                    return false;
                }
            } else if (month == 2) {
                if (day >= 1 && day <= 28) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (day >= 1 && day <= 30) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}