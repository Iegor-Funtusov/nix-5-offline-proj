package ua.com.alevel;

import java.util.HashSet;
import java.util.Set;

public class UniqueSymbols {

    public static int countUnique(int[] arr) {
        Set<Integer> mySet = new HashSet<>();
        for (int x : arr) {
            mySet.add(x);
        }
        return mySet.size();
    }
}
