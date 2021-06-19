import java.util.Arrays;

public class MathSetController {
    private static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------";
    MathSet<Number> mathSet = new MathSet<>();
    Number[] numbers1 = {1, 2, 3, 4, 5, 6};
    Number[] numbers2 = {11, 12, 13, 15, 14};
    MathSet<Number> numberSet1 = new MathSet<>(numbers1);
    MathSet<Number> numberSet2 = new MathSet<>(numbers2);

    public void run() {
        System.out.println(SEPARATOR);
        System.out.println("First Array:");
        System.out.println(Arrays.toString(numberSet1.toArray()));
        System.out.println(SEPARATOR);
        System.out.println("Second Array:");
        System.out.println(Arrays.toString(numberSet2.toArray()));
        System.out.println(SEPARATOR);

        System.out.println("Add value to first Array :");
        numberSet1.add(20);
        System.out.println(Arrays.toString(numberSet1.toArray()));
        System.out.println(SEPARATOR);

        System.out.println("Operation Join:");
        mathSet.join(numberSet1, numberSet2);
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(SEPARATOR);

        System.out.println("Sort Desc:");
        mathSet.sortDesc();
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(SEPARATOR);
        System.out.println("Sort Asc:");
        mathSet.sortAsc();
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(SEPARATOR);

        System.out.println("Sort Desc from index(0) to index(2)");
        mathSet.sortDesc(0, 3);
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(SEPARATOR);
        System.out.println("Sort Asc from index(0) to index(1)");
        mathSet.sortAsc(0, 2);
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(SEPARATOR);

        System.out.println("Sort Desc from value(6):");
        mathSet.sortDesc(6);
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(SEPARATOR);
        System.out.println("Sort Asc from value(3):");
        mathSet.sortDesc(3);
        System.out.println(Arrays.toString(mathSet.toArray()));
        System.out.println(SEPARATOR);

        System.out.print("Get number by index(1): ");
        System.out.println(mathSet.get(1));
        System.out.println(SEPARATOR);
        System.out.println("Max value: " + mathSet.getMax());
        System.out.println(SEPARATOR);
        System.out.println("Min value: " + mathSet.getMin());
        System.out.println(SEPARATOR);
        System.out.println("Average: " + mathSet.getAverage());
        System.out.println(SEPARATOR);
        System.out.println("Median: " + mathSet.getMedian());
        System.out.println(SEPARATOR);

        int[] range = new int[]{1, 5};
        System.out.println("Array from index (1) to index (4):\n" + Arrays.toString(mathSet.toArray(range[0], range[1])));
        System.out.println(SEPARATOR);
        System.out.println("Array:\n" + Arrays.toString(mathSet.toArray()));
        System.out.println(SEPARATOR);

        int[] range1 = new int[]{2, 6};
        System.out.println("Squash array from index (2) to index (5):\n" + Arrays.toString(mathSet.squash(range1[0], range1[1]).toArray()));
        System.out.println(SEPARATOR);

        Number[] numbers = {3, 6, 14};
        mathSet.clear(numbers);
        System.out.println("Clear array values(3, 6, 14):\n" + Arrays.toString(mathSet.toArray()));
        System.out.println(SEPARATOR);
        mathSet.clear();
        System.out.println("Clear array:\n" + Arrays.toString(mathSet.toArray()));
        System.out.println(SEPARATOR);
    }
}
