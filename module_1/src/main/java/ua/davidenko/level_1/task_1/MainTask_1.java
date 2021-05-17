package ua.davidenko.level_1.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTask_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" Choose option :\n" +
                " 1 - Input Array, 2 - Random generate Array ");
        String option = br.readLine();
        switch (option) {
            case "1":
                UniqueSymbolArray.countOfUniqueSymbol(ArrayCreating.userArray());
                break;
            case "2":
                UniqueSymbolArray.countOfUniqueSymbol(ArrayCreating.randomArray());
        }
    }
}

