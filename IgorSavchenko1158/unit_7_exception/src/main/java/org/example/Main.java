package org.example;

import org.example.mydateandtime.MyDateAndTime;
import org.example.mydateandtime.MyFormatter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        UI();
    }

    private static List<MyDateAndTime> dates = new ArrayList<>();
    private static MyFormatter.DateFormats format = MyFormatter.DateFormats.DD_MMM_YYYY;

    private static void UI() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("======");
            System.out.println("Available commands:");
            System.out.println("0 #To exit");
            System.out.println("plus <dd/mm/yy hh:mm:ss>  #To add new date to the list; Any part of the date may be omitted, time or seconds may be omitted");
            System.out.println("remove n #To remove date denoted by number n");
            System.out.println("diff n m #To find time difference between two dates");
            System.out.println("add <scale> n x #To add x years, months, days, hours, minutes or seconds to date n; Enter negative number to subtract");
            System.out.println("sort asc/desc #To see dates sorted ascending or descending");
            System.out.println("format n #To format output");
            System.out.println("fill #To fill date list with ready values");

            System.out.println("======");
            if (dates.isEmpty()) {
                System.out.println("No dates yet");
            } else {
                System.out.println("Dates:");
                for (int i = 1; i <= dates.size(); i++) {
                    System.out.println(i + ". " + MyFormatter.format(dates.get(i - 1), format));
                }
            }

            System.out.println("======");
            System.out.println("Available formats:");
            var values = MyFormatter.DateFormats.values();
            for (int i = 1; i <= MyFormatter.DateFormats.values().length; i++) {
                System.out.print(i + ". " + values[i - 1].format + " ");
            }
            System.out.println();

            System.out.println("======");
            String input = scanner.nextLine().strip();
            if (input.equals("0")) {
                return;
            }
            if (input.startsWith("plus")) {
                try {
                    plus(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("Incorrect input: " + e.getMessage());
                    continue;
                }

            } else if (input.startsWith("remove")) {
                try {
                    remove(input);
                } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                    System.out.println("Incorrect input: " + e.getMessage());
                    continue;
                }

            } else if (input.startsWith("diff")) {
                try {
                    diff(input);
                } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                    System.out.println("Incorrect input: " + e.getMessage());
                    continue;
                }

            } else if (input.startsWith("add")) {
                try {
                    add(input);
                } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                    System.out.println("Incorrect input: " + e.getMessage());
                    continue;
                }

            } else if (input.startsWith("sort")) {
                try {
                    sort(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("Incorrect input: " + e.getMessage());
                    continue;
                }

            } else if (input.startsWith("format")) {
                try {
                    setFormat(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("Incorrect input: " + e.getMessage());
                    continue;
                }
            } else if (input.startsWith("fill")) {
                fill();
            } else {
                System.out.println("Incorrect input, try again");
                continue;
            }
            System.out.println("Success");
        }
    }

    private static void plus(String input) {
        String[] parts = input.split("\\s");
        if (parts.length != 2 && parts.length != 3) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        MyDateAndTime parsed = MyFormatter.parse(parts[1], parts.length == 3 ? parts[2] : null);
        dates.add(parsed);
    }

    private static void remove(String input) {
        String[] parts = input.split("\\s");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Incorrect argument");
        }
        dates.remove(Integer.parseInt(parts[1]) - 1);
    }

    private static void diff(String input) {
        String[] parts = input.split("\\s");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        int index1 = Integer.parseInt(parts[1]) - 1;
        int index2 = Integer.parseInt(parts[2]) - 1;
        if (index1 < 0 || index1 >= dates.size() || index2 < 0 || index2 >= dates.size()) {
            throw new IndexOutOfBoundsException("No date with such index");
        }
        System.out.println("Difference between " + MyFormatter.format(dates.get(index1), format)
                + " and " + MyFormatter.format(dates.get(index2), format));
        System.out.println("In years: " + dates.get(index1).diffInYears(dates.get(index2)));
        System.out.println("In months: " + dates.get(index1).diffInMonths(dates.get(index2)));
        System.out.println("In days: " + dates.get(index1).diffInDays(dates.get(index2)));
        System.out.println("In hours: " + dates.get(index1).diffInHours(dates.get(index2)));
        System.out.println("In minutes: " + dates.get(index1).diffInMinutes(dates.get(index2)));
        System.out.println("In seconds: " + dates.get(index1).diffInSeconds(dates.get(index2)));
    }

    private static void add(String input) {
        String[] parts = input.split("\\s");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        int index = Integer.parseInt(parts[2]) - 1;
        int number = Integer.parseInt(parts[3]);
        MyDateAndTime result;
        switch (parts[1]) {
            case "years": {
                result = dates.get(index).addYears(number);
                break;
            }
            case "months": {
                result = dates.get(index).addMonths(number);
                break;
            }
            case "days": {
                result = dates.get(index).addDays(number);
                break;
            }
            case "hours": {
                result = dates.get(index).addHours(number);
                break;
            }
            case "minutes": {
                result = dates.get(index).addMinutes(number);
                break;
            }
            case "seconds": {
                result = dates.get(index).addSeconds(number);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unrecognized scale");
            }
        }
        dates.set(index, result);
    }

    private static void sort(String input) {
        String[] parts = input.split("\\s");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        if (dates.isEmpty()) {
            throw new IllegalArgumentException("No dates yet");
        }
        Set<MyDateAndTime> datesSet = null;
        switch (parts[1]) {
            case "asc": {
                datesSet = new TreeSet<>(dates);
                break;
            }
            case "desc": {
                datesSet = new TreeSet<>(dates).descendingSet();
                break;
            }
            default:
                throw new IllegalArgumentException("Sorting method incorrect");
        }
        System.out.println("Dates sorted:");
        datesSet.forEach((e) -> {
            System.out.println(MyFormatter.format(e, format));
        });
    }

    private static void setFormat(String input) {
        String[] parts = input.split("\\s");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        int index = Integer.parseInt(parts[1]);
        MyFormatter.DateFormats[] values = MyFormatter.DateFormats.values();
        if (index < 1 || index > values.length) {
            throw new IllegalArgumentException("Incorrect index");
        }
        format = values[index - 1];
    }

    private static void fill() {
        dates = new ArrayList<>();
        dates.add(new MyDateAndTime(2021, 6, 5, 23, 27, 54));
        dates.add(new MyDateAndTime(2022, 7, 1, 12, 42, 11));
        dates.add(new MyDateAndTime(1921, 7, 1, 12, 42, 11));
        dates.add(new MyDateAndTime(3022, 4, 8, 6, 11, 59));
        dates.add(new MyDateAndTime(2020, 2, 29, 3, 3, 0));
    }
}
