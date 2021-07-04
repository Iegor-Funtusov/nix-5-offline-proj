package nix.com;

import nix.com.date_editor.Date;
import nix.com.date_editor.DateEdit;
import nix.com.date_editor.DateService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ExceptionMain {

    static List<Date> dates;

    public static void main(String[] args) {
        DateService dateService = new DateService();
        BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            dates = dateService.readAll();
            System.out.println("Menu\n" +
                    "1. Create date\n" +
                    "2. Difference between dates\n" +
                    "3. Add to date seconds, minute, hours, month and days\n" +
                    "4. Minus date seconds, minute, hours, month and days\n" +
                    "5. Sort dates\n" +
                    "6. Display all dates\n" +
                    "0. Exit");

            int choose;
            try {
                choose = Integer.parseInt(enter.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Wrong input!!!");
                continue;
            }
            switch (choose) {
                case 1:
                    String date = "";
                    while (true) {
                        System.out.println("Enter date (dd/mm/yyyy 01:00, dd/mm/yy 01:00, d/m/yyyy 01:00, " +
                                "mm/dd/yyyy 01:00, mm/dd/yyyy 01:00, mm/dd/yyyy 01:00)");
                        try {
                            date = enter.readLine();
                            dateService.create(date);
                            break;
                        } catch (IOException | RuntimeException e) {
                            System.out.println("Wrong input");
                        }
                    }
                    break;
                case 2:
                    int index1 = 0;
                    int index2 = 0;
                    dates = dateService.readAll();
                    System.out.println("All dates:");
                    System.out.println(dates);
                    DateEdit dateEdit = new DateEdit();

                    try {
                        System.out.println("Enter index first date");
                        index1 = Integer.parseInt(enter.readLine());
                    } catch (NumberFormatException | IOException e) {
                        System.out.println("Wrong index 1 !!!");
                    }

                    try {
                        System.out.println("Enter index second date");
                        index2 = Integer.parseInt(enter.readLine());
                    } catch (NumberFormatException | IOException e) {
                        System.out.println("Wrong index 2 !!!");
                    }

                    if (dates.size() > 1 && index1 < dates.size() && index2 < dates.size()) {
                        System.out.println("Result:");
                        System.out.println(Arrays.toString(dateEdit.differenceDate(dates.get(index1), dates.get(index2))));
                    } else {
                        System.out.println("Wrong dates");
                        break;
                    }
                    break;
                case 3:
                    String addType = "";
                    int index = 0;
                    int addNum = 0;
                    while (true) {
                        try {
                            System.out.println("Enter index of date");
                            index = Integer.parseInt(enter.readLine());
                            if (index > dates.size() || dates.size() < 1) {
                                System.out.println("Wrong index");
                                break;
                            }
                            System.out.println("Enter add number");
                            addNum = Integer.parseInt(enter.readLine());
                        } catch (NumberFormatException | IOException e) {
                            System.out.println("Wrong index or add number!!!");
                        }
                        try {
                            System.out.println("Enter type, like years, days, month, seconds, minutes, hours");
                            addType = enter.readLine();
                            addToDate(addType, index, addNum);
                            break;
                        } catch (IOException | RuntimeException e) {
                            System.out.println("Wrong type");
                        }
                        System.out.println(dates.get(index));
                    }
                    break;
                case 4:
                    String minusType = "";
                    index = 0;
                    addNum = 0;
                    try {
                        System.out.println("Enter index of date");
                        index = Integer.parseInt(enter.readLine());
                        if (index > dates.size() || dates.size() < 1) {
                            System.out.println("Wrong index");
                            break;
                        }
                        System.out.println("Enter minus number");
                        addNum = Integer.parseInt(enter.readLine());
                    } catch (NumberFormatException | IOException e) {
                        System.out.println("Wrong index or add number!!!");
                        break;
                    }

                    while (true) {
                        try {
                            System.out.println("Enter type, like years, days, month, seconds, minutes, hours");
                            minusType = enter.readLine();
                            minusToDate(minusType, index, addNum);
                            break;
                        } catch (IOException | RuntimeException e) {
                            System.out.println("Wrong type");
                        }
                    }
                    System.out.println(dates.get(index));
                    break;
                case 5:
                    dateEdit = new DateEdit();
                    try {
                        System.out.println(Arrays.toString(dateEdit.compareDates(dates)));
                    } catch (RuntimeException e) {
                        System.out.println("Create more dates");
                    }
                    break;
                case 6:
                    System.out.println("All dates:");
                    System.out.println(dates);
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void addToDate(String addType, int index, int addNum) throws RuntimeException {
        switch (addType) {
            case "days":
                dates.get(index).addDays(addNum);
                return;
            case "month":
                dates.get(index).addMonths(addNum);
                return;
            case "years":
                dates.get(index).addYears(addNum);
                return;
            case "hours":
                dates.get(index).addHours(addNum);
                return;
            case "minutes":
                dates.get(index).addMinutes(addNum);
                return;
            case "seconds":
                dates.get(index).addSeconds(addNum);
                return;
        }
        System.out.println("Wrong input type");
        throw new RuntimeException();
    }

    private static void minusToDate(String minusType, int index, int minusNum) throws RuntimeException {
        switch (minusType) {
            case "days":
                dates.get(index).subDays(minusNum);
                return;
            case "month":
                dates.get(index).subMonths(minusNum);
                return;
            case "years":
                dates.get(index).subYears(minusNum);
                return;
            case "hours":
                dates.get(index).subHours(minusNum);
                return;
            case "minutes":
                dates.get(index).subMinutes(minusNum);
                return;
            case "seconds":
                dates.get(index).subSeconds(minusNum);
                return;
        }
        throw new RuntimeException();
    }
}