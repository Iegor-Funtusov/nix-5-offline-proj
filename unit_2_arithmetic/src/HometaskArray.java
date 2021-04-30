import java.util.Scanner;

public class HometaskArray {

    public static void main(String[] args) {
        MyArray array = new MyArray();
        Scanner input = new Scanner(System.in);
        int k;
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
                    array.createArr();
                    break;
                case 2:
                    array.createArrRand();
                    break;
                case 3:
                    if (!array.getArray().isEmpty()) {
                        array.printArr();
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 4:
                    if (!array.getArray().isEmpty()) {
                        array.task1();
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 5:
                    if (!array.getArray().isEmpty()) {
                        array.task2();
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 6:
                    if (!array.getArray().isEmpty()) {
                        array.task3();
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 7:
                    if (!array.getArray().isEmpty()) {
                        array.task4();
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 8:
                    if (!array.getArray().isEmpty()) {
                        array.task5();
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;
                case 9:
                    if (!array.getArray().isEmpty()) {
                        array.task6();
                    } else {
                        System.out.println("Массив пусой, пожалуйста заполние его");
                    }
                    break;

            }
        } while (k != 0);
    }


}
