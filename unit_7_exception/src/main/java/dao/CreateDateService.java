package dao;

import lombok.SneakyThrows;
import service.CalendarService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CreateDateService {
    private static final String EXCEPTION = "You entered the wrong date format!";
    private static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------";

    CalendarService calendarService = new CalendarService();
    public static List<CalendarService> calendarList = new ArrayList<>();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    public void create() {
        String date = bufferedReader.readLine();
        try{
            int spaceIndex = date.indexOf(" ");
            if(spaceIndex >= 3){
                String period = date.substring(0, date.indexOf(" "));
                parsE(period, calendarService);
                String duration = date.substring(date.indexOf(" ")+1);
                String[] partTimes = duration.split(":");
                if(partTimes.length < 3){
                    calendarService.setMinute(Integer.parseInt(partTimes[0]));
                    calendarService.setSecond(Integer.parseInt(partTimes[1]));
                } else {
                    calendarService.setHour(Integer.parseInt(partTimes[0]));
                    calendarService.setMinute(Integer.parseInt(partTimes[1]));
                    calendarService.setSecond(Integer.parseInt(partTimes[2]));
                }
            } else {
                parsE(date, calendarService);
            }
            calendarList.add(calendarService);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException exception){
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
            create();
        }
    }
    private void parsE(String period, CalendarService calendar){
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


