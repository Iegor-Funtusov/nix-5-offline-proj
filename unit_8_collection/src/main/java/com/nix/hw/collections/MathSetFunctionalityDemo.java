package com.nix.hw.collections;

public class MathSetFunctionalityDemo {
    public static void start() {

        System.out.println("\nconstructors testing: ");

        MathSet ms1 = new MathSet();
        System.out.print("ms1: ");
        printMathSet(ms1);

        MathSet ms2 = new MathSet(20);
        System.out.print("ms2: ");
        printMathSet(ms2);

        MathSet ms3 = new MathSet(new Number[]{3, 6.0, 2, 4.7, 5});
        System.out.print("ms3: ");
        printMathSet(ms3);

        MathSet ms4 = new MathSet(new Number[]{3, 6.0, 2, 4.7, 5},
                                  new Number[]{5, 2, 7, 12});
        System.out.print("ms4: ");
        printMathSet(ms4);

        MathSet ms5 = new MathSet(ms3);
        System.out.print("ms5: ");
        printMathSet(ms5);

        MathSet ms6 = new MathSet(ms3, ms4, ms5);
        System.out.print("ms6: ");
        printMathSet(ms6);

        System.out.println("\nadd methods testing");

        ms2.add(5);
        System.out.print("add(Number n)    result: ");
        printMathSet(ms2);

        ms2.add(4, 7, 5, 8);
        System.out.print("add(Number... n) result: ");
        printMathSet(ms2);

        System.out.println("\njoin methods testing");

        ms1.join(ms3);
        System.out.print("join(MathSet ms)    result: ");
        printMathSet(ms1);

        ms3.join(ms2, ms4, ms5);
        System.out.print("join(MathSet... ms) result: ");
        printMathSet(ms3);

        System.out.println("\nsort methods testing");

        ms3.sortDesc();
        System.out.print("sortDesc result: ");
        printMathSet(ms3);

        ms3.sortAsc();
        System.out.print("sortAsc result: ");
        printMathSet(ms3);

        System.out.println("\nget methods testing");

        System.out.println("ms4[3]: " + ms4.get(3));
        System.out.println("ms4 max value: " + ms4.getMax());
        System.out.println("ms4 min value: " + ms4.getMin());
        System.out.println("ms4 average: " + ms4.getAverage());
        System.out.println("ms4 median: " + ms4.getMedian());

        System.out.println("\ntoArray methods testing");

        System.out.print("ms6: ");
        System.out.print(ms6 + ": [");
        for (Number number : ms6.toArray()) {
            System.out.print(number + " ");
        }
        System.out.print("]\n");

        System.out.print("ms6[1-5]: ");
        System.out.print(ms6 + ": [");
        for (Number number : ms6.toArray(1, 5)) {
            System.out.print(number + " ");
        }
        System.out.print("]\n");

        System.out.println("\nsquash method testing");

        System.out.print("ms4 squash 2-6: ");
        printMathSet(ms4.squash(2, 6));

        System.out.println("\ntesting clear methods");
        System.out.print("ms3 before clear(): ");
        printMathSet(ms3);
        System.out.print("ms3 after clear(): ");
        ms3.clear();
        printMathSet(ms3);
        System.out.print("ms6 before: ");
        printMathSet(ms6);
        System.out.print("ms6 after clear numbers 2, 5, 6: ");
        ms6.clear(new Number[]{2, 5, 6});
        printMathSet(ms6);

    }

    private static void printMathSet(MathSet mathSet) {
        System.out.print(mathSet + ": [");
        for (Number number : mathSet.toArray()) {
            System.out.print(number + " ");
        }
        System.out.print("]\n");
    }

}
