package firstLvl.UnicChisla;
import java.util.HashSet;
import java.util.Scanner;

public class UnicChisla {
    public static void unicChislaa() {
        Scanner input = new Scanner(System.in);
        System.out.println("Задайте размер массива: ");
        int size = input.nextInt();
        int array[] = new int[size];
        HashSet<Integer> intSet = new HashSet<>();
        System.out.println("Введите элементы массива:");

        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
            intSet.add(array[i]);
        }

        System.out.println ("Количество уникальных элементов:"+intSet.size());
    }
}
