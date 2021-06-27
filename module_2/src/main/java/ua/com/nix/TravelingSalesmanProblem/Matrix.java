package ua.com.nix.TravelingSalesmanProblem;

import static java.lang.Math.min;
import static java.util.Arrays.fill;


public class Matrix {
    private final int INFINITY = 888;
    private int[][] cost;


    public Matrix(int vertices) {
        cost = new int[vertices][vertices];
    }


    public void settingEdge(int i, int j, int weight) {
        cost[i][j] = weight;
    }

    private int getCost(int i, int j) {
        if (i == j) {
            return 0;
        }
        if (cost[i][j] == 0) {
            return INFINITY;
        }
        return cost[i][j];
    }


    private int gettingUnassignedVertex(Integer[] result, boolean[] visited) {
        int best = -1;
        for (int i = 0; i < cost.length; i++) {
            if (!visited[i] && ((best < 0) || (result[i] < result[best]))) {
                best = i;
            }
        }
        return best;
    }

    public Integer[] gettingMinimumCost(int startIndex) {
        boolean[] visited = new boolean[cost.length];
        Integer[] result = new Integer[cost.length];
        fill(result, INFINITY);
        result[startIndex] = startIndex;

        for (int[] aCost : cost) {
            int city = gettingUnassignedVertex(result, visited);
            visited[city] = true;
            for (int j = 0; j < cost.length; j++) {
                result[j] = min(result[j], result[city] + getCost(city, j));
            }
        }
        return result;
    }
}