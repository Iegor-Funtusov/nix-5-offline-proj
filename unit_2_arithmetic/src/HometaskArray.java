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
            System.out.println("1. Для создания массива вручную введите 1");
            System.out.println("2. Для создания массива с рандомными числами введите 2");
            System.out.println("3. Для вывода массива введите 3");
            System.out.println("9. Для выхода из приложения введите 9");
            k = input.nextInt();

            switch (k) {
                case 1:
                    array = createArr();
                    break;
                case 2:
                    array = createArrRand();
                    break;
                case 3:
                    printArr(array);
                    break;

            }
        } while (k != 9);
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
                System.out.println(array.get(i));
            }
        } else {
            System.out.println("Массив пусой, пожалуйста заполние его");
        }
    }
}
