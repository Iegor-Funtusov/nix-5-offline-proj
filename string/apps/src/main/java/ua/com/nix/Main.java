package ua.com.nix;

import libs.ReverseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        offer();
        String read = reader.readLine();
        while (!read.isEmpty()){
            switch (read){
                case "0": {
                    System.exit(0);
                }
                case "1":
                    System.out.println("Введите строку: ");
                    String src = reader.readLine();
                    System.out.println(ReverseString.stringReverse(src));
                    break;
                case "2":
                    System.out.println("Введите строку: ");
                    String src2 = reader.readLine();
                    System.out.println("Введите подстроку: ");
                    String dest = reader.readLine();
                    System.out.println(ReverseString.substringReverse(src2, dest));
                    break;
                case "3":
                    System.out.println("Введите строку: ");
                    String src3 = reader.readLine();
                    System.out.println("Введите начальный индекс: ");
                    int firstIndex = Integer.parseInt(reader.readLine());
                    System.out.println("Введите конечный индекс: ");
                    int lastIndex = Integer.parseInt(reader.readLine());
                    System.out.println(ReverseString.indexReverse(src3, firstIndex, lastIndex));
                    break;
                default:
                    System.out.println("Ошибка. Попробуйте ещё раз");
                    break;
            }
        }
    }

    public static void offer() {
        System.out.println("Введите что бы вы хотели сделать: \n 1 - обычный реверс; \n" +
                " 2 - реверс по указанной подстроке в строке; \n 3 - весь предыдущий функционал + укажите " +
                "индексы начала и конца реверса; \n 0 - выход из программы.");

    }
}
