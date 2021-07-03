package ua.practice.app.way;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private final BufferedReader bufferedReader;
    private int countOfCities;
    private int countOfWays;
    private int[][] matrix;
    private ArrayList<String> names;
    private final String dirPath = System.getProperty("user.dir");

    public FileHandler() throws FileNotFoundException {
        this.bufferedReader = new BufferedReader(new FileReader(dirPath + "\\input.txt"));
    }

    public void processFile() {
        try {
            convertData();
            String s;
            String[] split;
            for (int i = 0; i < countOfWays; i++) {
                s = bufferedReader.readLine();
                split = s.split(" ");
                int src = names.indexOf(split[0]);
                int dest = names.indexOf(split[1]);
                int result = ShortestPath.findShortestPath(matrix, countOfCities, src, dest);
                writeResult(result);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    private void convertData() throws IOException {
        int num = Integer.parseInt(bufferedReader.readLine());
        if (num <= 10000)
            countOfCities = num;
        initMatrix();
        int r = Integer.parseInt(bufferedReader.readLine());
        if (r <= 100)
            countOfWays = r;
    }

    private void initMatrix() throws IOException {
        matrix = new int[countOfCities][countOfCities];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[countOfCities];
        }
        names = new ArrayList<>(countOfCities);
        String s;
        for (int i = 0; i < countOfCities; i++) {
            String name = bufferedReader.readLine();
            names.add(name);
            int countOfNeighbours = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < countOfNeighbours; j++) {
                s = bufferedReader.readLine();
                String[] nr = s.split(" ");
                int index = Integer.parseInt(nr[0]);
                int weight = Integer.parseInt(nr[1]);
                if (weight < 200000)
                    matrix[i][index - 1] = weight;
                else
                    throw new RuntimeException("Incorrect input");
            }
        }
    }

    private void writeResult(int result){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dirPath + "\\output.txt", true))) {
            bufferedWriter.write(result + "\n");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
