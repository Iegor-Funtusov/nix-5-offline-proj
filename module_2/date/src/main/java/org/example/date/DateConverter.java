package org.example.date;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DateConverter {
    private final List<String> dates;

    public DateConverter(List<String> dates){
        this.dates = dates;
    }

    public List<String> convert(){
        List<String> outDates = new ArrayList<>();
        String regexp1 = "\\d{4}/(0[1-9]|1[0-2])/(0[1-9]|1\\d|2\\d|3[01])$";
        String regexp2 = "(0[1-9]|1\\d|2\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        String regexp3 = "(0[1-9]|1[0-2])-(0[1-9]|1\\d|2\\d|3[01])-\\d{4}$";
        for(String inputDate : dates){
            if(Pattern.matches(regexp1, inputDate)){
                String[] s = inputDate.split("/");
                outDates.add(s[0]+s[1]+s[2]);
            } else if(Pattern.matches(regexp2, inputDate)){
                String[] s = inputDate.split("/");
                outDates.add(s[2]+s[1]+s[0]);
            } else if(Pattern.matches(regexp3, inputDate)){
                String[] s = inputDate.split("-");
                outDates.add(s[2]+s[0]+s[1]);
            }

        }
        return outDates;
    }
}
