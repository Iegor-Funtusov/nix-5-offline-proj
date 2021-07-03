package ua.practice.app.name;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class NameReader {
    private final BufferedReader bufferedReader;

    public NameReader() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\names.txt"));
    }

    public String findUniqueName() throws IOException {
        String s;
        HashMap<String, Integer> map = new LinkedHashMap<>();
        while ((s = bufferedReader.readLine()) != null) {
            map.compute(s, (k,v) -> v == null ? 1 : v + 1);
        }
        return map.entrySet()
                .stream()
                .filter(set -> set.getValue() == 1)
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getKey();
    }
}
