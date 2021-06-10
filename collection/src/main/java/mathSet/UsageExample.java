package mathSet;

public class UsageExample {
    MathSet<Integer> firstSet = new MathSet<>();
    MathSet<Integer> secondSet = new MathSet<>(10);

    Number [] numbers1 = new Number[]{100,101,102,103,104};
    MathSet<Integer> thirdSet = new MathSet<>(numbers1);
    public void run(){

        for (int i = 0; i < 5; i++) {
        firstSet.add(i);
    }
        printFirstSet();

        for (int i = 0; i < 5; i++) {
        secondSet.add(i + 10);
    }
        printSecondSet();
        printThirdSet();

        firstSet.join(secondSet,thirdSet);
        System.out.println("Joining Second and Third set to First:  ");
        for (int i = 0; i < firstSet.getSize(); i++) {
        System.out.print(firstSet.get(i) + " ");
    }
        System.out.println();
        System.out.println("Maximum in FirstSet: " + firstSet.getMax());
        System.out.println("Minimum in FirstSet: " + firstSet.getMin());
        System.out.println("Avarage in FirstSet: " + firstSet.getAverage());

        System.out.println("Sort by ascending all FirstSet : ");
        firstSet.sortAsc();
        printFirstSet();

        System.out.println("Sort by descending all FirstSet : ");
        firstSet.sortDesc();
        printFirstSet();

        System.out.println("Sort by descending by number SecondSet: ");
        secondSet.sortDesc(13);
        printSecondSet();

        System.out.println("Sort by descending by index's ThirdSet: ");
        thirdSet.sortDesc(0,3);
        printThirdSet();

        System.out.println("Clear all SecondSet: ");
        secondSet.clear();
        printSecondSet();

        System.out.println("Clear by numbers ThirdSet: ");
        Number [] numbers = new Number[]{102,103};
        thirdSet.clear(numbers);
        printThirdSet();

}
public void printFirstSet(){
    System.out.println("FirstSet: ");
    for (int i = 0; i < firstSet.getSize(); i++) {
        System.out.print(firstSet.get(i)+" ");
    }
    System.out.println();

}
    public void printSecondSet() {
        System.out.println("SecondSet: ");
        for (int i = 0; i < secondSet.getSize(); i++) {
            System.out.print(secondSet.get(i) + " ");
        }
        System.out.println();
    }
    public void printThirdSet(){
        System.out.println("ThirdSet: ");
        for (int i = 0; i < thirdSet.getSize(); i++) {
            System.out.print(thirdSet.get(i)+" ");
        }
        System.out.println();
    }

}
