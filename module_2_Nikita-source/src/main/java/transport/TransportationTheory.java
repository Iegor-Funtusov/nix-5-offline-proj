package transport;

import static java.lang.Math.min;

public class TransportationTheory {
    private final int numberOfCities;
    private final int[][] cost;

    public TransportationTheory(int numberOfCities, int[][] cost) {
        this.numberOfCities = numberOfCities;
        this.cost = cost;
    }

    public int dijkstra(int startIndex, int endIndex) {
        int infinity = 300000;
        int[] distances = new int[numberOfCities];
        boolean[] visited = new boolean[numberOfCities];
        for (int i = 0; i < numberOfCities; i++) {
            distances[i] = infinity;
        }
        distances[startIndex] = 0;

        while (true) {
            int v = -1;
            for (int i = 0; i < numberOfCities; i++) {
                if (!visited[i] && distances[i] < infinity && (v == -1 || distances[v] > distances[i])) {
                    v = i;
                }
            }
            if (v == -1) {
                break;
            }
            visited[v] = true;
            for (int i = 0; i < numberOfCities; i++) {
                if (!visited[i] && cost[v][i] < infinity) {
                    distances[i] = min(distances[i], distances[v] + cost[v][i]);
                }
            }
        }
        return distances[endIndex];
    }
}
