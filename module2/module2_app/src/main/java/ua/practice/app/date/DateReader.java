package ua.practice.app.date;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateReader {
    private final BufferedReader bufferedReader;

    public DateReader() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\dates.txt"));
    }

    public List<String> read() throws IOException {
        String s;
        String result;
        SimpleDateFormat simpleDateFormat;
        Date date;
        ArrayList<String> list = new ArrayList<>();
        while ((s = bufferedReader.readLine()) != null) {
            try {
                simpleDateFormat = new SimpleDateFormat(getFormat(s));
                date = simpleDateFormat.parse(s);
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                result = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                list.add(result);
            } catch (IllegalArgumentException | ParseException ignored) {
            }
        }
        return list;
    }

    private String getFormat(String inputLine) throws IllegalArgumentException {
        for (Formats format : Formats.values()) {
            if (format.isMatches(inputLine)) {
                return format.getReturnFormat();
            }
        }
        throw new IllegalArgumentException();
    }
}
