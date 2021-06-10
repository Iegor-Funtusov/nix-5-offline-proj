package ua.com.nix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateCreate {
    public  void dateCreate() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date();
        date.setDay(5);
        date.setHour(22);
        date.setMinutes(33);
        date.setYear(1900);
        date.setMonth(3);
        date.setSeconds(33);

        String data = reader.readLine();
        int spaceIndex = data.indexOf(" ");
        if (spaceIndex >= 2) {
            String period = data.substring(0, data.indexOf(" "));
            String duration = data.substring(data.indexOf(" ")+1);
            int a = 10;
            System.out.println(period + " ZHOPA " + duration );
        }
    }
}
