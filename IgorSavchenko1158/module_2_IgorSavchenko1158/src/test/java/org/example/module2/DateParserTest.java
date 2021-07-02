package org.example.module2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    @Test
    void convertTest() {
        DateParser parser = new DateParser();
        String string = "1997/12/30\n" +
                "22/07/2020\n" +
                "09-06-1111\n" +
                "wrong format";
        String[] dates = string.split("\\s+");
        String[] output = parser.convert(dates);

        assertArrayEquals(new String[]{
                "19971230", "20200722", "11110906"
        }, output);
    }
}