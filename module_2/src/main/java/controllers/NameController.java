package controllers;

import constants.FileConstants;
import services.UniqueName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NameController {
    public void printName() {
        Scanner sc = new Scanner(System.in);
        UniqueName name = new UniqueName();
        List<String> names = new ArrayList<>();
        System.out.println("Would you like to input names yourself or see example?\n" +
                "1 -> yourself\n" +
                "2 -> example");
        String choice = sc.nextLine();
        boolean correct = true;
        while (correct) {
            switch (choice) {
                case "1":
                    String flag = "";
                    while (!flag.equals("0")) {
                        System.out.println("Input name (input \"0\" for end of inputting):");
                        flag = sc.nextLine();
                        names.add(flag);
                    }
                    String uniqueName = name.uniqueName(names);
                    System.out.println("First unique name: " + uniqueName);
                    correct = false;
                    break;
                case "2":
                    namesEx();
                    correct = false;
                    break;
                default:
                    System.out.println("Wrong input. Try again");
            }
        }
    }

    private void namesEx() {
        Path path = Paths.get(FileConstants.NAMES.getPath());
        UniqueName Name = new UniqueName();
        try {
            List<String> names = Files.readAllLines(path);
            System.out.println("All names:");
            for (String name : names) {
                System.out.println(name);
            }
            String uniqueName = Name.uniqueName(names);
            System.out.println("\nFirst unique name: " + uniqueName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
