package com.example.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalendarUI {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final DateController dateController;

    public CalendarUI(){
        dateController = new DateController(reader);
    }

    public void exec(){
        try {
            String helpStr = "Set an action: " +"\n 1 - create Date" +"\n 2 - difference Date"
                    + "\n 3 - plus to Date" + "\n 4 - minus to Date" + "\n 5 - get user by Id" + "\n 0 - exit";
            System.out.println(helpStr);
            String read;
            while ((read = reader.readLine()) != null){
                setAction(read);
                System.out.println("Continue... You can select another action");
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setAction(String read) throws IOException {
        switch (read){
            case "1": dateController.createDate();
                break;
            case "2" : dateController.diffDate();
                break;
            case "3" : dateController.plusDate();
                break;
            case "4" : dateController.minusDate();
                break;
            case "0" : System.exit(0);
            default:
                System.out.println("Fail, enter right operation ");
        }
    }
}
