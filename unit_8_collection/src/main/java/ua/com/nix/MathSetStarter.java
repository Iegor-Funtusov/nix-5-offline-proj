package ua.com.nix;

public class MathSetStarter {

    MathSet<Integer> mathSet = new MathSet<>();
    MathSet<Integer> mathSet2 = new MathSet<>();

    public void start() {

        addNumbersToMathSet1();
        printMathSet1();

        addNumbersToMathSet2();
        printMathSet2();

        mathSet.join(mathSet2);
        System.out.println("Результат join: ");
        printMathSet1();

        System.out.println("Сортировка сета по убыванию: ");
        mathSet.sortDesc();
        printMathSet1();

        System.out.println("Сортировка сета по убыванию диапазонно");
        mathSet2.clear();
        addNumbersToMathSet2();
        mathSet2.sortDesc(1, 3);
        printMathSet2();

        System.out.println("Сортировка сета по убыванию по числу: ");
        System.out.println("Кстати да, очистка сета: ");
        mathSet2.clear();
        addNumbersToMathSet2();
        mathSet2.sortDesc(2);
        printMathSet2();

        System.out.println("Сортировка сета по возрастанию: ");
        mathSet.clear();
        addNumbersToMathSet1();
        mathSet.sortDesc();
        mathSet.sortAsc();
        printMathSet1();

        System.out.println("Сортировка сета по возрастанию от индекса до индекса: ");
        mathSet.clear();
        addNumbersToMathSet1();
        mathSet.sortDesc();
        mathSet.sortAsc(0, 2);
        printMathSet1();

        System.out.println("Сортировка сета по возрастанию по числу: ");
        mathSet.clear();
        addNumbersToMathSet1();
        mathSet.sortDesc();
        mathSet.sortAsc(2);
        printMathSet1();

        System.out.println("Получение индекса сета: ");
        System.out.println(mathSet.get(2));

        System.out.println("Получение максимума сета: ");
        mathSet.clear();
        addNumbersToMathSet1();
        System.out.println(mathSet.getMax());

        System.out.println("Получение минимума сета: ");
        System.out.println(mathSet.getMin());

        System.out.println("Получение среднего арифметического сета: ");
        System.out.println(mathSet.getAverage());

        System.out.println("Получение вывода середины сета: ");
        System.out.println(mathSet.getMedian());

        Number[] numbers = new Number[]{1, 2, 3};
        mathSet.clear(numbers);
        printMathSet1();
    }

    public void printMathSet1() {
        System.out.println("Вывод первого сета: ");
        for (int i = 0; i < mathSet.getSize(); i++) {
            System.out.println(mathSet.get(i));
        }
    }

    public void printMathSet2() {
        System.out.println("Вывод второго сета: ");
        for (int i = 0; i < mathSet2.getSize(); i++) {
            System.out.println(mathSet2.get(i));
        }

    }

    public void addNumbersToMathSet1() {
        for (int i = 0; i < 5; i++) {
            mathSet.add(i);
        }
    }

    public void addNumbersToMathSet2() {
        for (int i = 0; i < 5; i++) {
            mathSet2.add(i);
        }
    }
}
