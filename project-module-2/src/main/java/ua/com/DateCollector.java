package ua.com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateCollector {
    private static final String REGEX_DD_MM_YYYY = "(0[1-9]|1[0-9]|2[0-9]|3[0-1])\\/(0[1-9]|1[0-2])\\/(\\d{4})";
    private static final String REGEX_MM_DD_YYYY = "(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])-(\\d{4})";
    private static final String REGEX_YYYY_MM_DD = "(\\d{4})\\/(0[1-9]|1[0-2])\\/(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
    private static final String LOGIC_DD_MM_YYYY = "67893401";
    private static final String LOGIC_MM_DD_YYYY = "67890134";
    private static final String LOGIC_YYYY_MM_DD = "01235689";

    public String run(String input) {
        return cycle(input);
    }

    private String cycle(String input) {
        StringBuilder sb = new StringBuilder("Dates: ");
        convert(collect(REGEX_DD_MM_YYYY, input), sb, LOGIC_DD_MM_YYYY);
        convert(collect(REGEX_MM_DD_YYYY, input), sb, LOGIC_MM_DD_YYYY);
        convert(collect(REGEX_YYYY_MM_DD, input), sb, LOGIC_YYYY_MM_DD);
        if (sb.length() == 7) {
            sb = new StringBuilder("Valid dates did not find.  ");
        }
        return String.valueOf(sb.substring(0, sb.length() - 2));
    }

    private String[] collect(String regex, String input) {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while (m.find()) {
            sb.append(m.group()).append(",");
        }
        return String.valueOf(sb).split(",");
    }

    private void convert(String[] array, StringBuilder sb, String logic) {
        char[] logicArray = logic.toCharArray();
        for (String s : array) {
            if (!s.isEmpty()) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < 8; i++) {
                    sb.append(chars[Integer.parseInt(String.valueOf(logicArray[i]))]);
                }
                sb.append(", ");
            }
        }
    }
}
