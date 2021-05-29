package com.example.calendar;

import java.io.BufferedReader;
import java.io.IOException;

public class DateController {
    private final BufferedReader reader;

    public DateController(BufferedReader reader){
        this.reader = reader;
    }

    public void createDate() throws IOException {
        Date date = new Date();
        System.out.println("Enter Date: ");
        String read = reader.readLine();
        try{
            int spaceIndex = read.indexOf(" ");
            if(spaceIndex >= 4){
                String dateRead = read.substring(0, read.indexOf(" "));
                parseDate(dateRead, date);
                String timeRead = read.substring(read.indexOf(" ")+1);
                parseTime(timeRead, date);
            } else {
                parseDate(read, date);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex){
            System.out.println("Pls, enter right date!");
            createDate();
            return;
        }
        System.out.println(date);

    }

    private void parseDate(String dateRead, Date date){
        if(dateRead.contains("/")){
            String[] dateParts = dateRead.split("/");
            for (int i = 0; i < dateParts.length; i++) {
                if(dateParts[i].isEmpty()){
                    dateParts[i] = "1";
                }
            }
            date.setDay(Integer.parseInt(dateParts[0]));
            date.setMonth(Integer.parseInt(dateParts[1]));
            if(dateParts.length < 3){
                date.setYear(2021);
            } else {
                date.setYear(Integer.parseInt(dateParts[2]));
            }
        } else {
            date.setYear(Integer.parseInt(dateRead));
        }
    }

    private void parseTime(String read, Date date){
        String[] timeParts = read.split(":");
        if(timeParts.length < 3){
            date.setMinute(Integer.parseInt(timeParts[0]));
            date.setSecond(Integer.parseInt(timeParts[1]));
        } else {
            date.setHour(Integer.parseInt(timeParts[0]));
            date.setMinute(Integer.parseInt(timeParts[1]));
            date.setSecond(Integer.parseInt(timeParts[2]));
        }
    }
}
