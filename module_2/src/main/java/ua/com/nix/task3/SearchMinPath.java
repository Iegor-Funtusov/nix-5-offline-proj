package ua.com.nix.task3;

import java.util.PriorityQueue;

public final class SearchMinPath {

    public static void computePaths(City source)
    {
        CityFactory factory = CityFactory.getInstance();
        source.setMinPath(0);
        PriorityQueue<City> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            City startCity = vertexQueue.poll();

            for (Paths path : startCity.getNeighbors())
            {
                City neighbor = factory.getCity(path.getNeighbor());
                int cost = path.getCost();
                int newDistance = startCity.getMinPath() + cost;
                if (newDistance < neighbor.getMinPath()) {
                    vertexQueue.remove(neighbor);

                    neighbor.setMinPath(newDistance);
                    neighbor.setPreviousCity(startCity.getIndex());
                    vertexQueue.add(neighbor);
                }
            }
        }
    }

}
