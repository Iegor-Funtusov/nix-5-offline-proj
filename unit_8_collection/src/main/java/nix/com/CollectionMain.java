package nix.com;

import nix.com.math_set.MathSet;

import java.util.Arrays;

public class CollectionMain {
    public static void main(String[] args) {
        MathSet<Integer> mathSet1 = new MathSet<>();

        Integer[] array = new Integer[20];
        for (int i = 0; i < 20; i++) {
            mathSet1.add(i);
            array[i] = i + 10;
        }

        MathSet<Integer> mathSet2 = new MathSet<>(array);
        MathSet<Integer> mathSet3 = new MathSet<>(mathSet1,mathSet2);

        System.out.println("mathSet3 = " + Arrays.toString(mathSet3.toArray()));
        System.out.println("mathSet2 = " + Arrays.toString(mathSet2.toArray()));
        System.out.println("mathSet1 = " + Arrays.toString(mathSet1.toArray()));

        mathSet1.join(mathSet1, mathSet2);

        System.out.println("Join:" + Arrays.toString(mathSet1.toArray()));

        mathSet1.sortDesc();

        System.out.println("Sort: " + Arrays.toString(mathSet1.toArray()));

        System.out.println("display:" + Arrays.toString(mathSet1.toArray()));

        System.out.println("max " + mathSet1.getMax());
        System.out.println("id " + mathSet1.get(5));
        System.out.println("min " + mathSet1.getMin());
        System.out.println("av " + mathSet1.getAverage());
        System.out.println("mid " + mathSet1.getMedian());
        System.out.println("to arr id " + Arrays.toString(mathSet1.toArray(1, 5)));

        mathSet1.clear();
        System.out.println("mathSet3 = " + Arrays.toString(mathSet1.toArray()));

    }
}
