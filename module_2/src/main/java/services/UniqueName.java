package services;

import java.util.HashMap;
import java.util.List;

public class UniqueName {
    public String uniqueName(List<String> names) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String name : names) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }
        for (String name : names)
            if (map.get(name) == 1)
                return name;
        String s = "There are no unique names";
        return s;
    }
}
