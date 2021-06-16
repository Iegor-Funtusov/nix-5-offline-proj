package nix.com;

import nix.com.math_set.MathSetControler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Inteface {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    MathSetControler<Integer> mathSetControler;

    public Inteface() throws IOException {
        String choose = null;

        chooseSet(choose);
        while (true) {
            menu();
            choose = reader.readLine();
            chooseMenu(choose);
        }
    }

    private void menu() {
        System.out.println("Choose option");
        System.out.println("1. Enter size of collection(default - 10) ");
        System.out.println("3. Add num or nums ");
        System.out.println("4. Join to default MathSet ");

        System.out.println("5. Show sort methods");
        System.out.println("6. Show math methods");

        System.out.println("7. squash(int firstIndex, int lastIndex) ");
        System.out.println("8. clear() ");
        System.out.println("9. clear(Number[] numbers) clears only identical elements ");

    }

    private void chooseSet(String choose) {
        while (true) {
            System.out.println("1. Integer nums");
            System.out.println("2. Float point nums");
            try {
                choose = reader.readLine();
                Integer.parseInt(choose);
            } catch (IOException e) {
                System.out.println("Wrong input");
            }
            switch (Integer.parseInt(choose)) {
                case 1:
                    mathSetControler = new <Integer>MathSetControler();
                    return;
                case 2:
                    mathSetControler = new <Double>MathSetControler();
                    return;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
    private void mathMethods() {
        System.out.println("1. get(int index) ");
        System.out.println("2. getMax() ");
        System.out.println("3. getMin() ");
        System.out.println("4. getAverage() ");
        System.out.println("5. getMedian() ");
    }

    private void chooseMenu(String choose) throws IOException {
        switch (Integer.parseInt(choose)) {
            case 1:
                System.out.println("Enter size");
                int size = 10;
                try {
                    size = Integer.parseInt(reader.readLine());
                } catch (IOException e) {
                    System.out.println("Wrong size");
                }
                mathSetControler.sizeConstruct(size);
                break;
            case 2:
                break;
            case 3:
                System.out.println("Enter element or elements");
                String element = reader.readLine();
                mathSetControler.add(Integer.parseInt(element));
                System.out.println(Arrays.toString(mathSetControler.toArray()));
                break;
            case 5:
                sortMethods();
                break;
            case 6:
                mathMethods();
                break;
        }
    }

    private void sortMethods() throws IOException {
        System.out.println("Choose sort");
        System.out.println("1. SortAsc() ");
        System.out.println("2. sortAsc(int firstIndex, int lastIndex) ");
        System.out.println("3. sortAsc(Number value) ");
        System.out.println("4. SortDesc() ");
        System.out.println("5. SortDesc(int firstIndex, int lastIndex) ");
        System.out.println("6. SortDesc(Number value) ");
        String choose = reader.readLine();
        switch(Integer.parseInt(choose)) {
            case 1:
                mathSetControler.sortAsc();
                break;
            case 2:
                System.out.println("Enter first index");
                int firstIndex = 0;
                int lastIndex = 0;
                try {
                    firstIndex = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Wrong input");
                }
                System.out.println("Enter last index");
                try {
                    lastIndex = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Wrong input");
                }
                mathSetControler.sortAsc(firstIndex, lastIndex);
                break;
            case 3:
                System.out.println("Enter num");
                int num = 0;
                try {
                    num = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Wrong input");
                }
                mathSetControler.sortAsc(num);
                break;
            case 4:
                mathSetControler.sortDesc();
                break;
            case 5:
                firstIndex = 0;
                lastIndex = 0;
                System.out.println("Enter first index");
                try {
                    firstIndex = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Wrong input");
                }
                System.out.println("Enter last index");
                try {
                    lastIndex = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Wrong input");
                }
                mathSetControler.sortDesc(firstIndex, lastIndex);
                break;
            case 6:
                System.out.println("Enter num");
                num = 0;
                try {
                    num = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Wrong input");
                }
                mathSetControler.sortDesc(num);
                break;
        }
    }
}
