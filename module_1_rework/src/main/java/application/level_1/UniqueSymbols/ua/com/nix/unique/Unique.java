package application.level_1.UniqueSymbols.ua.com.nix.unique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Unique {
    public void findUniqueByUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arrLength;
        while (true) {
            try {
                System.out.print("Введите длину массива: ");
                arrLength = Integer.parseInt(reader.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите нормально число");
            }
        }
        Integer[] arr = new Integer[arrLength];
        System.out.println("Заполните массив: ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        Set<Integer> targetSet = new HashSet(Arrays.asList(arr));
        System.out.println("Уникальных значений: " + targetSet.size());
    }

    public void findUniqueByProgram() {
        int arrLength = 5;
        System.out.println("Длина массива: " + arrLength);
        Integer[] arr = new Integer[arrLength];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }

        Set<Integer> targetSet = new HashSet<>(Arrays.asList(arr));
        System.out.println("\nУникальных значений: " + targetSet.size());

    }
}

