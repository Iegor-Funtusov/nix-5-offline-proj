package ua.practice.app.date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Formats {
    YYYY_MM_DD("([12]\\d{3}\\/(0[1-9]|1[0-2])\\/(0[1-9]|[12]\\d|3[01]))", "yyyy/MM/dd"),
    DD_MM_YYYY("((0[1-9]|[12]\\d|3[01])\\/(0[1-9]|1[0-2])\\/[12]\\d{3})", "dd/MM/yyyy"),
    MM_DD_YYY("((0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])-[12]\\d{3})", "MM-dd-yyyy");
    private final String format;
    private final String returnFormat;
    private final Pattern pattern;

    Formats(String format, String returnFormat) {
        this.format = format;
        this.returnFormat = returnFormat;
        this.pattern = Pattern.compile(format);
    }

    public String getFormat() {
        return format;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public String getReturnFormat() {
        return returnFormat;
    }

    public boolean isMatches(String inputLine){
        Matcher matcher = pattern.matcher(inputLine);
        return matcher.matches();
    }

}
