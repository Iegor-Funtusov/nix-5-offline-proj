package ua.com.nix.TravelingSalesmanProblem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SalesmanProblem {
    private static final int NUMBER_OF_CITIES = 200;

   public void run() throws IOException {
        File input = new File("module_2/src/main/resources/input.txt");
        File output = new File("module_2/src/main/resources/output.txt");
        BufferedReader reader = new BufferedReader(new FileReader(input));
        FileWriter writer = new FileWriter(output);
        String str = reader.readLine();
        int source = Integer.parseInt(str);

        for (int testIndex = 0; testIndex < source; testIndex++) {
            String[] cities = new String[NUMBER_OF_CITIES];
            str = reader.readLine();
            int countCities = Integer.parseInt(str);
            int matrixSize = countCities + 1;
            Matrix matrix = new Matrix(matrixSize);

            for (int cityIndex = 0; cityIndex < countCities; cityIndex++) {
                str = reader.readLine();
                String cityName = str;
                cities[cityIndex] = cityName;
                str = reader.readLine();
                int p = Integer.parseInt(str);

                for (int neighborIndex = 0; neighborIndex < p; neighborIndex++) {
                    str = reader.readLine();
                    String[] brokenLine = str.split(" ");
                    int cityToConnect = Integer.parseInt(brokenLine[0]);
                    int weightOfConnection = Integer.parseInt(brokenLine[1]);
                    matrix.settingEdge(cityIndex, cityToConnect, weightOfConnection);
                }
            }
            str = reader.readLine();
            int routesToFind = Integer.parseInt(str);
            for (int routesIndex = 0; routesIndex < routesToFind; routesIndex++) {
                str = reader.readLine();
                String[] cityNames = str.split(" ");
                String sourceNode = cityNames[0];
                String destinationNode = cityNames[1];
                List<String> list = new ArrayList<>();

                for (String s : cities) {
                    if (s != null) {
                        list.add(s);
                    }
                }

                cities = list.toArray(new String[0]);
                int startIndex = 0;
                int destinationIndex = 0;
                for (int i = 0; i < cities.length; i++)
                    if (sourceNode.equals(cities[i])) {
                        startIndex = i;
                        break;
                    }
                for (int i = 0; i < cities.length; i++) {
                    if (destinationNode.equals(cities[i])) {
                        destinationIndex = i;
                        break;
                    }
                }
                Integer[] distancesFromSource = matrix.gettingMinimumCost(startIndex);
                int destinationDistance = distancesFromSource[destinationIndex];
                writer.write(destinationDistance +"\n");
                writer.flush();
            }
        }
        reader.close();
        writer.close();
       System.out.println("Check file output.txt in resource,result in it");
    }
}