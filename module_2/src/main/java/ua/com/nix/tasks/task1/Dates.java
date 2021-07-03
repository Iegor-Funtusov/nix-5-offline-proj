package ua.com.nix.tasks.task1;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;

public class Dates {

    @SneakyThrows
    public void runDates() {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("module_2/src/main/resources/dates.txt"));
        String inputDate = bufferedReader.readLine();
        String[] dates = new String[3];
        int index = 0;
        while (inputDate!=null)
        {
            dates[index] = inputDate;
            index++;
            inputDate = bufferedReader.readLine();
        }
        for (String date : dates) {
            if (date.contains("/")) {
                String[] dateArray = date.split("[/]");
                System.out.print(date + " = ");
                for (int i = 0; i < dateArray.length; i++) { System.out.print(dateArray[i]); }
                System.out.println();
            } else if (date.contains("-")) {
                String[] dateArray = date.split("[-]");
                System.out.print(date + " = ");
                for (int i = 0; i < dateArray.length; i++) { System.out.print(dateArray[i]); }
                System.out.println();
            }
        }
    }
}
