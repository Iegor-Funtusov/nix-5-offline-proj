package ua.practice.app.way;

class ShortestPath {

    public static int findShortestPath(int[][] matrix, int vertexes, int src, int destination) {
        int[] distance = new int[vertexes];

        boolean[] passedVertexes = new boolean[vertexes];

        for (int i = 0; i < vertexes; i++) {
            distance[i] = Integer.MAX_VALUE;
            passedVertexes[i] = false;
        }
        distance[src] = 0;
        for (int count = 0; count < vertexes - 1; count++) {
            int u = minDistance(distance, vertexes, passedVertexes);
            passedVertexes[u] = true;
            for (int v = 0; v < vertexes; v++)
                if (!passedVertexes[v] && matrix[u][v] != 0 && distance[u] != Integer.MAX_VALUE &&
                        distance[u] + matrix[u][v] < distance[v])
                    distance[v] = distance[u] + matrix[u][v];
        }
        return distance[destination];
    }

    private static int minDistance(int[] distance, int vertexes, boolean[] passedVertexes) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < vertexes; v++)
            if (!passedVertexes[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }

        return minIndex;
    }
}
