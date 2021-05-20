package ua.com.alevel.lvl1;

import java.util.ArrayList;

public class UniqueNumber {
    public static int uniqueCount(int[] arr){
       int count = 0;
        ArrayList <Integer> newArr = new ArrayList<Integer>();
       for (int a : arr){
           if (!newArr.contains(a)){
              newArr.add(a);
           }
           count = newArr.size();
       }
        return count;
    }
}