package nix.com.main;

import nix.com.date_parse.DateParser;
import nix.com.find_way.FindWay;
import nix.com.unique_name.UniqueName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ModuleMain {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int choose = 0;

        while (choose >= 0) {
            showMenu();

            try {
                choose = Integer.parseInt(reader.readLine());
                if (choose == 0) {
                    return;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Wong input");
            }

            switch (choose) {
                case 1:
                    System.out.println(new DateParser().parseDate()); break;
                case 2:
                    System.out.println("Enter mode of method (1 - with stream; 2 - with for)");
                    try {
                        choose = Integer.parseInt(reader.readLine());
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Wong input");
                    }
                    if (choose == 1) {
                        System.out.println(new UniqueName().readFromFile(1));
                    } else if (choose == 2) {
                        System.out.println(new UniqueName().readFromFile(2));
                    } else {
                        System.out.println("Wrong input");
                    }
                    break;
                case 3: new FindWay(); break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("All operations work with files");
        System.out.println("1. Date parse (Enter needed dates in file dates.txt)");
        System.out.println("2. Find unique name (Enter needed names in file names.txt)");
        System.out.println("3. Find way (Enter needed cities in file input.txt) result write in output.txt");
        System.out.println("0. Exit");
    }
}
