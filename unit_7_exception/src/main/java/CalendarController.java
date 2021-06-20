import dataclasses.Calendar;
import dataclasses.Date;
import exception.InvalidDateFormatException;
import service.Add;
import service.Delete;
import service.Delta;
import utils.DateInput;
import utils.DateOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalendarController {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void readConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("it's calendar");
        System.out.println("Please input number ");
        System.out.println("1 - find the difference between dates");
        System.out.println("2 - add time to date");
        System.out.println("3 - subtract time from date");
        System.out.println("4 - date comparison");
        System.out.println("0 - exit");
        try {
            String input = reader.readLine();
            while (!"0".equals(input)) {
                switch (input) {
                    case "1":
                        deltaDates(reader);
                        break;
                    case "2":
                        addTime(reader);
                        break;
                    case "3":
                        delTime(reader);
                        break;
                    case "4":
                        comparisonDates(reader);
                        break;
                    default:
                        System.out.println("Bad input");
                }
                System.out.println("Please input number ");
                System.out.println("1 - find the difference between dates");
                System.out.println("2 - add time to date");
                System.out.println("3 - subtract time from date");
                System.out.println("4 - date comparison");
                System.out.println("0 - exit");
                input = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("input error");
        }
    }

    private void deltaDates(BufferedReader reader) {
        System.out.println("Please input number ");
        System.out.println("1 - in seconds");
        System.out.println("2 - in minutes");
        System.out.println("3 - in hours");
        System.out.println("4 - in years");
        System.out.println("5 - in months");
        System.out.println("6 - in days");
        System.out.println("0 - exit");
        try {
            String input = reader.readLine();
            while (!"0".equals(input)) {
                switch (input) {
                    case "1":
                        deltaSec(reader);
                        break;
                    case "2":
                        deltaMin(reader);
                        break;
                    case "3":
                        deltaHours(reader);
                        break;
                    case "4":
                        deltaYears(reader);
                        break;
                    case "5":
                        deltaMonths(reader);
                        break;
                    case "6":
                        deltaDays(reader);
                        break;
                    default:
                        System.out.println("Bad input");
                }
                System.out.println("Please input number ");
                System.out.println("1 - in seconds");
                System.out.println("2 - in minutes");
                System.out.println("3 - in hours");
                System.out.println("4 - in years");
                System.out.println("5 - in months");
                System.out.println("6 - in days");
                System.out.println("0 - exit");
                input = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Input error");
        }
    }

    private void addTime(BufferedReader reader) {
        System.out.println("Please input number ");
        System.out.println("1 - in seconds");
        System.out.println("2 - in minutes");
        System.out.println("3 - in hours");
        System.out.println("4 - in years");
        System.out.println("5 - in months");
        System.out.println("6 - in days");
        System.out.println("0 - exit");
        try {
            String input = reader.readLine();
            while (!"0".equals(input)) {
                switch (input) {
                    case "1":
                        addSec(reader);
                        break;
                    case "2":
                        addMin(reader);
                        break;
                    case "3":
                        addHours(reader);
                        break;
                    case "4":
                        addYears(reader);
                        break;
                    case "5":
                        addMonths(reader);
                        break;
                    case "6":
                        addDays(reader);
                        break;
                    default:
                        System.out.println("Bad input");
                }
                System.out.println("Please input number ");
                System.out.println("1 - in seconds");
                System.out.println("2 - in minutes");
                System.out.println("3 - in hours");
                System.out.println("4 - in years");
                System.out.println("5 - in months");
                System.out.println("6 - in days");
                System.out.println("0 - exit");
                input = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("input error");
        }
    }

    private void delTime(BufferedReader reader) {
        System.out.println("Please input number ");
        System.out.println("1 - in seconds");
        System.out.println("2 - in minutes");
        System.out.println("3 - in hours");
        System.out.println("4 - in years");
        System.out.println("5 - in months");
        System.out.println("6 - in days");
        System.out.println("0 - exit");
        try {
            String input = reader.readLine();
            while (!"0".equals(input)) {
                switch (input) {
                    case "1":
                        delSec(reader);
                        break;
                    case "2":
                        delMin(reader);
                        break;
                    case "3":
                        delHours(reader);
                        break;
                    case "4":
                        delYears(reader);
                        break;
                    case "5":
                        delMonths(reader);
                        break;
                    case "6":
                        delDays(reader);
                        break;
                    default:
                        System.out.println("Bad input");
                }
                System.out.println("Please input number ");
                System.out.println("1 - in seconds");
                System.out.println("2 - in minutes");
                System.out.println("3 - in hours");
                System.out.println("4 - in years");
                System.out.println("5 - in months");
                System.out.println("6 - in days");
                System.out.println("0 - exit");
                input = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Input error");
        }
    }

    public static String formatInput(BufferedReader reader) throws IllegalArgumentException {
        System.out.println("1 - dd/mm/yy");
        System.out.println("2 - m/d/yyyy");
        System.out.println("3 - mmm-d-yy");
        System.out.println("4 - /m/");
        System.out.println("5 - yyyy mm:ss");
        System.out.println("6 - /m/yy hh:mm:ss");
        System.out.println("7 - dd-mmm-yyyy hh:mm");
        System.out.println("8 - dd/mm/yyyy hh:mm:ss");
        String result = " ";
        try {
            String input = reader.readLine();
            switch (input) {
                case "1":
                    result = "dd/mm/yy";
                    break;
                case "2":
                    result = "m/d/yyyy";
                    break;
                case "3":
                    result = "mmm-d-yy";
                    break;
                case "4":
                    result = "/m/";
                    break;
                case "5":
                    result = "yyyy mm:ss";
                    break;
                case "6":
                    result = "/m/yy hh:mm:ss";
                    break;
                case "7":
                    result = "dd-mmm-yyyy hh:mm";
                    break;
                case "8":
                    result = "dd/mm/yyyy hh:mm:ss";
                    break;
                default:
                    throw new IllegalArgumentException("Bad input");
            }
        } catch (IOException e) {
            System.out.println("Input error");
        }
        return result;
    }


    public static String formatOutput(BufferedReader reader) throws IllegalArgumentException {
        System.out.println("1 - dd/mm/yy");
        System.out.println("2 - m/d/yyyy");
        System.out.println("3 - mmm-d-yy");
        System.out.println("4 - dd-mmm-yyyy hh:mm");
        System.out.println("5 - dd-mmm-yyyy hh:mm:ss");
        String result = " ";
        try {
            String input = reader.readLine();
            switch (input) {
                case "1":
                    result = "dd/mm/yy";
                    break;
                case "2":
                    result = "m/d/yyyy";
                    break;
                case "3":
                    result = "mmm-d-yy";
                    break;
                case "4":
                    result = "dd-mmm-yyyy hh:mm";
                    break;
                case "5":
                    result = "dd-mmm-yyyy hh:mm:ss";
                    break;
                default:
                    throw new IllegalArgumentException("Bad input");
            }
        } catch (IOException e) {
            System.out.println("Input error");
        }
        return result;
    }

    public void deltaSec(BufferedReader reader) {
        try {
            System.out.println("Select the format for entering the first date: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("First date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Select the format for entering the second date: ");
            format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d2 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("Second date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2.getDate()));
            long sec = Delta.getNumberOfSeconds(d1, d2);
            System.out.println("Difference between dates in seconds: " + sec);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            //  System.out.println(e.getMessage());
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void deltaMin(BufferedReader reader) {
        try {
            System.out.println("Select the format for entering the first date: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("First date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Select the format for entering the second date: ");
            format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d2 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("Second date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2.getDate()));
            long minutes = Delta.getNumberOfMinutes(d1, d2);
            System.out.println("Difference between dates in minutes: " + minutes);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void deltaHours(BufferedReader reader) {
        try {
            System.out.println("Select the format for entering the first date: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("First date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Select the format for entering the second date: ");
            format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d2 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("Second date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2.getDate()));
            long hours = Delta.getNumberOfHours(d1, d2);
            System.out.println("Difference between dates in hours: " + hours);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void deltaYears(BufferedReader reader) {
        try {
            System.out.println("Select the format for entering the first date: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("First date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Select the format for entering the second date: ");
            format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d2 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("Second date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2.getDate()));
            long years = Delta.getNumberOfYears(d1, d2);
            System.out.println("Difference between dates in years: " + years);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void deltaMonths(BufferedReader reader) {
        try {
            System.out.println("Select the format for entering the first date: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("First date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Select the format for entering the second date: ");
            format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d2 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("Second date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2.getDate()));
            long months = Delta.getNumberOfMonths(d1, d2);
            System.out.println("Difference between dates in months: " + months);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void deltaDays(BufferedReader reader) {
        try {
            System.out.println("Select the format for entering the first date: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("First date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Select the format for entering the second date: ");
            format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d2 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("Second date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2.getDate()));
            long days = Delta.getNumberOfDays(d1, d2);
            System.out.println("Difference between dates in days: " + days);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void delSec(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity seconds: ");
            Scanner scanner = new Scanner(System.in);
            int seconds = scanner.nextInt();
            Date d2 = Delete.delSeconds(seconds, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void delMin(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity minutes: ");
            Scanner scanner = new Scanner(System.in);
            int minutes = scanner.nextInt();
            Date d2 = Delete.delMinutes(minutes, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void delHours(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity hours: ");
            Scanner scanner = new Scanner(System.in);
            int hours = scanner.nextInt();
            Date d2 = Delete.delHours(hours, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void delYears(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity years: ");
            Scanner scanner = new Scanner(System.in);
            int years = scanner.nextInt();
            Date d2 = Delete.delYears(years, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void delMonths(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity months: ");
            Scanner scanner = new Scanner(System.in);
            int months = scanner.nextInt();
            Date d2 = Delete.delMonths(months, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void delDays(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity days: ");
            Scanner scanner = new Scanner(System.in);
            int days = scanner.nextInt();
            Date d2 = Delete.delDays(days, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void addSec(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity seconds: ");
            Scanner scanner = new Scanner(System.in);
            int seconds = scanner.nextInt();
            Date d2 = Add.addSeconds(seconds, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void addMin(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity minutes: ");
            Scanner scanner = new Scanner(System.in);
            int minutes = scanner.nextInt();
            Date d2 = Add.addMinutes(minutes, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void addHours(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity hours: ");
            Scanner scanner = new Scanner(System.in);
            int hours = scanner.nextInt();
            Date d2 = Add.addHours(hours, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void addYears(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity years: ");
            Scanner scanner = new Scanner(System.in);
            int years = scanner.nextInt();
            Date d2 = Add.addYears(years, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void addMonths(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity months: ");
            Scanner scanner = new Scanner(System.in);
            int months = scanner.nextInt();
            Date d2 = Add.addMonths(months, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void addDays(BufferedReader reader) {
        try {
            System.out.println("Select the date input format: ");
            String format = formatInput(reader);
            System.out.println("Enter the date in the format: " + format);
            Calendar d1 = DateInput.readConsole(format);
            System.out.println("Select the date display format: ");
            String formatOutput = formatOutput(reader);
            System.out.println("Original date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d1.getDate()));
            System.out.println("Enter quantity days: ");
            Scanner scanner = new Scanner(System.in);
            int days = scanner.nextInt();
            Date d2 = Add.addDays(days, d1.getDate());
            System.out.println("Select the date display format: ");
            formatOutput = formatOutput(reader);
            System.out.println("New date: ");
            System.out.println(DateOutput.formatDateToString(formatOutput, d2));
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void comparisonDates(BufferedReader reader) {
        try {
            System.out.println("Enter the number of dates you would like to compare: ");
            Scanner scanner = new Scanner(System.in);
            int count = scanner.nextInt();
            Calendar[] dates = new Calendar[count];
            for (int i = 0; i < count; i++) {
                System.out.println("Select the date input format: ");
                String format = CalendarController.formatInput(reader);
                System.out.println("Enter the date in the format: " + format);
                Calendar date = DateInput.readConsole(format);
                System.out.println("Select the date display format: ");
                String formatOutput = formatOutput(reader);
                System.out.println(DateOutput.formatDateToString(formatOutput, date.getDate()));
                System.out.println();
                dates[i] = date;
            }

            System.out.println("Select the output format for the original dates: ");
            String formatOutput = CalendarController.formatOutput(reader);

            System.out.println("List of dates:");
            for (Calendar date : dates) {
                if (date != null)
                    System.out.println(DateOutput.formatDateToString(formatOutput, date.getDate()));
                else System.out.println("There is nothing to compare with!");
            }
            System.out.println();
            comparisonBigger(reader, dates);
            comparisonSmaller(reader, dates);

        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + e + ": Bad input" + ANSI_RESET);
        } catch (InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println(ANSI_RED + e + ANSI_RESET);
        }
    }

    public void comparisonBigger(BufferedReader reader, Calendar[] dates) {
        try {
            System.out.println("Select the ascending date format: ");
            String formatOutput = formatOutput(reader);
            Calendar.sortBigger(dates);
            System.out.println(" List of dates in ascending order:");
            for (Calendar date : dates) {
                if (date != null)
                    System.out.println(DateOutput.formatDateToString(formatOutput, date.getDate()));
                else System.out.println("There is nothing to compare with!");
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void comparisonSmaller(BufferedReader reader, Calendar[] dates) {
        try {
            System.out.println("Select the descending date format: ");
            String formatOutput = formatOutput(reader);
            Calendar.sortSmaller(dates);
            System.out.println("List of dates in ascending order");
            for (Calendar date : dates) {
                if (date != null)
                    System.out.println(DateOutput.formatDateToString(formatOutput, date.getDate()));
                else System.out.println("There is nothing to compare with");
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
