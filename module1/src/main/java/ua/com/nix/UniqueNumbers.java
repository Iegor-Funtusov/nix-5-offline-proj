package ua.com.nix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueNumbers {
        public static void findUniqueNumbers() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите размер массива: ");

            int arrSize = Integer.parseInt(reader.readLine());
            int[] array = new int[arrSize];
            int count = 0;
            int amountOfNumbers = 0;
            System.out.println("Введите числа: ");

            for(int i = 0; i < array.length; i++) {
                int numbers = Integer.parseInt(reader.readLine());
                array[i] = numbers;
            }

            for(int i = 0; i < array.length; i++) {
                amountOfNumbers++;
                for(int j = i + 1; j < array.length; j++) {
                    if (array[j] == array[i]) {
                        count++;
                        break;
                    }
                }
            }

            System.out.println("Количество уникальных чисел: " + (amountOfNumbers - count));
        }
    }