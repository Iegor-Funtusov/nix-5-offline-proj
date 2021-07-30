package org.example.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CSVWriter {

    private static final String DEFAULT_SEPARATOR = ",";
    private static String separator = DEFAULT_SEPARATOR;

    public static void setSeparator(String s) {
        separator = s;
    }

    public static void write(String[] headers, List<String[]> rows, String fileName) {
        if (!valid(headers, rows)) {
            throw new IllegalArgumentException();
        }
        try {
            Files.deleteIfExists(Path.of(fileName));
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(fileName));
            bufferedWriter.write(String.join(separator, headers));
            bufferedWriter.newLine();
            for (String[] row : rows) {
                bufferedWriter.write(String.join(separator, row));
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static boolean valid(String[] headers, List<String[]> rows) {
        if (headers == null || rows == null || headers.length == 0) {
            return false;
        }
        int length = headers.length;
        for (String[] row : rows) {
            if (row.length != length) {
                return false;
            }
        }
        return true;
    }
}
