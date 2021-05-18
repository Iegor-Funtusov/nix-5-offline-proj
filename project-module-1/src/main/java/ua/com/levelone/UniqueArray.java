package ua.com.levelone;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class UniqueArray {

    private int[] array;

    public UniqueArray() {
        this.array = new int[random() + 10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
        }
    }

    public UniqueArray(int[] array) {
        this.array = array;
    }

    public static int uniqueCount(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int x : array) {
            if (!list.contains(x))
                list.add(x);
        }
        return list.size();
    }

    private static int random() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(10);
    }

    public int[] getArray() {
        return array;
    }
}
