package ua.nix.vladimirprog1c;

public class ArrayMain {

    public static void main(String[] args) {
        int[] ar1 = {1,2,3,4,5};
        int[] ar2 = {1,2,3,-1,-4};
        int[] ar3 = {1,2,3,4,5};
        int[] ar4a = {1,2,3,4,5};
        int[] ar4b = {1,5,1,5,1};
        int[] ar5 = {4,5,3,4,2,3};
        int[] ar6 = {4,5,3,4,2,3};

        ArithmeticArray arithmeticArray = new ArithmeticArray();
        arithmeticArray.printEvent(ar1);
        arithmeticArray.printNumberNegative(ar2);
        arithmeticArray.printMoreThenPrevious(ar3);
        arithmeticArray.printMoreThenNeighbors(ar4a);
        arithmeticArray.printMoreThenNeighbors(ar4b);
        arithmeticArray.printReversArray(ar5);
        arithmeticArray.printReversNeighbors(ar6);

    }
}
