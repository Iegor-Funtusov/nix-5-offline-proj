package app.controller;

import app.service.MathSetService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Controller {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void menu() throws IOException {
        String input;
        MathSetService<Number> mathSetService = new MathSetService<>();
        MathSetService<Number> optionalMathSetService;
        Number[] numbs;
        int[] bounds = new int[]{0, 0};
        int index;

        printMenu();
        while ((input = bufferedReader.readLine()) != null) {
            try {
                switch (input) {
                    case "1":
                        mathSetService = new MathSetService<>();
                        break;
                    case "2":
                        System.out.println("Input capacity:");
                        mathSetService = new MathSetService<>(Integer.parseInt(bufferedReader.readLine()));
                        break;
                    case "3":
                        numbs = inputElements(bufferedReader);
                        mathSetService = new MathSetService<>(numbs);
                        break;
                    case "4":
                        mathSetService = new MathSetService<>(createNumberArrays(bufferedReader));
                        break;
                    case "5":
                        numbs = inputElements(bufferedReader);
                        mathSetService = new MathSetService<>(new MathSetService<>(numbs));
                        break;
                    case "6":
                        mathSetService = new MathSetService<>(createMathSets(bufferedReader));
                        break;
                    case "7":
                        System.out.println("Please, enter the number:");
                        mathSetService.add(Double.parseDouble(bufferedReader.readLine()));
                        break;
                    case "8":
                        numbs = inputElements(bufferedReader);
                        mathSetService.add(numbs);
                        break;
                    case "9":
                        numbs = inputElements(bufferedReader);
                        optionalMathSetService = new MathSetService<>(numbs);
                        mathSetService.join(optionalMathSetService);
                        break;
                    case "10":
                        mathSetService.join(createMathSets(bufferedReader));
                        break;
                    case "11":
                        mathSetService.sortDesc();
                        break;
                    case "12":
                        inputBounds(bounds, bufferedReader);
                        mathSetService.sortDesc(bounds[0], bounds[1]);
                        break;
                    case "13":
                        System.out.println("Please, input value");
                        mathSetService.sortDesc(Integer.parseInt(bufferedReader.readLine()));
                        break;
                    case "14":
                        mathSetService.sortAsc();
                        break;
                    case "15":
                        inputBounds(bounds, bufferedReader);
                        mathSetService.sortAsc(bounds[0], bounds[1]);
                        break;
                    case "16":
                        System.out.println("Please, input value");
                        mathSetService.sortAsc(Integer.parseInt(bufferedReader.readLine()));
                        break;
                    case "17":
                        System.out.println("Please, enter the index:");
                        index = Integer.parseInt(bufferedReader.readLine());
                        System.out.println(mathSetService.get(index));
                        break;
                    case "18":
                        System.out.println(mathSetService.getMax());
                        break;
                    case "19":
                        System.out.println(mathSetService.getMin());
                        break;
                    case "20":
                        System.out.println(mathSetService.getAverage());
                        break;
                    case "21":
                        System.out.println(mathSetService.getMedian());
                        break;
                    case "22":
                        System.out.println(Arrays.toString(mathSetService.toArray()));
                        break;
                    case "23":
                        inputBounds(bounds, bufferedReader);
                        System.out.println(Arrays.toString(mathSetService.toArray(bounds[0], bounds[1])));
                        break;
                    case "24":
                        inputBounds(bounds, bufferedReader);
                        System.out.println(Arrays.toString(mathSetService.squash(bounds[0], bounds[1]).toArray()));
                        break;
                    case "25":
                        mathSetService.clear();
                        break;
                    case "26":
                        numbs = inputElements(bufferedReader);
                        mathSetService.clear(numbs);
                        break;
                    case "0":
                        System.exit(0);
                    default:
                        System.out.println("Error input. Put numbers");
                }
            } catch (RuntimeException exception) {
                System.out.println("Error");
            }
            printMenu();
        }
    }

    private Number[] inputElements(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input number of elements:");
        int count = Integer.parseInt(bufferedReader.readLine());
        Number[] numbers = new Number[count];
        System.out.println("Input elements(Separate with ENTER):");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }
        return numbers;
    }

    private void inputBounds(int[] bounds, BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter the first bound index");
        bounds[0] = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter the second bound index");
        bounds[1] = Integer.parseInt(bufferedReader.readLine());
    }

    private MathSetService<Number>[] createMathSets(BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter the number of maths sets");
        int count = Integer.parseInt(bufferedReader.readLine());
        MathSetService<Number>[] tmp = new MathSetService[count];
        int i = 0;
        while (i < count) {
            tmp[i] = new MathSetService<>(inputElements(bufferedReader));
            i++;
        }
        return tmp;
    }

    private Number[][] createNumberArrays(BufferedReader bufferedReader) throws IOException {
        System.out.println("Please, input amount of number arrays");
        int count = Integer.parseInt(bufferedReader.readLine());
        Number[][] temp = new Number[count-1][];
        for (int i = 0; i < count; i++) {
            Number[] tmp = inputElements(bufferedReader);
            System.arraycopy(tmp, 0, temp[i], 0, tmp.length);
        }
        return temp;
    }

    private void printMenu() {
        System.out.println("1 -> create MathSet()\n" +
                "2 -> create MathSet(int capacity)\n" +
                "3 -> create MathSet(Number[] numbers)\n" +
                "4 -> create MathSet(Number[] ... numbers)\n" +
                "5 -> create MathSet(MathSet numbers)\n" +
                "6 -> create MathSet(MathSet ... numbers)\n" +
                "7 -> add(Number n)\n" +
                "8 -> add(Number ... n)\n" +
                "9 -> join(MathSet ms)\n" +
                "10 -> join(MathSet ... ms)\n" +
                "11 -> sortDesc()\n" +
                "12 -> sortDesc(int firstIndex, int lastIndex)\n" +
                "13 -> sortDesc(Number value)\n" +
                "14 -> sortAsc()\n" +
                "15 -> sortAsc(int firstIndex, int lastIndex)\n" +
                "16 -> sortAsc(Number value)\n" +
                "17 -> get(int index)\n" +
                "18 -> getMax()\n" +
                "19 -> getMin()\n" +
                "20 -> getAverage()\n" +
                "21 -> getMedian()\n" +
                "22 -> toArray()\n" +
                "23 -> toArray(int firstIndex, int lastIndex)\n" +
                "24 -> squash(int firstIndex, int lastIndex)\n" +
                "25 -> clear()\n" +
                "26 -> clear(Number[] numbers)\n" +
                "0 -> exit");
    }
}
