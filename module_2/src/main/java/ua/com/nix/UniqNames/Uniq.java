package ua.com.nix.UniqNames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Uniq {

    public  void run() {
        List<String> list = new ArrayList<>(Arrays.asList("Антон", "Женя", "Влад", "Женя", "Олег", "Женя","Влад","Антон"));
        System.out.println("All names that were input: " + list);
        String unique = "Not a single unique name";
        for (int i = 0; i < list.size(); i++) {
            if(i==list.indexOf(list.get(i))&&i==list.lastIndexOf(list.get(i)))
            {
                unique="Uniq symbol in this list: " + list.get(i);
                break;
            }
        }
        System.out.println(unique);
    }
}

