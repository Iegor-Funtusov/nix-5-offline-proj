package ua.com.nix.task3;

import java.io.*;
import java.util.Objects;

public class PathTask {

    public void run() {
        System.out.println("-------------WELCOME TO THE TASK 3 - FIND MINIMAL PATH-------------");
        System.out.println("-------------INPUT VALUES IN module_2/src/main/resources/input.txt-------------");

        File file = new File("src/main/resources/input.txt");
        CityFactory factory = CityFactory.getInstance();
        StringBuilder builder = new StringBuilder(10);

        if (file.exists()) {
            FileReader reader = null;
            try {
                reader = new FileReader(file);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            try (BufferedReader bufferedReader = new BufferedReader(Objects.requireNonNull(reader))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    builder.append(line).append("\n");
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        String[] massive = builder.toString().split("\n");
        int countCities = Integer.parseInt(massive[0]);
        int index = 1;

        for (int i = 1; i < massive.length; i++) {
            if (countCities != 0) {
                City city = new City(massive[i], index);
                int countNeighbor = Integer.parseInt(massive[++i]);
                while (countNeighbor != 0) {
                    String[] elements = massive[++i].split(" ");
                    city.addNeighbor(new Paths(Integer.parseInt(elements[0]), Integer.parseInt(elements[1])));
                    countNeighbor--;
                }
                factory.addCity(city);
                countCities--;
                index++;
            } else {
                int countPaths = Integer.parseInt(massive[i]);
                while (countPaths != 0) {
                    file = new File("src/main/resources/output.txt");
                    String[] cities = massive[++i].split(" ");
                    if (file.exists()) {

                        FileWriter writer = null;
                        try {
                            writer = new FileWriter(file, true);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        try (BufferedWriter bufferedWriter = new BufferedWriter(Objects.requireNonNull(writer))) {

                            bufferedWriter.write(FindMinPathBetweenTwoNodes.
                                    findPah(factory.getCityByName(cities[0]).getIndex(),
                                            factory.getCityByName(cities[1]).getIndex()) + "\n");
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        countPaths--;
                    }
                }
            }
        }
        System.out.println(factory.getCount());
        System.out.println("-------------RESULT OF TASK 3 IS IN module_2/src/main/resources/output.txt-------------");
    }

}
