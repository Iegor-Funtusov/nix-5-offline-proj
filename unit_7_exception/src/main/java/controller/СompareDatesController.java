package controller;

import dao.CreateDateService;
import lombok.SneakyThrows;
import service.СompareDatesService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static dao.CreateDateService.calendarList;

public class СompareDatesController {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    СompareDatesService сompareDatesService = new СompareDatesService();
    private static final String EXCEPTION = "You entered invalid characters!";
    private static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------";
    private static final String ACT = "********************************************* COMPARE DATES ********************************************";
    private static final String EXIT = "********************************************************************************************************";
    private static final String ASCENDING = "---------------------------------------------SORT-ASCENDING---------------------------------------------";
    private static final String DESCENDING = "---------------------------------------------SORT-DESCENDING--------------------------------------------";

    @SneakyThrows
    public void compareDates() {
        while (true) {
            System.out.print(ACT +
                    "\n1.Add date\n" +
                    "2.Display dates in ascending order\n" +
                    "3.Display dates in descending order\n" +
                    "Back(9)\n" +
                    "Exit(0)\n" +
                    "Select an action or press 0 to exit: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println(EXIT);
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                        System.out.println(SEPARATOR);
                        System.out.print("Enter the date in one of the available string formats:\n1/10/34\n/5/47 00:24:00\n/2/\n1256 59:59\nInput: ");
                        new CreateDateService().create();
                        break;
                    case 2:
                        System.out.println(ASCENDING);
                        сompareDatesService.sortAscending();
                        System.out.println(SEPARATOR);
                        break;
                    case 3:
                        System.out.println(DESCENDING);
                        сompareDatesService.sortDescending();
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
