package ua.com.alevel.path;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PathCost {

    private static List<String> citi;
    private static int[][] citiesPaths;
    private static String[][] paths;

    public static void findPath() {
        File outputFile = new File("output.txt");
        try {
            outputFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        input();
        List<String> foundedPaths = paths()
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String s : foundedPaths) {
                bw.write(s + System.lineSeparator());
            }
            System.out.println("The result was written to 'output.txt'!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int shortestPath(int start, int end) {
        boolean[] visited = new boolean[citi.size()];
        int[] dist = new int[citi.size()];
        Arrays.fill(dist, 200000);
        dist[start] = 0;
        for (int i = 0; i < citi.size(); i++) {
            int count = -1;
            int countDis = 200000;
            for (int j = 0; j < citi.size(); j++) {
                if (visited[i] || countDis < dist[i]) {
                    continue;
                }
                count = i;
                countDis = dist[i];
            }
            if (count == -1) {
                break;
            }
            for (int k = 0; k < citi.size(); k++) {
                int weight = citiesPaths[count][k];
                if (citiesPaths[count][k] != 0 && dist[count] + weight < dist[k]) {
                    dist[k] = dist[count] + weight;
                }
            }
            visited[count] = true;
        }
        return dist[end];
    }

    private static List<Integer> paths() {
        List<Integer> result = new ArrayList<>();
        for (String[] path : paths) {
            result.add(shortestPath(citi.indexOf(path[0]), citi.indexOf(path[1])));
        }
        return result;
    }

    private static void input(){
        File inputFile = new File("input.txt");
        try (FileReader fr = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(fr)) {
            int cities = Integer.parseInt(br.readLine());
            citi = new ArrayList<>();
            citiesPaths = new int[cities][cities];
            for (int i = 0; i < cities; i++) {
                citi.add(br.readLine());
                int neighbors = Integer.parseInt(br.readLine());
                for (int j = 0; j < neighbors; j++) {
                    String[] neighbor = br.readLine().split(" ");
                    int n = Integer.parseInt(neighbor[0]);
                    int pathCost = Integer.parseInt(neighbor[1]);

                    citiesPaths[i][n - 1] = pathCost;
                }
            }
            int numberPaths = Integer.parseInt(br.readLine());
            paths = new String[numberPaths][2];
            for (int i = 0; i < numberPaths; i++) {
                String[] c = br.readLine().split(" ");
                paths[i][0] = c[0];
                paths[i][1] = c[1];
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}