package org.example.date;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DateController {
    private final BufferedReader reader;

    public DateController(BufferedReader reader){
        this.reader = reader;
    }

    public void dateFormat() throws IOException {
        System.out.println("Use sample or manual generation dates? " + "\n 1 - Sample"
                + "\n 2 - Manual" + "\n 3 - Back to Task selection " +"\n 0 - exit");
        switch (reader.readLine()){
            case "1":{
                List<String> sample = sampleDates();
                System.out.println("sample = " + sample);
                printConvertedDates(sample);
                break;
            }
            case "2":{
                printConvertedDates(manualGenerationDates());
                break;
            }
            case "3":{
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Enter correct operation!");
                dateFormat();
            }
        }
    }
    private void printConvertedDates(List<String> dates){
        DateConverter dateConverter = new DateConverter(dates);
        System.out.println("Filtered date in new format: ");
        System.out.println(dateConverter.convert());
    }

    private List<String> sampleDates(){
        List<String> dates = new ArrayList<>();
        dates.add("2020/04/05");
        dates.add("2020-04-06");
        dates.add("05/07/2020");
        dates.add("32/04/2020");
        dates.add("11-05-2020");
        return dates;
    }

    private List<String> manualGenerationDates() throws IOException {
        List<String> dates = new ArrayList<>();
        System.out.println("Enter number of dates: ");
        int size = Integer.parseInt(reader.readLine());
        for (int i = 0; i < size; i++) {
            System.out.println("Enter date" + i + " :");
            String date = reader.readLine();
            dates.add(date);
        }
        return dates;
    }
}
