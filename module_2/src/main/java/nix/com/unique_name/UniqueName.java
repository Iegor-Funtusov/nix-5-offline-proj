package nix.com.unique_name;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueName {

    public List<String> readFromFile() {
        String uniqueName = "Nothing";
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
        return findUniqueName(names);
    }

    public static List<String> findUniqueName(List<String> names) {

        return names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
