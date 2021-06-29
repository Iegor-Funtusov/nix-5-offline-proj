package org.example.module2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    @Test
    void convertTest() {
        DateParser parser = new DateParser();
        String string = "2020/04/05\n" +
                "05/04/2020\n" +
                "04-05-2020\n" +
                "cum socks";
        String[] dates = string.split("\\s+");
        String[] output = parser.convert(dates);

        assertArrayEquals(new String[] {
                "20200405", "20200405", "20200405"
        }, output);
    }
}