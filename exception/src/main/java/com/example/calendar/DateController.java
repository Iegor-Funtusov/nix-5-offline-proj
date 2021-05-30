package com.example.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DateController {
    private final BufferedReader reader;
    private List<DateTime> dateTimeList = new ArrayList<>();

    public DateController(BufferedReader reader){
        this.reader = reader;
    }

    public void createDate() throws IOException {
        DateTime dateTime = new DateTime();
        System.out.println("Enter Date: ");
        String read = reader.readLine();
        try{
            int spaceIndex = read.indexOf(" ");
            if(spaceIndex >= 4){
                String dateRead = read.substring(0, read.indexOf(" "));
                parseDate(dateRead, dateTime);
                String timeRead = read.substring(read.indexOf(" ")+1);
                parseTime(timeRead, dateTime);
            } else {
                parseDate(read, dateTime);
            }
            dateTimeList.add(dateTime);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex){
            System.out.println("Pls, enter right date!");
            createDate();
            return;
        }
        System.out.println(dateTime);
    }

    public void diffDate() throws IOException {
        if(dateTimeList.size() > 1){
            printDateTimeList();
            try{
                System.out.println("Enter index of first date: ");
                int firstDateIndex = Integer.parseInt(reader.readLine());
                System.out.println("Enter index of second date: ");
                int secondDateIndex = Integer.parseInt(reader.readLine());
                printDiffDate(dateTimeList.get(firstDateIndex), dateTimeList.get(secondDateIndex));
            } catch (IndexOutOfBoundsException ex){
                System.out.println("Pls, enter right Index!");
                diffDate();
            }
        } else {
            System.out.println("Firstly, create at least 2 Date from main menu");
        }
    }

    public void plusDate() throws IOException {
        if(dateTimeList.size() > 0){
            printDateTimeList();
            try {
                System.out.println("Enter index of date: ");
                int indexOfDate = Integer.parseInt(reader.readLine());
                DateTime dateTime = dateTimeList.get(indexOfDate);
                setActionOfPlus(dateTime);
            } catch (IndexOutOfBoundsException ex){
                System.out.println("Pls, enter right Index");
                plusDate();
            } catch (NumberFormatException ex){
                System.out.println("Pls, enter right Data!");
                plusDate();
            }

        } else {
            System.out.println("Firstly, create at least 1 Date from main menu");
        }
    }

    public void minusDate() throws IOException {
        if(dateTimeList.size() > 0){
            printDateTimeList();
            try {
                System.out.println("Enter index of date: ");
                int indexOfDate = Integer.parseInt(reader.readLine());
                DateTime dateTime = dateTimeList.get(indexOfDate);
                setActionOfMinus(dateTime);
            } catch (IndexOutOfBoundsException ex){
                System.out.println("Pls, enter right Index");
                minusDate();
            } catch (NumberFormatException ex){
                System.out.println("Pls, enter right Data!");
                minusDate();
            }

        } else {
            System.out.println("Firstly, create at least 1 Date from main menu");
        }
    }

    public void printCompareAsc(){
        Collections.sort(dateTimeList);
        System.out.println(dateTimeList);
    }

    public void printCompareDesc(){
        dateTimeList.sort(Collections.reverseOrder());
        System.out.println(dateTimeList);
    }

    private void parseDate(String dateRead, DateTime dateTime){
        if(dateRead.contains("/")){
            String[] dateParts = dateRead.split("/");
            for (int i = 0; i < dateParts.length; i++) {
                if(dateParts[i].isEmpty()){
                    dateParts[i] = "1";
                }
            }
            dateTime.setDay(Integer.parseInt(dateParts[0]));
            dateTime.setMonth(Integer.parseInt(dateParts[1]));
            if(dateParts.length < 3){
                dateTime.setYear(2021);
            } else {
                dateTime.setYear(Integer.parseInt(dateParts[2]));
            }
        } else {
            dateTime.setYear(Integer.parseInt(dateRead));
        }
    }

    private void parseTime(String timeRead, DateTime dateTime){
        String[] timeParts = timeRead.split(":");
        if(timeParts.length < 3){
            dateTime.setMinute(Integer.parseInt(timeParts[0]));
            dateTime.setSecond(Integer.parseInt(timeParts[1]));
        } else {
            dateTime.setHour(Integer.parseInt(timeParts[0]));
            dateTime.setMinute(Integer.parseInt(timeParts[1]));
            dateTime.setSecond(Integer.parseInt(timeParts[2]));
        }
    }

    private void printDateTimeList(){
        for (int i = 0; i < dateTimeList.size(); i++) {
            System.out.println("["+ i +"] : " + dateTimeList.get(i));
        }
    }

    private void printDiffDate(DateTime firstDate, DateTime secondDate){
        System.out.println("Difference in Years " + firstDate.diffDateInYear(secondDate));
        System.out.println("Difference in Months " + firstDate.diffDateInMonth(secondDate));
        System.out.println("Difference in Days " + firstDate.diffDateInDay(secondDate));
        System.out.println("Difference in Hours " + firstDate.diffDateInHour(secondDate));
        System.out.println("Difference in Minutes " + firstDate.diffDateInMinute(secondDate));
        System.out.println("Difference in Seconds " + firstDate.diffDateInSecond(secondDate));
    }

    private void setActionOfPlus(DateTime dateTime) throws IOException {
        System.out.println("Enter operation: " +"\n 1 - plus Years" +"\n 2 - plus Month"
                + "\n 3 - plus Days" + "\n 4 - plus Hours" + "\n 5 - plus Minutes" + "\n 6 - plus Seconds"
                + "\n 7 - back to menu" + "\n 0 - exit");
        switch (reader.readLine()){
            case "1":
                System.out.println("Enter num of years: ");
                dateTime.plusYear(Integer.parseInt(reader.readLine()));
                break;
            case "2":
                System.out.println("Enter num of months: ");
                dateTime.plusMonth(Integer.parseInt(reader.readLine()));
                break;
            case "3":
                System.out.println("Enter num of days: ");
                dateTime.plusDay(Integer.parseInt(reader.readLine()));
                break;
            case "4":
                System.out.println("Enter num of hours: ");
                dateTime.plusHour(Integer.parseInt(reader.readLine()));
                break;
            case "5":
                System.out.println("Enter num of minutes: ");
                dateTime.plusMinute(Integer.parseInt(reader.readLine()));
                break;
            case "6":
                System.out.println("Enter num of seconds: ");
                dateTime.plusSecond(Integer.parseInt(reader.readLine()));
                break;
            case "7": break;
            case "0": System.exit(0);
            default:
                System.out.println("Fail, enter right operation ");
        }
        System.out.println(dateTime);
    }

    private void setActionOfMinus(DateTime dateTime) throws IOException {
        System.out.println("Enter operation: " +"\n 1 - minus Years" +"\n 2 - minus Month"
                + "\n 3 - minus Days" + "\n 4 - minus Hours" + "\n 5 - minus Minutes" + "\n 6 - minus Seconds"
                + "\n 7 - back to menu" + "\n 0 - exit");
        switch (reader.readLine()){
            case "1":
                System.out.println("Enter num of years: ");
                dateTime.minusYear(Integer.parseInt(reader.readLine()));
                break;
            case "2":
                System.out.println("Enter num of months: ");
                dateTime.minusMonth(Integer.parseInt(reader.readLine()));
                break;
            case "3":
                System.out.println("Enter num of days: ");
                dateTime.minusDay(Integer.parseInt(reader.readLine()));
                break;
            case "4":
                System.out.println("Enter num of hours: ");
                dateTime.minusHour(Integer.parseInt(reader.readLine()));
                break;
            case "5":
                System.out.println("Enter num of minutes: ");
                dateTime.minusMinute(Integer.parseInt(reader.readLine()));
                break;
            case "6":
                System.out.println("Enter num of seconds: ");
                dateTime.minusSecond(Integer.parseInt(reader.readLine()));
                break;
            case "7": break;
            case "0": System.exit(0);
            default:
                System.out.println("Fail, enter right operation ");
        }
        System.out.println(dateTime);
    }

}
