package controller;

import lombok.SneakyThrows;
import service.AddTimeService;
import dao.CreateDateService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static dao.CreateDateService.calendarList;

public class AddTimeController {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String EXCEPTION = "You entered invalid characters!";
    private static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------";
    private static final String ACT = "********************************************* COMPARE DATES ********************************************";
    private static final String EXIT = "********************************************************************************************************";
    AddTimeService addTimeService = new AddTimeService();

    @SneakyThrows
    public void addTime() {
        System.out.print(ACT + "\nEnter the date in one of the available string formats:\n1/10/34\n/5/47 00:24:00\n/2/\n1256 59:59\nInput: ");
        new CreateDateService().create();
        System.out.println(SEPARATOR);
        System.out.println(calendarList.get(0));
        System.out.println(SEPARATOR);
        while (true) {
            System.out.print("1.Add year(s) \n" +
                    "2.Add Month(s)\n" +
                    "3.Add Day(s)\n" +
                    "4.Add Hour(s)\n" +
                    "5.Add Minute(s)\n" +
                    "6.Add Second(s)\n" +
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
                        System.out.print("Enter the number of Years to add: ");
                        int years = Integer.parseInt(bufferedReader.readLine());
                        addTimeService.addYear(calendarList, years);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 2:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Months to add: ");
                        int month = Integer.parseInt(bufferedReader.readLine());
                        addTimeService.addMonth(calendarList, month);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 3:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Days to add: ");
                        int days = Integer.parseInt(bufferedReader.readLine());
                        addTimeService.addDays(calendarList, days);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 4:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Hours to add: ");
                        int hours = Integer.parseInt(bufferedReader.readLine());
                        addTimeService.addHours(calendarList, hours);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 5:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Minutes to add: ");
                        int minutes = Integer.parseInt(bufferedReader.readLine());
                        addTimeService.addMinutes(calendarList, minutes);
                        System.out.println(SEPARATOR);
                        System.out.println(calendarList.get(0));
                        System.out.println(SEPARATOR);
                        break;
                    case 6:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the number of Seconds to add: ");
                        int seconds = Integer.parseInt(bufferedReader.readLine());
                        addTimeService.addSeconds(calendarList, seconds);
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
