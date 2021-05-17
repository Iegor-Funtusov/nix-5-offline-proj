package com.example.unique_numbers;

import java.io.BufferedReader;
import java.io.IOException;

public class UniqueNumbersController {
    private final BufferedReader reader;

    public UniqueNumbersController(BufferedReader reader){
        this.reader = reader;
    }
    public void checkUniqueNumbers() throws IOException {
        System.out.println("Manual or Automatically generation array?: " + "\n 1 - Manual"
                + "\n 2 - Automatically" + "\n 3 - Back to Task selection " +"\n 0 - exit");
        String choose = reader.readLine();
        switch (choose){
            case "1":{
                int[] arr = initArray();
                manualGenerationArray(arr);
                System.out.println("Number of unique el: "+ArrayTools.countUniqueNumbers(arr));
                checkUniqueNumbers();
                break;
            }
            case "2":{
                int[] arr = initArray();
                randomGenerationArray(arr);
                System.out.println("Number of unique el: "+ArrayTools.countUniqueNumbers(arr));
                checkUniqueNumbers();
                break;
            }
            case "3":{
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }
        }

    }

    private int[] initArray() throws IOException{
        System.out.print("Enter size of array: "+"\n");
        int size = Integer.parseInt(reader.readLine());
        return new int[size];
    }

    private void manualGenerationArray(int[] arr) throws IOException{
        for (int i = 0; i < arr.length; i++) {
            System.out.print("El"+i+": ");
            arr[i] = Integer.parseInt(reader.readLine());
        }
    }

    private void randomGenerationArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 9);
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }
}
