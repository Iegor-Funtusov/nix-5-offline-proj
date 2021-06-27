package ua.com.nix.date;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ActionWithDates {

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader("module_2/src/main/resources/dates.txt"))) {
            String strDate = reader.readLine();
            String[] dates = new String[6];
            int index = 0;
            while (strDate!=null)
            {
                dates[index] = strDate;
                index++;
                strDate = reader.readLine();
            }
            System.out.println("All dates that were input: " + Arrays.toString(dates));
            System.out.println("And after checks: ");
            SimpleDateFormat[] dateFormats = {new SimpleDateFormat("yyyy/MM/dd"), new SimpleDateFormat("dd/MM/yyyy"), new SimpleDateFormat("MM-dd-yyyy")};

            for (String date : dates) {
                int k = 0;
                DateFormatLabel:
                while (true) {
                    while (k < dateFormats.length) {
                        {
                            try {
                                dateFormats[k].setLenient(false);
                                dateFormats[k].parse(date);
                                break DateFormatLabel;
                            } catch (ParseException e) {
                                k++;
                            }
                        }
                        if (k == 3) {
                            break DateFormatLabel;
                        }
                    }
                }
                if (k == 3) {
                    continue;
                }
                if (date.contains("/")) {
                    String[] dateArray = date.split("[/]");
                    System.out.print(date + " = ");
                    if (Integer.parseInt(dateArray[2]) < 32) {
                        for (int i = 0; i < dateArray.length; i++) {
                            System.out.print(dateArray[i]);
                        }
                    } else {
                        for (int i = dateArray.length - 1; i >= 0; i--) {
                            System.out.print(dateArray[i]);
                        }
                    }
                    System.out.println();
                } else {
                    String[] dateArray = date.split("[-]");
                    String temp;
                    temp = dateArray[0];
                    dateArray[0] = dateArray[1];
                    dateArray[1] = temp;
                    System.out.print(date + " = ");
                    for (int i = dateArray.length - 1; i >= 0; i--) {
                        System.out.print(dateArray[i]);
                    }
                    System.out.println();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


