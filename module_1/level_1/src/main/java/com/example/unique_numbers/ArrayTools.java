package com.example.unique_numbers;

import java.util.Arrays;

public class ArrayTools {
    public static long countUniqueNumbers(int[] arr){
        return Arrays.stream(arr).distinct().count();
    }
}
