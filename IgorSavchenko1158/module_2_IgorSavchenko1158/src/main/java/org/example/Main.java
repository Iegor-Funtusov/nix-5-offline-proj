package org.example;

import org.example.module2.DateParser;
import org.example.module2.UniqueFinder;
import org.example.module2.task3.CitiesParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            UI();
        }
    }

    public static void UI() {
        System.out.println("Select task to test:");
        System.out.println("1 - Date parser");
        System.out.println("2 - Unique string finder");
        System.out.println("3 - Find shortest distance between cities");
        System.out.println("Other to exit");

        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1": {
                dateParserUI(scanner);
                break;
            }
            case "2": {
                uniqueFinderUI(scanner);
                break;
            }
            case "3": {
                try {
                    shortestDistanceUI(scanner);
                } catch (IOException e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }
                break;
            }
            default: {
                System.exit(0);
                break;
            }
        }
    }

    private static void dateParserUI(Scanner scanner) {
        System.out.println("Enter dates separated by spaces in formats YYYY/MM/DD DD/MM/YYYY MM-DD-YYYY]");
        String input = scanner.nextLine();
        DateParser parser = new DateParser();
        String[] result = parser.convert(input.split("\\s+"));
        System.out.println("Dates converted:");
        System.out.println(Arrays.toString(result));
    }

    private static void uniqueFinderUI(Scanner scanner) {
        System.out.println("Enter names separated by spaces");
        String input = scanner.nextLine();
        UniqueFinder finder = new UniqueFinder();
        String result = finder.find(input.split("\\s+"));
        System.out.println("First unique name:");
        System.out.println(result);
    }

    private static void shortestDistanceUI(Scanner scanner) throws IOException {
        System.out.println("App will read from input.txt and write result to output.txt");
        Files.deleteIfExists(Path.of("output.txt"));
        CitiesParser citiesParser = new CitiesParser();
        citiesParser.parseAndOutputResult("input.txt", "output.txt");
        System.out.println("Done");
    }
}
