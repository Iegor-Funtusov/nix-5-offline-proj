package ua.com.alevel.name;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueName {
    public static void firstUniqueName() {
        File file = new File("names.txt");
        List<String> arrayList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line!= null){
                arrayList.add(line);
                line = reader.readLine();
            }
            String[] arr = arrayList.toArray(new String[0]);
            Map<String, Long> stringCountMap = Arrays.stream(arr)
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
            for (String s : arr) {
                if (stringCountMap.get(s) == 1) {
                    System.out.println("The first non-duplicate name: " + s+"\n");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}