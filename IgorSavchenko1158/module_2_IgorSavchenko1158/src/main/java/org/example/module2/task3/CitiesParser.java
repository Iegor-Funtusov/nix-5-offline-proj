package org.example.module2.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CitiesParser {

    public void parseAndOutputResult(String inputFile, String outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        Cities cities = parseCities(reader);
        List<String[]> paths = parsePaths(reader);
        reader.close();

        int[] pathLengths = new int[paths.size()];
        for (int i = 0; i < paths.size(); i++) {
            pathLengths[i] = cities.findShortestDistance(paths.get(i)[0], paths.get(i)[1]);
        }

        writeResult(outputFile, pathLengths);
    }

    private Cities parseCities(BufferedReader reader) throws IOException {
        int numberOfCities = Integer.parseInt(reader.readLine());
        Cities cities = new Cities(numberOfCities);

        for (int i = 0; i < numberOfCities; i++) {
            String cityName = reader.readLine();
            cities.setCity(i, cityName);

            int numberOfNeighbors = Integer.parseInt(reader.readLine());
            for (int j = 0; j < numberOfNeighbors; j++) {
                String[] neighborCost = reader.readLine().split("\\s+");
                cities.setDistance(i, Integer.parseInt(neighborCost[0]) - 1, Integer.parseInt(neighborCost[1]));
            }
        }
        return cities;
    }

    private List<String[]> parsePaths(BufferedReader reader) throws IOException {
        int numberOfPaths = Integer.parseInt(reader.readLine());
        List<String[]> paths = new ArrayList<>(numberOfPaths);
        for (int i = 0; i < numberOfPaths; i++) {
            paths.add(reader.readLine().split("\\s+"));
        }
        return paths;
    }

    private void writeResult(String outputFile, int[] result) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        for (int i : result) {
            writer.write(Integer.toString(i));
            writer.newLine();
        }
        writer.close();
    }
}
