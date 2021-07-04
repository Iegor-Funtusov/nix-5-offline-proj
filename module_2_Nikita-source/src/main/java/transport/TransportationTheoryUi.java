package transport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransportationTheoryUi {

    public static void transportInterface() throws IOException {
        File input = new File("input.txt");
        File output = new File("output.txt");
        BufferedReader reader = new BufferedReader(new FileReader(input));
        FileWriter writer = new FileWriter(output);
        int citiesCount = Integer.parseInt(reader.readLine());
        int neighboursCount = 0;
        List<String> citiesNames = new ArrayList<>();
        int[][] matrix = new int[citiesCount][citiesCount];

        for (int i = 0; i < citiesCount; i++) {
            for (int j = 0; j < citiesCount; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 300000;
                }
            }
        }

        for (int i = 0; i < citiesCount; i++) {
            citiesNames.add(reader.readLine());
            neighboursCount = Integer.parseInt(reader.readLine());
            for (int j = 0; j < neighboursCount; j++) {
                String[] str = reader.readLine().split(" ");
                matrix[i][Integer.parseInt(str[0]) - 1] = Integer.parseInt(str[1]);
            }
        }

        int waysCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < waysCount; i++) {
            String[] str = reader.readLine().split(" ");
            if (citiesNames.contains(str[0]) && citiesNames.contains(str[1])) {
                TransportationTheory transport = new TransportationTheory(citiesCount, matrix);
                int distance = transport.dijkstra(citiesNames.indexOf(str[0]), citiesNames.indexOf(str[1]));
                writer.write(distance +"\n");
            }else {
                System.out.println("ERROR!!! Cities does not exist!!!");
                writer.write("ERROR!!! Cities does not exist!!!\n");
                continue;
            }
        }

        reader.close();
        writer.close();
        System.out.println("Result was written to the file 'output.txt'. Please, check him");
    }
}
