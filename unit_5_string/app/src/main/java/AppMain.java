import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class AppMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = -1;

        do {
            System.out.println("1. Чтобы совершить \"реверс\" всех слов в строке введите 1");
            System.out.println("2. Чтобы совершить \"реверс\" по указанной подстроке в строке введите 2");
            System.out.println("3. Чтобы совершить \"реверс\" в определенном промежутке в строке введите 3");
            System.out.println("0. Для выхода из приложения введите 0");
            try {
                k = parseInt(reader.readLine());
                if (k > 3) System.out.println("Попробуйте еще раз");
            } catch (NumberFormatException e) {
                System.out.println("Попробуйте еще раз");
            }
            switch (k) {
                case 1:
                    System.out.println("Введите начальную строку");
                    String str = reader.readLine();
                    System.out.println(ReverseString.reverse(str));
                    break;
                case 2:
                    System.out.println("Введите начальную строку");
                    str = reader.readLine();
                    System.out.println("Введите подстроку");
                    String Substr = reader.readLine();
                    System.out.println(ReverseString.reverse(str, Substr));
                    break;
                case 3:
                    System.out.println("Введите начальную строку");
                    str = reader.readLine();
                    System.out.println("Введите индекс НАЧАЛА \"реверса\" (включительно)");
                    int i, j;
                    try {
                        i = parseInt(reader.readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Вы введи не цифру. Попробуйте еще раз!");
                        break;
                    }
                    System.out.println("Введите индекс КОНЦА \"реверса\" (включительно)");
                    try {
                        j = parseInt(reader.readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Вы введи не цифру. Попробуйте еще раз!");
                        break;
                    }
                    System.out.println(ReverseString.reverse(str, i, j));
                    break;
            }
        } while (k != 0);
    }
}
