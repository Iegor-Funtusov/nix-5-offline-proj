package com.lapchenko.module.second.unique_name_finder;
import java.util.LinkedHashMap;

public class UniqueNameFinder {
    private LinkedHashMap<String, Integer> names = new LinkedHashMap<>();

    public String findFirstUniqueName() {
        for (var nameCountPair :
                names.entrySet()) {
            if(nameCountPair.getValue() == 1) {
                return nameCountPair.getKey();
            }
        }
        throw new RuntimeException("There is no unique names");
    }

    public void addName(String name) {
        if(names.containsKey(name)) {
            names.put(name, names.get(name) + 1);
        }else{
            names.put(name, 1);
        }
    }

    public void clear() {
        names.clear();
    }
}
