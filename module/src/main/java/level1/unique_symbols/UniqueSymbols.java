package level1.unique_symbols;

import java.util.HashSet;
import java.util.Set;

public class UniqueSymbols {
    public static int countUnique(int[] arr) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int x : arr) {
            uniqueSet.add(x);
        }
        return uniqueSet.size();
    }
}















