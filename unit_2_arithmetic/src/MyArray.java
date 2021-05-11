import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MyArray {
    private List<Integer> array = new ArrayList<>();

    public List<Integer> getArray() {
        return array;
    }

    void evenNumbers() {
        System.out.println("Задание 1: вывести четные числа из массива");
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                System.out.print(array.get(i) + " ");
            }
        }
        System.out.println();
    }

    void positiveNumbersCount() {
        System.out.println("Задание 2: вывести кол-во положительных чисел");
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    void moreThanPrevious() {
        System.out.println("Задание 3: вывести кол-во чисел больших предыдущего");
        int count = 0;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > array.get(i - 1)) {
                count++;
            }
        }
        System.out.println(count);
    }

    void moreThanNeighbors() {
        System.out.println("Задание 4: вывести кол-во чисел которые больше своих соседей");
        int count = 0;
        for (int i = 1; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i - 1) && array.get(i) > array.get(i + 1)) {
                count++;
            }
        }
        System.out.println(count);
    }

    void reverseArray() {
        System.out.println("Задание 5: вывести обратный массив");
        int temp;
        for (int i = 0; i < array.size() / 2; i++) {
            temp = array.get(i);
            array.set(i, array.get(array.size() - 1 - i));
            array.set(array.size() - 1 - i, temp);
        }
        printArr();
    }

    void task6() {
        System.out.println("Задание 6: поменять соседние элементы местами и вывести массив");
        int temp;
        for (int i = 0; i < array.size(); i += 2) {
            if (i == array.size() - 1) {
                break;
            }
            temp = array.get(i);
            array.set(i, array.get(i + 1));
            array.set(i + 1, temp);
        }
        printArr();
    }

    void createArr() {
        int N;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        N = input.nextInt();
        System.out.println("Введите элементы массива");
        for (int i = 0; i < N; i++) {
            array.add(input.nextInt());
        }
    }

    void createArrRand() {
        int N;
        int min = 0, max = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        N = input.nextInt();
        System.out.println("Введите нижнюю границу массива");
        min = input.nextInt();
        System.out.println("Введите верхнюю границу массива");
        max = input.nextInt();
        int diff = max - min;
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            array.add(min + (random.nextInt(diff + 1)));
        }
    }

    void printArr() {
        if (!array.isEmpty()) {
            for (int i = 0; i < array.size(); i++) {
                System.out.print(array.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println("Массив пусой, пожалуйста заполние его");
        }
    }
}
