package org.example.level1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayUtil {
    public static long getNumberOfUniqueElements(int... array) {
        return IntStream.of(array).boxed().collect(Collectors.toSet()).size();


//        List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toList());
//        return Arrays.stream(array)
//                .filter(i -> Collections.frequency(list, i) == 1)
//                .count();
    }
}
