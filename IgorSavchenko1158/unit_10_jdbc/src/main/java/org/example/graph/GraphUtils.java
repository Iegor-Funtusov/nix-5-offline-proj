package org.example.graph;


import java.util.Arrays;

public class GraphUtils {

    //Dijkstra's algorithm
    public static int[] calculateDistance(int[][] graph, int src/*, int dest*/) {
        int[] distance = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        distance[src] = 0;
        for (int i = 0; i < graph.length - 1; i++) {
            int current = minDistance(distance, visited);
            visited[current] = true;
            for (int j = 0; j < graph.length; j++) {
                if (!visited[j]
                        && graph[current][j] != 0
                        && distance[current] != Integer.MAX_VALUE
                        && distance[current] + graph[current][j] < distance[j]) {
                    distance[j] = distance[current] + graph[current][j];
                }
            }
        }
        return distance;
    }

    private static int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] <= min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
