package utils;

import java.util.List;
import impl.MathSet;

public class MathSetControll {
    private static MathSet mathSet = new MathSet();

    public void run(){
        while (true){
            int i = 0;

            try {
                i = UserInput.userInputNumber("Please choose action" +
                        "\n1 - add" +
                        "\n2 - sort" +
                        "\n3 - getMax" +
                        "\n4 - getMin" +
                        "\n5 - getAverage" +
                        "\n6 - getMedian" +
                        "\n7 - print" +
                        "\n8 - auto test" +
                        "\n0 - exit");
            }catch (NumberFormatException e){
                System.err.println("Invalid input pleas try again");
                run();
            }
            switch (i){
                case 1: addElement();break;
                case 2: sortMathSet(); break;
                case 3: getMax(); break;
                case 4: getMin(); break;
                case 5: getAverage(); break;
                case 6: getMedian(); break;
                case 7:showMathSetElements(); break;
                case 8:autoTest(); break;
                case 0: System.exit(0);
            }

        }
    }

    private static void autoTest() {
        Integer[] numbers1 = new Integer[]{2, 8, 1, 3, 3};
        Integer[] numbers2 = new Integer[]{5, 4, 3, 2, 1};
        Integer[] numbers3 = new Integer[]{99, 72, 31, 37, 45};
        System.out.println("arrays: ");
        for (Integer integer : numbers1) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : numbers2) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : numbers3) {
            System.out.print(integer + " ");
        }
        System.out.println();
        MathSet<Integer> mathSet1 = new MathSet<Integer>(numbers1);
        System.out.println("Set1 = " + mathSet1);
        MathSet<Integer> mathSet2 = new MathSet<Integer>(numbers2);
        System.out.println("Set2 = " + mathSet2);
        MathSet<Integer> mathSet3 = new MathSet<Integer>(numbers3);
        System.out.println("Set3 = " + mathSet3);
        System.out.println("Set3 + " + "11, 3, 78, 8, 9");
        mathSet3.add(11, 3, 78, 8, 9);
        System.out.println("Set3 = " + mathSet3);
        MathSet<Integer> mathSet4 = new MathSet<Integer>(mathSet1, mathSet2);
        System.out.println("Set4 = Set1 + Set2 = " + mathSet4);
        MathSet<Integer> mathSet5 = new MathSet<Integer>();
        mathSet5.join(mathSet3, mathSet4);
        System.out.println("Set5 = Set3 + Set4 " + mathSet5);
        mathSet5.sortDesc(4, 14);
        System.out.println("sortDesk between 4, 14 in Set5 " + mathSet5);
        mathSet5.sortAsc(5, 13);
        System.out.println("sortAsk between 5, 13 in Set5 " + mathSet5);
        System.out.println("get 10 element in Set5 = " + mathSet5.get(10));
        System.out.println("get Max in Set5 = " + mathSet5.getMax());
        System.out.println("get Min in Set5 = " + mathSet5.getMin());
        System.out.println("get Average in Set5 = " + mathSet5.getAverage());
        System.out.println("get Median in mathSet5 = " + mathSet5.getMedian());
        System.out.println("get array between 2, 8 in Set5 : ");
        Number[] numbers4 = mathSet5.toArray(2, 8);
        for (Number number : numbers4) {
            System.out.print(number + " ");
        }
        System.out.println();
        mathSet5.clear(numbers4);
        System.out.println("Set5 clear array = " + mathSet5);
        mathSet5.clear();
        System.out.println("Set5 clear All = " + mathSet5);
    }

    private void getMin() {
        Number min = mathSet.getMin();
        System.out.println("min = " + min);
    }

    public void addElement(){
        List<Integer> integers = UserInput.userInputNumbers("Pleas enter numbers that will be added to mathSet");
        for (int n:integers) {
            mathSet.add(n);
        }
    }

    public void showMathSetElements(){
        System.out.println(mathSet);
    }

    public void getMax(){
        Number max = mathSet.getMax();
        System.out.println("max = " + max);
    }

    public void getAverage(){
        Number average = mathSet.getAverage();
        System.out.println("average = " + average);
    }

    public void getMedian(){
        Number median = mathSet.getMedian();
        System.out.println("median = " + median);
    }

    public void sortMathSet(){
        int i = UserInput.userInputNumber("1 - ASC\n2 - DESC");
        switch (i){
            case 1:{
                ascSorts();
                break;
            }
            case 2:{
                descSort();
                break;
            }
            default:{
                System.out.println("Wrong action please try again");
                sortMathSet();
            }
        }


    }

    private void descSort() {
        int i = UserInput.userInputNumber("1 - Without index\n2 - with index");
        switch (i){
            case 1:{
                mathSet.sortDesc();
                break;
            }
            case 2:{
                indexSort(true);
                break;
            }
            default:{
                System.out.println("Wrong action pleas try again");
                descSort();
            }
        }


    }

    private void ascSorts() {
        int i = UserInput.userInputNumber("1 - Without index\n2 - with index");
        switch (i){
            case 1:{
                mathSet.sortAsc();
                break;
            }
            case 2:{
                indexSort(false);
                break;
            }
            default:{
                System.out.println("Wrong action pleas try again");
                ascSorts();
            }
        }

    }

    private void indexSort(boolean desc) {
        List<Integer> integers = UserInput.userInputNumbers("Enter first and last index seperated by space");
        if(integers.size() != 2){
            System.out.println("Only two index allowed pleas try again");
            indexSort(false);
        }
        if(desc){
            mathSet.sortDesc(integers.get(0), integers.get(1));
        }else {
            mathSet.sortAsc(integers.get(0), integers.get(1));
        }
    }


}