package ua.com.alevel.controlpanel;

import ua.com.alevel.UniqueSymbols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FirstLevel {
    private static BufferedReader reader;

    public static void controlFirstLevel() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        try {
            System.out.println("Choose the level:\n" +
                    "1 -> Unique symbols in array\n" +
                    "2 -> Knight turn\n" +
                    "3 -> Triangle area\n" +
                    "0 -> Back to Menu");
            if ((input = reader.readLine()) != null) {
                do {
                    switch (input) {
                        case "1": {
                            uniqueSymbols();
                        }
                        break;
                        case "2": {
                            knightTurn();
                        }
                        break;
                        case "3": {
                            triangleArea();
                        }
                        break;
                        case "0": {
                            return;
                        }
                        default: {
                            System.out.println("Wrong input. Use numbers 0-3");
                        }
                        break;
                    }
                    System.out.println("\nChoose the level:\n" +
                            "1 -> Unique symbols in array\n" +
                            "2 -> Knight turn\n" +
                            "3 -> Triangle area\n" +
                            "0 -> Back to Menu");
                } while ((input = reader.readLine()) != null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void uniqueSymbols() throws IOException{
        Scanner s = new Scanner(System.in);
        System.out.println("Choose generation:\n" +
                "1 -> User generation\n" +
                "2 -> Random generation");
        String input = reader.readLine();

        switch (input) {
            case "1": {
                System.out.print("Input size array: ");
                int size = s.nextInt();
                int[] array = new int[size];
                System.out.print("Input array elements: ");
                int i = 0;
                while (i < size) {
                    int element = s.nextInt();
                    array[i] = element;
                    i++;
                }
                System.out.println("\nQuantity unique symbols: "+UniqueSymbols.countUnique(array));
                break;
            }
            case "2": {
                System.out.print("Input size array: ");
                int size = s.nextInt();
                int[] array = new int[size];
                System.out.print("Random array elements: ");
                int i = 0;
                while (i < size) {
                    array[i] = (int) Math.round((Math.random() * 50) - 25);
                    System.out.print(array[i] + " ");
                    i++;
                }
                System.out.println("\nQuantity unique symbols: "+UniqueSymbols.countUnique(array));
                break;
            }
            default:{
                System.out.println("Wrong input. Use 1 or 2");
            }
            break;

        }
    }

    public static void knightTurn(){
    }

    public static void triangleArea(){
    }
}
