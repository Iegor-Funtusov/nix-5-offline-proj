package org.example.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser {
    private static final String DEFAULT_SEPARATOR = ",";
    private final String separator;
    private final List<String[]> lines = new ArrayList<>();
    private String[] headers;

    public CsvParser(String fileName) throws IOException {
        this(fileName, DEFAULT_SEPARATOR);
    }

    public CsvParser(String fileName, String separator) throws IOException {
        this.separator = separator;
        init(fileName);
    }

    private void init(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        if ((line = reader.readLine()) != null) {
            headers = line.split(separator);
        } else {
            throw new IOException("No valid header");
        }
        while ((line = reader.readLine()) != null) {
            String[] columns = line.split(separator);
            if (columns.length != headers.length) {
                throw new IOException("Csv line does not conform to the header");
            }
            lines.add(columns);
        }
    }

    public String get(int row, int column) {
        if (outOfBounds(row, column)) {
            throw new IndexOutOfBoundsException();
        }
        return lines.get(row)[column];
    }

    public String get(int row, String columnName) {
        int column = -1;
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals(columnName)) {
                column = i;
                break;
            }
        }
        if (column == -1) {
            throw new IllegalArgumentException("No such column");
        }
        return get(row, column);
    }

    public List<String> getHeaders() {
        return List.of(headers);
    }

    public int size() {
        return lines.size();
    }

    private boolean outOfBounds(int row, int column) {
        return row < 0 || row >= lines.size() || column < 0 || column >= headers.length;
    }
}
