package org.example.level1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayUtil {
    private ArrayUtil() {
    }

    public static long getNumberOfUniqueElements(int... array) {
        return IntStream.of(array).boxed().collect(Collectors.toSet()).size();
    }
}
