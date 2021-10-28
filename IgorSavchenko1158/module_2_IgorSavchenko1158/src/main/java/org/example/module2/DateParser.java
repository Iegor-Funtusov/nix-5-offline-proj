package org.example.module2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {
    public String[] convert(String[] dates) {
        List<String> results = new ArrayList<>();

        List<String> regexs = List.of(
                "(?<day>\\d{2})/(?<month>\\d{2})/(?<year>\\d{4})",
                "(?<year>\\d{4})/(?<month>\\d{2})/(?<day>\\d{2})",
                "(?<month>\\d{2})-(?<day>\\d{2})-(?<year>\\d{4})");

        for (String date : dates) {
            for (String regex : regexs) {
                Matcher matcher = Pattern.compile(regex).matcher(date);
                if (matcher.matches()) {
                    results.add(assemble(matcher.group("year"), matcher.group("month"), matcher.group("day")));
                    break;
                }
            }
        }

        return results.toArray(new String[0]);
    }

    private String assemble(String year, String month, String day) {
        return year + month + day;
    }
}
