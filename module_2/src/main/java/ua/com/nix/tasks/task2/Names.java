package ua.com.nix.tasks.task2;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Names {
    @SneakyThrows
    public String runSearchUniqueName() {
        File file = new File("module_2/src/main/resources/names.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> names = new ArrayList<>();
        String name = bufferedReader.readLine();
        while (name != null) {
            names.add(name);
            name = bufferedReader.readLine();
        }
        return searchUniqueName(names);
    }

    public static String searchUniqueName(List<String> names) {
        HashMap<String , Integer> map = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            if (map.containsKey(names.get(i))) {
                map.put(names.get(i), map.get(names.get(i)) + 1);
            }
            else { map.put(names.get(i), 1); }
        }
        for (int i = 0; i < names.size(); i++)
            if (map.get(names.get(i)) == 1) {
                return names.get(i);
            }
        return "No unique names!";
    }
}
