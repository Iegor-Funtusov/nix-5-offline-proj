package controller;

import dao.CreateDateService;
import lombok.SneakyThrows;
import service.SubtractTimeService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static dao.CreateDateService.calendarList;

public class SubtractTimeController {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String EXCEPTION = "You entered invalid characters!";
    private static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------";
    private static final String ACT = "********************************************* COMPARE DATES ********************************************";
    private static final String EXIT = "********************************************************************************************************";
    SubtractTimeService subtractTimeService = new SubtractTimeService();

    @SneakyThrows
    public void subtractTime() {
        System.out.print(ACT + "\nEnter the date in one of the available string formats:\n1/10/34\n/5/47 00:24:00\n/2/\n1256 59:59\nInput: ");
        new CreateDateService().create();
        System.out.println(SEPARATOR);
        System.out.println(calendarList.get(0));
        System.out.println(SEPARATOR);
        while (true) {
            System.out.print("1.Subtract year(s) \n" +
                    "2.Subtract Month(s)\n" +
                    "3.Subtract Day(s)\n" +
                    "4.Subtract Hour(s)\n" +
                    "5.Subtract Minute(s)\n" +
                    "6.Subtract Second(s)\n" +
                    "Back(9)\n" +
                    "Exit(0)\n" +
                    "Select an action: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println(EXIT);
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Years to subtract: ");
                        int years = Integer.parseInt(bufferedReader.readLine());
                        subtractTimeService.subtractYear(calendarList, years);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 2:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Months to subtract: ");
                        int month = Integer.parseInt(bufferedReader.readLine());
                        subtractTimeService.subtractMonth(calendarList, month);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 3:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Days to subtract: ");
                        int days = Integer.parseInt(bufferedReader.readLine());
                        subtractTimeService.subtractDays(calendarList, days);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 4:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Hours to subtract: ");
                        int hours = Integer.parseInt(bufferedReader.readLine());
                        subtractTimeService.subtractHours(calendarList, hours);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 5:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Minutes to subtract: ");
                        int minutes = Integer.parseInt(bufferedReader.readLine());
                        subtractTimeService.subtractMinutes(calendarList, minutes);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 6:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Seconds to subtract: ");
                        int seconds = Integer.parseInt(bufferedReader.readLine());
                        subtractTimeService.subtractSeconds(calendarList, seconds);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 9:
                        calendarList.clear();
                        new ApplicationMain().run();
                        break;
                    default:
                        System.out.println(SEPARATOR);
                        System.out.println(EXCEPTION);
                        System.out.println(SEPARATOR);
                }
            } catch (NumberFormatException exception) {
                System.out.println(SEPARATOR);
                System.out.println(EXCEPTION);
                System.out.println(SEPARATOR);
            }
        }
    }
}
