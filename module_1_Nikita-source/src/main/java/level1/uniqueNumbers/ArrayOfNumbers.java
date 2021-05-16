package level1.uniqueNumbers;

import java.util.HashSet;
import java.util.Set;

public class ArrayOfNumbers {

    public static int uniqueNumbers(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int x : array) {
            set.add(x);
        }
        return set.size();
    }
}
