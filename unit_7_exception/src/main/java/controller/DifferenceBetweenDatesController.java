package controller;

import dao.CreateDateService;
import lombok.SneakyThrows;
import service.DifferenceBetweenDatesService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static dao.CreateDateService.calendarList;

public class DifferenceBetweenDatesController {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String EXCEPTION = "You entered invalid characters!";
    private static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------";
    private static final String ACT = "*************************************** DIFFERENCE BETWEEN DATES ***************************************";
    private static final String EXIT = "********************************************************************************************************";
    DifferenceBetweenDatesService serviceDifferenceBetweenDates = new DifferenceBetweenDatesService();

    @SneakyThrows
    public void differenceBetweenDatesController() {
        System.out.println(ACT);
        int i = 1;
        while (i <= 2) {
            System.out.print("Enter the date " + i + " in one of the available string formats:\n1/10/34\n/5/47 00:24:00\n/2/\n1256 59:59\nInput: ");
            new CreateDateService().create();
            System.out.println(SEPARATOR);
            i++;
        }
        while (true) {
            System.out.println(SEPARATOR);
            calendarList.forEach(System.out::println);
            System.out.println(SEPARATOR);
            System.out.print("1.Difference in years \n" +
                    "2.Difference in Months\n" +
                    "3.Difference in Days\n" +
                    "4.Difference in Hours\n" +
                    "5.Difference in Minutes\n" +
                    "6.Difference in Seconds\n" +
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
                        System.out.println("Difference in Years: " + serviceDifferenceBetweenDates.differenceYears());
                        break;
                    case 2:
                        System.out.println(SEPARATOR);
                        System.out.println("Difference in Months: " + serviceDifferenceBetweenDates.differenceMonth());
                        break;
                    case 3:
                        System.out.println(SEPARATOR);
                        System.out.println("Difference in Days: " + serviceDifferenceBetweenDates.differenceDays());
                        break;
                    case 4:
                        System.out.println(SEPARATOR);
                        System.out.println("Difference in Hours: " + serviceDifferenceBetweenDates.differenceHours());
                        break;
                    case 5:
                        System.out.println(SEPARATOR);
                        System.out.println("Difference in Minutes: " + serviceDifferenceBetweenDates.differenceMinutes());
                        break;
                    case 6:
                        System.out.println(SEPARATOR);
                        System.out.println("Difference in Seconds: " + serviceDifferenceBetweenDates.differenceSeconds());
                        break;
                    case 9:
                        System.out.println(SEPARATOR);
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
