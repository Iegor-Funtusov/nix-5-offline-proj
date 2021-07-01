package org.example.uniq;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Oleg");
        names.add("Oleg");
        names.add("Aleksandr");
        names.add("Ivan");
        names.add("Maksim");
        names.add("Ivan");
        names.add("Oksana");
        names.add("Aleksandr");

        String firstUniqName = StringTool.uniqueString(names);
        System.out.println("firstUniqName = " + firstUniqName);
    }
}
