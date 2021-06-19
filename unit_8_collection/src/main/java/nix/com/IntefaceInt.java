package nix.com;

import nix.com.math_set.MathSetControler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntefaceInt {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    MathSetControler<Double> mathSetControler;

    public IntefaceInt() throws IOException {
        String choose;
        mathSetControler = new MathSetControler<>();
        while (true) {
            menu();
            choose = reader.readLine();
            chooseMenu(choose);
        }
    }

    private void menu() {
        System.out.println("Choose option");
        System.out.println("1. Enter size of collection(default - 10, erase all added elements) ");
        System.out.println("2. Add num or nums ");

        System.out.println("3. Show sort methods");
        System.out.println("4. Show math methods");

        System.out.println("5. squash(int firstIndex, int lastIndex) ");
        System.out.println("6. clear() ");
        System.out.println("7. show all elements ");
        System.out.println("8. exit ");

    }

    private void mathMethods() throws IOException {
        System.out.println("1. get(int index) ");
        System.out.println("2. getMax() ");
        System.out.println("3. getMin() ");
        System.out.println("4. getAverage() ");
        System.out.println("5. getMedian() ");
        chooseMathMeth();
    }

    private void chooseMathMeth() throws IOException {
        String choose = reader.readLine();
        try {
            Integer.parseInt(choose);
            if (Integer.parseInt(choose) > 5 || Integer.parseInt(choose) < 0) {
                System.out.println("Wrong input");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input");
            return;
        }
        switch ((int) Double.parseDouble(choose)) {
            case 1:
                int index = 0;
                System.out.println("Enter index of element");
                try {
                    index = (int) Double.parseDouble(reader.readLine());
                    System.out.println("Element: " + mathSetControler.get(index));
                } catch (Exception e) {
                    System.out.println("Wrong input");
                }
                break;
            case 2:
                try {
                    System.out.println("Max: " + mathSetControler.getMax());
                } catch (IllegalArgumentException ex) {
                    System.out.println("IllegalArgumentException");
                }
                break;
            case 3:
                try {
                    System.out.println("Min: " + mathSetControler.getMin());
                } catch (IllegalArgumentException ex) {
                    System.out.println("IllegalArgumentException");
                }
                break;
            case 4:
                try {
                    System.out.println("Average: " + mathSetControler.getAverage());
                } catch (IllegalArgumentException ex) {
                    System.out.println("IllegalArgumentException");
                }
                break;
            case 5:
                try {
                    System.out.println("Median: " + mathSetControler.getMedian());
                } catch (IllegalArgumentException ex) {
                    System.out.println("IllegalArgumentException");
                }
                break;
        }
    }

    private void chooseMenu(String choose) throws IOException {
        while (true) {
            try {
                Integer.parseInt(choose);
                if (Integer.parseInt(choose) > 8 || Integer.parseInt(choose) < 0) {
                    System.out.println("Wrong input");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
                break;
            }
            switch (Integer.parseInt(choose)) {
                case 1:
                    System.out.println("Enter size");
                    int size = 10;
                    try {
                        size = Integer.parseInt(reader.readLine());
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Wrong size");
                    }
                    mathSetControler.sizeConstruct(size);
                    return;
                case 2:
                    System.out.println("Enter element or elements(for stop write \"break\")");
                    String element = reader.readLine();
                    if (element.equals("break")) {
                        return;
                    }
                    try {
                        mathSetControler.add(Double.parseDouble(element));
                    } catch (NumberFormatException ex) {
                        System.out.println("Wrong input");
                    }
                    System.out.println(Arrays.toString(mathSetControler.toArray()));
                    break;
                case 3:
                    sortMethods();
                    return;
                case 4:
                    mathMethods();
                    return;
                case 5:
                    System.out.println("Enter first index");
                    int firstIndex = 0;
                    int lastIndex = 0;
                    try {
                        firstIndex = Integer.parseInt(reader.readLine());
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                        break;
                    }
                    System.out.println("Enter last index");
                    try {
                        lastIndex = Integer.parseInt(reader.readLine());
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                    }
                    mathSetControler.squash(firstIndex, lastIndex);
                    return;
                case 6:
                    mathSetControler.clear();
                    return;
                case 7:
                    System.out.println(Arrays.toString(mathSetControler.toArray()));
                    return;
                case 8:
                    System.exit(0);
                    return;
            }
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
        try {
            Integer.parseInt(choose);
            if (Integer.parseInt(choose) > 6 || Integer.parseInt(choose) < 0) {
                System.out.println("Wrong input");
                return;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Wrong input");
            return;
        }
        switch(Integer.parseInt(choose)) {
            case 1:
                mathSetControler.sortAsc();
                return;
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
                try {
                    mathSetControler.sortAsc(firstIndex, lastIndex);
                } catch (IllegalArgumentException ex) {
                    System.out.println("IllegalArgumentException");
                }
                break;
            case 3:
                System.out.println("Enter num");
                int num = 0;
                try {
                    num = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Wrong input");
                }
                try {
                    mathSetControler.sortAsc(num);
                } catch (IllegalArgumentException ex) {
                    System.out.println("IllegalArgumentException");
                }
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
                try {
                    mathSetControler.sortDesc(firstIndex, lastIndex);
                } catch (IllegalArgumentException ex) {
                    System.out.println("IllegalArgumentException");
                }
                break;
            case 6:
                System.out.println("Enter num");
                num = 0;
                try {
                    num = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Wrong input");
                }
                try {
                    mathSetControler.sortDesc(num);
                } catch (IllegalArgumentException ex) {
                    System.out.println("IllegalArgumentException");
                }
                break;
        }
    }
}
