package level1;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueNumbersCounter {
    public static int count(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return (new HashSet<>(list)).size();
    }

    public static int count(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        return (new HashSet<>(list)).size();
    }

    public static int count(List<Integer> list) {
        return (new HashSet<>(list)).size();
    }

}
