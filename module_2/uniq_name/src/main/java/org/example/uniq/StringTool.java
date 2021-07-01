package org.example.uniq;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringTool {

    public static String uniqueString(List<String> strings){
        Map<String, Integer> countOccurrences = new LinkedHashMap<>();
        for(String s : strings){
            if(countOccurrences.containsKey(s)){
                countOccurrences.put(s, countOccurrences.get(s) + 1);
            } else {
                countOccurrences.put(s, 1);
            }
        }

        for(String s : countOccurrences.keySet()){
            if(countOccurrences.get(s) == 1){
                return s;
            }
        }
        return null;
    }
}
