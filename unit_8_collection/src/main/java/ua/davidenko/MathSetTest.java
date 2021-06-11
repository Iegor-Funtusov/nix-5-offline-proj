package ua.davidenko;

public class MathSetTest {

    MathSet<Number> numberSet = new MathSet<>();
    Number[] numbers1 = {10, 11, 2, 20, 1, 100};
    MathSet<Number> numberSet1 = new MathSet<>(numbers1);
    MathSet<Number> numberSet2 = new MathSet<>();

    public void test() {
        System.out.println("First numberSet:");
        numberSet1.print();
        System.out.println("Second numberSet:");
        numberSet2.add(10, 45, 55, 25, -100, 1, 2);
        numberSet2.print();
        System.out.println("Sort by Asc first:");
        numberSet1.sortAsc();
        numberSet1.print();
        System.out.println("Sort by Desc first:");
        numberSet1.sortDesc();
        numberSet1.print();
        System.out.println("Sort Asc from index to index:");
        numberSet1.sortAsc(0, 4);
        numberSet1.print();
        System.out.println("Sort Asc from value:");
        numberSet1.sortAsc(11);
        numberSet1.print();
        System.out.println("Sort Desc from index to index");
        numberSet2.sortDesc(0, 4);
        numberSet2.print();
        System.out.println("Sort Desc from value");
        numberSet2.sortDesc(55);
        numberSet2.print();
        System.out.println("Joining  all sets to the Third set:");
        numberSet.join(numberSet1, numberSet2);
        numberSet.print();
        System.out.println("Max value is:  " + numberSet.getMax());
        System.out.println("Min value is: " + numberSet.getMin());
        System.out.println("Average is: " + numberSet.getAverage());
        System.out.println("Median is: " + numberSet.getMedian());
        System.out.println("Clear by value");
        Number[] clearNum = {100, 10};
        numberSet1.clear(clearNum);
        numberSet1.print();
        System.out.println("Clear Set:");
        numberSet.clear();
        numberSet.print();
    }
}






