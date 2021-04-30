import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HometaskArray {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int k = 0;
        do {
            System.out.println("1. Для создания нового массива вручную введите 1");
            System.out.println("2. Для создания нового массива с рандомными числами введите 2");
            System.out.println("3. Для вывода массива введите 3");
            System.out.println("4. Для выполнения ПЕРВОГО задания введите 4");
            System.out.println("5. Для выполнения ВТОРОГО задания введите 5");
            System.out.println("6. Для выполнения ТРЕТЬЕГО задания введите 6");
            System.out.println("7. Для выполнения ЧЕТВЕРТОГО задания введите 7");
            System.out.println("8. Для выполнения ПЯТЬОГО задания введите 8");
            System.out.println("9. Для выполнения ШЕСТОГО задания введите 9");
            System.out.println("0. Для выхода из приложения введите 0");
            k = input.nextInt();

            switch (k) {
                case 1:
                    array = createArr();
                    break;
                case 2:
                    array = createArrRand();
                    break;
                case 3:
                    if (!array.isEmpty()) {
                        printArr(array);
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 4:
                    if (!array.isEmpty()) {
                        task1(array);
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 5:
                    if (!array.isEmpty()) {
                        task2(array);
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 6:
                    if (!array.isEmpty()) {
                        task3(array);
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 7:
                    if (!array.isEmpty()) {
                        task4(array);
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 8:
                    if (!array.isEmpty()) {
                        task5(array);
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 9:
                    if (!array.isEmpty()) {
                        task6(array);
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;

            }
        } while (k != 0);
    }

    private static void task1(List<Integer> array) {
        System.out.println("Задание 1: вывести четные числа из массива");
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                System.out.print(array.get(i));
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void task2(List<Integer> array) {
        System.out.println("Задание 2: вывести кол-во положительных чисел");
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void task3(List<Integer> array) {
        System.out.println("Задание 3: вывести кол-во чисел больших предыдущего");
        int count = 0;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > array.get(i - 1)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void task4(List<Integer> array) {
        System.out.println("Задание 4: вывести кол-во чисел которые больше своих соседей");
        int count = 0;
        for (int i = 1; i < array.size() - 1; i++) {
            if (array.get(i) > array.get(i - 1) && array.get(i) > array.get(i + 1)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void task5(List<Integer> array) {
        System.out.println("Задание 5: вывести обратный массив");
        int temp = 0;
        for (int i = 0; i < array.size()/2; i++) {
            temp = array.get(i);
            array.set(i, array.get(array.size() - 1 - i));
            array.set(array.size() - 1 - i, temp);
        }
        printArr(array);
    }

    private static void task6(List<Integer> array) {
    }

    static List<Integer> createArr() {
        int N = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        N = input.nextInt();
        List<Integer> array = new ArrayList<>();
        System.out.println("Введите элементы массива");
        for (int i = 0; i < N; i++) {
            array.add(input.nextInt());
        }
        return array;
    }

    static List<Integer> createArrRand() {
        int N = 0;
        int min = 0, max = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        N = input.nextInt();
        List<Integer> array = new ArrayList<>();
        System.out.println("Введите нижнюю границу массива");
        min = input.nextInt();
        System.out.println("Введите верхнюю границу массива");
        max = input.nextInt();
        int diff = max - min;
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            array.add(min + (random.nextInt(diff + 1)));
        }
        return array;
    }

    static void printArr(List<Integer> array) {
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
