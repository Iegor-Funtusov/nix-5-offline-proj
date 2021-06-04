package ua.com.nix;

import ua.com.nix.operations_with_date.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MainLabel:
        while (true) {
            System.out.println("""
                    Enter task:
                    1 -> Difference between dates
                    2 -> Adding to date
                    3 -> Subtraction from date
                    4 -> Сomparison from date
                    0 -> Exit""");

            String choice = reader.readLine();
            switch (choice) {
                case "1": {
                    new Difference().differ();
                    break;
                }
                case "2": {
                    new Addition().add();
                    break;
                }
                case "3": {
                    new Subtraction().substract();
                    break;
                }
                case "4": {
                    new Comparation().compare();
                    break;
                }
                case "0": {
                    break MainLabel;
                }

            }
        }
    }
}
