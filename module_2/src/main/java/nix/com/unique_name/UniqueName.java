package nix.com.unique_name;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueName {

    public List<String> readFromFile(int mode) {
        File file = new File("names.txt");
        List<String> names = new ArrayList<>();

        try (FileReader fr = new FileReader(file);
             BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            while (line != null) {
                names.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Wrong input");
        }
        if (mode == 1) {
            return findUniqueNameWithStream(names);
        } else {
            return findUniqueWithFor(names);
        }
    }

    public static List<String> findUniqueNameWithStream(List<String> names) {

        return names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> findUniqueWithFor(List<String> names) {
        HashMap<Integer, String> hashValues = new HashMap<>();
        List<String> unique = new ArrayList<>();

        for (String name : names) {
            if (!hashValues.containsKey(name.hashCode())) {
                hashValues.put(name.hashCode(), name);
            } else {
                hashValues.put(name.hashCode(), "null");
            }
        }

        for (Map.Entry<Integer, String> entry : hashValues.entrySet()) {
            if (!entry.getValue().equals("null")) {
                unique.add(entry.getValue());
            }
        }
        return unique;
    }
}
