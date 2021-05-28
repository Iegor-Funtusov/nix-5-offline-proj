import level1.knightsMove.MoveKnight;
import level1.triangleArea.Point;
import level1.triangleArea.Triangle;
import level1.uniqueNumbers.ArrayOfNumbers;
import level2.binaryTreeDepth.BinaryTree;
import level2.correctStringInput.CheckingBrackets;
import level3.gameOfLife.GOLinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class ModuleMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        do {
            System.out.println("Для проверки уровня 1 введите \"1\"");
            System.out.println("Для проверки уровня 2 введите \"2\"");
            System.out.println("Для проверки уровня 3 введите \"3\"");
            System.out.println("Для выхода из приложения введите \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-3]")) {
                switch (str) {
                    case "1":
                        levelOneInterface();
                        break;
                    case "2":
                        levelTwoInterface();
                        break;
                    case "3":
                        GOLinterface.GOLInterface();
                        break;

                }
            } else {
                System.out.println("Уровень не выбран! Попробуйте еще раз");
            }
        } while (!str.equals("0"));
    }

    public static boolean checkRegExp(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static void levelOneInterface() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        do {
            System.out.println("Для проверки задания \"Уникальные числа\" введите \"1\"");
            System.out.println("Для проверки задания \"Ход коня\" введите \"2\"");
            System.out.println("Для проверки задания \"Площадь треугольника\" введите \"3\"");
            System.out.println("Для возврата в предыдущее меню введите \"<\"");
            str = reader.readLine();
            if (checkRegExp(str, "[1-3]")) {
                switch (str) {
                    case "1":
                        do {
                            System.out.println("Для выхода из задания введите \"0\"");
                            System.out.println("Как вы хотите протестировать задание? \n 1 - ручной режим \n 2 - автоматический режим");
                            str = reader.readLine();
                            if (str.equals("1")) {
                                System.out.println("Введите размер массива");
                                str = reader.readLine();
                                if (checkRegExp(str, "[0-9]+")) {
                                    int[] arr = new int[parseInt(str)];
                                    int i = 0;
                                    do {
                                        System.out.println("Введите " + i + " элемент");
                                        str = reader.readLine();
                                        if (checkRegExp(str, "[0-9]+")) {
                                            arr[i] = parseInt(str);
                                            i++;
                                        } else {
                                            System.out.println("Элемент введен не верно! Попробуйте еще раз");
                                        }
                                    } while (i < arr.length);
                                    System.out.println("число уникальных элементов равно " + ArrayOfNumbers.uniqueNumbers(arr));
                                } else {
                                    System.out.println("Размер введен не верно! Попробуйте еще раз");
                                }
                            } else if (str.equals("2")) {
                                int[] arr = createArrRand(10, 0, 10);
                                System.out.println("Размер массива равен:" + arr.length);
                                System.out.println("Массив:");
                                for (int i = 0; i < arr.length; i++) {
                                    System.out.print(arr[i] + " ");
                                }
                                System.out.println();
                                System.out.println("число уникальных элементов равно " + ArrayOfNumbers.uniqueNumbers(arr));
                            } else if (!str.equals("0")) {
                                System.out.println("Режим не выбран! Попробуйте еще раз");
                            }
                        } while (!str.equals("0"));
                        break;
                    case "2":
                        System.out.println("Это задание подразумевает только ручной ввод!!!");
                        MoveKnight.MoveInterface();
                        break;
                    case "3":
                        do {
                            System.out.println("Для выхода из задания введите \"0\"");
                            System.out.println("Как вы хотите протестировать задание? \n 1 - ручной режим \n 2 - автоматический режим");
                            str = reader.readLine();
                            if (str.equals("1")) {
                                Point[] points = new Point[3];
                                int i = 0;
                                do {
                                    System.out.println("Введите координаты точек. Пример: \"10, 10\"");
                                    str = reader.readLine();
                                    if (checkRegExp(str, "[1-9][0-9][,][ ][1-9][0-9]") || checkRegExp(str, "[1-9][,][ ][1-9]")
                                            || checkRegExp(str, "[1-9][,][ ][1-9][0-9]") || checkRegExp(str, "[1-9][0-9][,][ ][1-9]")) {
                                        String[] delimiter = str.split("[,][ ]");
                                        points[i] = new Point(parseInt(delimiter[0]), parseInt(delimiter[1]));
                                        i++;
                                    } else {
                                        System.out.println("Точка введена не верно! Попробуйте еще раз");
                                    }
                                } while (i < points.length);
                                System.out.println("Площадь треугольника равна " + new Triangle(points[0], points[1], points[2]).CalculateArea());
                            } else if (str.equals("2")) {
                                int[] arr = createArrRand(6, 0, 20);
                                System.out.println("Точки:");
                                System.out.println("A = " + arr[0] + ", " + arr[1]);
                                System.out.println("B = " + arr[2] + ", " + arr[3]);
                                System.out.println("C = " + arr[4] + ", " + arr[5]);
                                System.out.println();
                                System.out.println("Площадь треугольника равна " + new Triangle(new Point(arr[0], arr[1]), new Point(arr[2], arr[3]), new Point(arr[4], arr[5])).CalculateArea());
                            } else if (!str.equals("0")) {
                                System.out.println("Режим не выбран! Попробуйте еще раз");
                            }
                        } while (!str.equals("0"));
                        break;
                }
            } else {
                System.out.println("Задание не выбрано! Попробуйте еще раз");
            }
        } while (!str.equals("<"));
    }

    public static void levelTwoInterface() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        do {
            System.out.println("Для проверки задания \"Проверка скобок\" введите \"1\"");
            System.out.println("Для проверки задания \"Глубина бинарного дерева\" введите \"2\"");
            System.out.println("Для возврата в предыдущее меню введите \"<\"");
            str = reader.readLine();
            if (checkRegExp(str, "[1-2]")) {
                switch (str) {
                    case "1":
                        System.out.println("Это задание подразумевает только ручной ввод!!!");
                        do {
                            System.out.println("Для выхода из задания введите \"0\"");
                            System.out.println("Введите любую строку,содержащую следующие скобки ()[]{}");
                            str = reader.readLine();
                            if (CheckingBrackets.checkingCorrectBrackets(str)) {
                                System.out.println("Строка действительна");
                            } else if (!str.equals("0")) {
                                System.out.println("Строка является недопустимой");
                            }
                        } while (!str.equals("0"));
                        break;
                    case "2":
                        do {
                            System.out.println("Для выхода из задания введите \"0\"");
                            System.out.println("Как вы хотите протестировать задание? \n 1 - ручной режим \n 2 - автоматический режим");
                            str = reader.readLine();
                            if (str.equals("1")) {
                                System.out.println("Введите количество элементов в дереве");
                                str = reader.readLine();
                                BinaryTree binaryTree = new BinaryTree();
                                if (checkRegExp(str, "[0-9]+")) {
                                    int k = parseInt(str);
                                    int i = 0;
                                    do {
                                        System.out.println("Введите " + i + " элемент");
                                        str = reader.readLine();
                                        if (checkRegExp(str, "[0-9]+")) {
                                            binaryTree.insert(parseInt(str));
                                            i++;
                                        } else {
                                            System.out.println("Элемент введен не верно! Попробуйте еще раз");
                                        }
                                    } while (i < k);
                                    System.out.println("Глубина дерева равняется: " + binaryTree.maxDepth());
                                } else {
                                    System.out.println("Размер введен не верно! Попробуйте еще раз");
                                }
                            } else if (str.equals("2")) {
                                int[] array = createArrRand(10, 0, 20);
                                System.out.println("Элементы делева: ");
                                BinaryTree binaryTree = new BinaryTree();
                                Set<Integer> set = new HashSet<>();
                                for (int x : array) {
                                    set.add(x);
                                }
                                for (int i = 0; i < set.size(); i++) {
                                    System.out.print(set.toArray()[i] + " ");
                                    binaryTree.insert((int) set.toArray()[i]);
                                }
                                System.out.println();
                                System.out.println("Глубина дерева равняется: " + binaryTree.maxDepth());
                            } else if (!str.equals("0")) {
                                System.out.println("Режим не выбран! Попробуйте еще раз");
                            }
                        } while (!str.equals("0"));
                        break;
                }
            }
        } while (!str.equals("<"));
    }

    static int[] createArrRand(int N, int min, int max) {
        int[] array = new int[N];
        int diff = max - min;
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = min + (random.nextInt(diff + 1));
        }
        return array;
    }
}
