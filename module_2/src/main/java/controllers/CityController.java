package controllers;

import constants.FileConstants;
import services.cities.CountDistance;
import services.cities.InputFile;
import services.cities.OutputFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CityController {
    public void printCities() {
        Scanner scanner = new Scanner(System.in);
        InputFile inputControl = new InputFile();
        OutputFile outputControl = new OutputFile();
        CountDistance distance = new CountDistance();
        System.out.println("How do you want to enter?\n" +
                "1 -> Enter by yourself\n" +
                "2 -> Enter through a file");
        String choice = scanner.nextLine();
        boolean check = true;
        while (check) {
            switch (choice) {
                case "1":
                    inputControl.readCities();
                    try {
                        Path path = Paths.get("input.txt");
                        List<String> input = Files.readAllLines(path);
                        int[] result = distance.distance(input);
                        outputControl.output(input, result, "output.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    check = false;
                    break;
                case "2":
                    cities();
                    check = false;
                    break;
                default:
                    System.out.println("Wrong input. Use numbers");
            }
        }
    }

    private void cities() {
        OutputFile output = new OutputFile();
        CountDistance distance = new CountDistance();
        try {
            Path path = Paths.get(FileConstants.CITY_INPUT.getPath());
            List<String> input = Files.readAllLines(path);
            int[] results = distance.distance(input);
            output.output(input, results, FileConstants.CITY_OUTPUT.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
