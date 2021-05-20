package ua.com.alevel;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainClass{
    public static void main(String[]args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the lenght of array");
        int size = Integer.parseInt(reader.readLine());
        int[] list = new int[size];
        System.out.println("Enter elements through 'Enter' ");
        for (int i = 0; i < list.length; i++) {
            String s = reader.readLine();
            list[i] = Integer.parseInt(s);
            }

        System.out.println("\n Choose option\n"+
                "1 Show all even numbers\n" +
                "2 Count all positive numbers\n" +
                "3 Count all numbers bigger than the previous one\n" +
                "4 Count all numbers whose neighbors are smaller\n" +
                "5 Revers order of elements\n" +
                "6 Scrambling elements\n");

        int choise = Integer.parseInt(reader.readLine());

        switch (choise) {
            case 1:
                T1EvenNum.evenNum(list);
                break;
            case 2:
                T2PositiveNum.positiveNum(list);
                break;
            case 3:
                T3BiggerThanPre.biggerThenPre(list);
                break;
            case 4:
                T4BiggerThenNeighbors.biggerThenNeighbors(list);
                break;
            case 5:
                T5ReverseOrder.reversedOrder(list);
                break;
            case 6:
                T6Scrambling.scrambling(list);
                break;
        }





    }

}