package services.cities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InputFile {

    private final String INPUT = "input.txt";

    public InputFile() {
        Path path = Paths.get("results");
        try {
            if (!path.toFile().exists()) {
                Files.createDirectory(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readCities() {
        List<String> input = new ArrayList<>();
        List<String> citiesList = new ArrayList<>();
        System.out.println("Enter the number of cities");
        String cities = number();
        while (Integer.parseInt(cities) > 10000 && Integer.parseInt((cities)) == 1) {
            System.out.println("The number of cities cannot be more than 10,000 and the city cannot be alone.");
            cities = number();
        }
        input.add(cities);
        for (int i = 0; i < Integer.parseInt(cities); i++) {
            System.out.println("Enter a city name");
            String city = checkCity(citiesList);
            citiesList.add(city);
            input.add(city);
            String ways;
            System.out.println("Input number of ways between cities");
            ways = number();
            while (Integer.parseInt(ways) >= Integer.parseInt(cities)) {
                System.out.println("There should be fewer ways than cities" + "(" + Integer.parseInt(cities) + ")");
                ways = number();
            }
            input.add(ways);
            System.out.println("Input index of city and distance to it separated by space\n");
            List<String> similar = new ArrayList<>();
            for (int j = 0; j < Integer.parseInt(ways); j++) {
                System.out.println("Input " + (j + 1) + "way");
                String way = waysBetweenCities(i + 1, Integer.parseInt(cities), similar);
                similar.add(way);
                input.add(way);
            }
        }
        System.out.println("Enter the number of ways between the cities you would like to know the distance between");
        String ways = number();
        while (Integer.parseInt(ways) > 100) {
            System.out.println("Ways can't be more than 100. Try again");
            ways = number();
        }
        input.add(ways);
        System.out.println("Enter the cities where you would like to know the distance");
        IntStream.range(0, Integer.parseInt(ways))
                .forEach(i -> {
                    System.out.println((i + 1) + " Way");
                    String link = findDistance(citiesList);
                    input.add(link);
                });
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT, true))) {
            for (String in : input) {
                writer.append(in).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    private String number() {
        Scanner scanner = new Scanner(System.in);
        int numb;
        String number;
        try {
            numb = scanner.nextInt();
            if (numb <= 0) {
                System.out.println("Input positive number. Try again");
                return number();
            }
            number = String.valueOf(numb);
            return number;
        } catch (InputMismatchException e) {
            System.out.println("Input only one number. Try again");
            return number();
        }
    }

    private String checkCity(List<String> cities) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        for (int i = 0; i < cities.size(); i++) {
            if (city.equals(cities.get(i))) {
                System.out.println("Such a city already exists. Enter another");
                return checkCity(cities);
            }
        }
        return city;
    }

    private String waysBetweenCities(int index, int amount, List<String> similar) {
        Scanner scanner = new Scanner(System.in);
        String link = scanner.nextLine();
        String[] parts = link.split(" ");
        if (parts.length == 2) {
            for (int i = 0; i < 2; i++) {
                try {
                    int n = Integer.parseInt(parts[i]);
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Incorrect input. Input should only contain 2 numbers separated by a space");
                    return waysBetweenCities(index, amount, similar);
                }
            }

            if (Integer.parseInt(parts[0]) > amount || Integer.parseInt(parts[0]) <= 0) {
                System.out.println("IThe index cannot be less than or equal to 0 and cannot be greater than the number of cities");
                return waysBetweenCities(index, amount, similar);
            }

            if (index == Integer.parseInt(parts[0])) {
                System.out.println("You cannot set a distance for the similar city");
                return waysBetweenCities(index, amount, similar);
            }

            for (int i = 0; i < similar.size(); i++) {
                String[] part = similar.get(i).split(" ");
                if (part[0].equals(parts[0])) {
                    System.out.println("Such way already exists. Input new way");
                    return waysBetweenCities(index, amount, similar);
                }
            }
            return link;
        } else {
            System.out.println("Incorrect input. Input should only contain 2 numbers separated by a space");
            return waysBetweenCities(index, amount, similar);
        }
    }

    private String findDistance(List<String> Cities) {
        Scanner scanner = new Scanner(System.in);
        String cities = scanner.nextLine();
        String[] temp = cities.split(" ");
        if (temp.length != 2) {
            System.out.println("Enter only 2 cities separated by a space");
            return findDistance(Cities);
        }
        boolean flag = false;
        for (int i = 0; i < 2; i++) {
            for (String city : Cities) {
                if (temp[i].equals(city)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("City " + temp[i] + " not found. Try again");
                return findDistance(Cities);
            }
            flag = false;
        }
        return cities;
    }
}
