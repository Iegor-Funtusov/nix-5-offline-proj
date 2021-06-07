package nix.com;

import nix.com.math_set.MathSet;

import java.util.Arrays;

public class CollectionMain {
    public static void main(String[] args) {
        MathSet<Integer> mathSet = new MathSet<>();

        for (int i = 0; i < 20; i++) {
            mathSet.add(i);
        }

        mathSet.join(mathSet);

        System.out.println("Join:" + Arrays.toString(mathSet.readAll()));

        mathSet.sortAsc();

        System.out.println("Sort: " + Arrays.toString(mathSet.readAll()));
    }
}
