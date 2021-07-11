package com.nix.module_2.dates;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class DateFormatUtil {

    public static int[] parseDate(String inputDateString) {
        char separator;
        int[] dateParametersInt = new int[3];
        String[] dateParametersStr = new String[3];

        if (inputDateString.contains("/"))
            separator = '/';
        else if (inputDateString.contains("-"))
            separator = '-';
        else
            throw new DateException();

        if (StringUtils.countMatches(inputDateString, separator) == 2) {
            dateParametersStr = inputDateString.split(String.valueOf(separator));
            Arrays.stream(dateParametersStr)
                    .forEach(i -> {
                        if (!StringUtils.isNumeric(i))
                            throw new DateException();
                    });
        }

        boolean isDateFormat1;
        boolean isDateFormat2;
        boolean isDateFormat3;

        try {
            isDateFormat1 = dateParametersStr[0].length() == 4 &&
                    (dateParametersStr[1].length() == 2 || dateParametersStr[1].length() == 1) &&
                    (dateParametersStr[2].length() == 2 || dateParametersStr[2].length() == 1);

            isDateFormat2 = (dateParametersStr[0].length() == 2 || dateParametersStr[0].length() == 1) &&
                    (dateParametersStr[1].length() == 2 || dateParametersStr[1].length() == 1) &&
                    dateParametersStr[2].length() == 4 &&
                    separator == '/';

            isDateFormat3 = (dateParametersStr[0].length() == 2 || dateParametersStr[0].length() == 1) &&
                    (dateParametersStr[1].length() == 2 || dateParametersStr[1].length() == 1) &&
                    dateParametersStr[2].length() == 4 &&
                    separator == '-';
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DateException();
        }


        if (isDateFormat1) {
            dateParametersInt[0] = Integer.parseInt(dateParametersStr[0]);
            dateParametersInt[1] = Integer.parseInt(dateParametersStr[1]);
            dateParametersInt[2] = Integer.parseInt(dateParametersStr[2]);
        } else if (isDateFormat2) {
            dateParametersInt[0] = Integer.parseInt(dateParametersStr[2]);
            dateParametersInt[1] = Integer.parseInt(dateParametersStr[1]);
            dateParametersInt[2] = Integer.parseInt(dateParametersStr[0]);
        } else if (isDateFormat3){
            dateParametersInt[0] = Integer.parseInt(dateParametersStr[2]);
            dateParametersInt[1] = Integer.parseInt(dateParametersStr[0]);
            dateParametersInt[2] = Integer.parseInt(dateParametersStr[1]);
        } else
            throw new DateException();

        return dateParametersInt;
    }
}
