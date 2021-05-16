package ua.com.nix.realization.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.math.NumberUtils;

public class UniqSymbols {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       public void fillingStrings() throws IOException {
           System.out.println("Enter array length: ");
           int size = Integer.parseInt(reader.readLine());
           int[] arr = new int[size];
           String s;
           for (int i = 0; i < arr.length;) {
               System.out.println("Enter " + i + " element of array: ");
               s = reader.readLine();
               if(NumberUtils.isCreatable(s)) {
                   arr[i] = Integer.parseInt(s);
                   i++;
               }
               else {
                   System.out.println("This is not a number,try again");
               }
           }
           System.out.println(Arrays.toString(arr));
           System.out.println("Unique characters in this array: " + uniqueCount(arr));
       }


       public  int uniqueCount(int [] arr)
       {
           Set<Integer> mySet = new HashSet<>();
           for (int x : arr) {
               mySet.add(x);
           }
           return mySet.size();
       }
}
