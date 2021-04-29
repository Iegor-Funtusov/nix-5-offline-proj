package org.example.unit2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
        int[] evenAndOddNums = {1,2,3,4,5};
        ArrayTool.printEvenNumbersToConsole(evenAndOddNums);

        int[] posAndNegNums = {1,2,3,-1,-4};
        System.out.println("Number of Positive Nums = " + ArrayTool.countPositiveNumbers(posAndNegNums));

        int[] arr = {1,2,3,4,5};
        System.out.println("Number of values is greater then previous one: = " + ArrayTool.countValuesIsGreaterThenPrevious(arr));

        int[] arrAdjVal = {1,5,1,5,1};
        System.out.println("countAdjacentValueLess = " + ArrayTool.countAdjacentValueLess(arrAdjVal));

        int[] arrForReverse = {4,5,3,4,2,3};
        ArrayTool.reverseArray(arrForReverse);
        System.out.println("Reversed array = " + Arrays.toString(arrForReverse));

        int[] arrForSwapAdjacentEl = {4,5,3,4,2,3};
        ArrayTool.swapOfAdjacentElements(arrForSwapAdjacentEl);
        System.out.println("arrForSwapAdjacentEl = " + Arrays.toString(arrForSwapAdjacentEl));
    }
}
