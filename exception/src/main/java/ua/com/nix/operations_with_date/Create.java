package ua.com.nix.operations_with_date;

import ua.com.nix.model.Calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Create {
    Calendar calendar = new Calendar();
    public static List<Calendar> calendarList = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void create() throws IOException {
        String date = reader.readLine();
        try{
            int spaceIndex = date.indexOf(" ");
            if(spaceIndex >= 3){
                String period = date.substring(0, date.indexOf(" "));
                parsing(period, calendar);
                String duration = date.substring(date.indexOf(" ")+1);
                String[] partTimes = duration.split(":");
                if(partTimes.length < 3){
                    calendar.setMinute(Integer.parseInt(partTimes[0]));
                    calendar.setSecond(Integer.parseInt(partTimes[1]));
                } else {
                    calendar.setHour(Integer.parseInt(partTimes[0]));
                    calendar.setMinute(Integer.parseInt(partTimes[1]));
                    calendar.setSecond(Integer.parseInt(partTimes[2]));
                }
            } else {
                parsing(date, calendar);
            }
            calendarList.add(calendar);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex){
            System.out.println("Pls, enter right date!");
            create();
        }
    }
    private void parsing(String period, Calendar calendar){
        if(period.contains("/")){
            String[] partDates = period.split("/");
            for (int i = 0; i < partDates.length; i++) {
                if(partDates[i].isEmpty()){
                    partDates[i] = "1";
                }
            }
            calendar.setDay(Integer.parseInt(partDates[0]));
            calendar.setMonth(Integer.parseInt(partDates[1]));
            if(partDates.length < 3){
                calendar.setYear(2021);
            } else {
                calendar.setYear(Integer.parseInt(partDates[2]));
            }
        } else {
            calendar.setYear(Integer.parseInt(period));
        }
    }

}


