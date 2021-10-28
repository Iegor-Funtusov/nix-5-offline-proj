package org.example.module2;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueFinder {
    public String find(String[] inputArray) {
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (String s : inputArray) {
            counts.compute(s, (k, v) -> (v == null) ? 1 : v + 1);
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}
