package ua.com.nix.UniqNames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Uniq {

    public  void run() {
        List<String> list = new ArrayList<>(Arrays.asList("Антон", "Женя", "Влад", "Женя", "Антон", "Вася","Влад","Олег"));
        System.out.println("All names that were input: " + list);
        boolean unique = true;
        for (int i = 0; i < list.size(); i++) {
            unique = true;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).equals(list.get(i))) {
                    list.set(j,list.get(list.size()-1));
                    unique = false;
                    break;
                }
            }
            if (unique) {
                System.out.println("Uniq symbol in this list: " + list.get(i));
                break;
            }
        }
        if(!unique)
        {
            System.out.println("Not a single unique name");
        }
    }
}

