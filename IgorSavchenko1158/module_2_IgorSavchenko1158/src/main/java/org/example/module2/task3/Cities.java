package org.example.module2.task3;

import java.util.Arrays;

public class Cities {
    int[][] distances;
    int[][] cachedShortest;
    String[] cities;

    public Cities(int number) {
        distances = new int[number][number];
        cachedShortest = new int[number][number];
        cities = new String[number];
    }

    public void setCity(int index, String name) {
        cities[index] = name;
    }

    public void setDistance(int from, int to, int distance) {
        distances[from][to] = distance;
        distances[to][from] = distance;
    }

    public int findShortestDistance(String from, String to) {
        int indexFrom = -1;
        int indexTo = -1;
        for (int i = 0; i < cities.length && (indexFrom < 0 || indexTo < 0); i++) {
            if (cities[i].equals(from)) {
                indexFrom = i;
            } else if (cities[i].equals(to)) {
                indexTo = i;
            }
        }

        if (cachedShortest[indexFrom][indexTo] != 0) {
            return cachedShortest[indexFrom][indexTo];
        }
        int[] distances = GraphUtils.calculateDistance(this.distances, indexFrom);

        for (int i = 0; i < distances.length; i++) {
            cachedShortest[indexFrom][i] = distances[i];
            cachedShortest[i][indexFrom] = distances[i];
        }

        return cachedShortest[indexFrom][indexTo];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(cities)).append("\n");
        sb.append("Distances:").append("\n");
        for (int[] distance : distances) {
            sb.append(Arrays.toString(distance)).append("\n");
        }
        sb.append("Cached distances:").append("\n");
        for (int[] cachedDistance : cachedShortest) {
            sb.append(Arrays.toString(cachedDistance)).append("\n");
        }
        return sb.toString();
    }
}
