package com.lapchenko.module.third.optimal_route_finder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ShortestPathFinder {

    public static Graph calculateShortestPathFromSource(Graph graph, City source) {
        source.setDistance(0);
        Set<City> settledCities = new HashSet<>();
        Set<City> unsettledCities = new HashSet<>();
        unsettledCities.add(source);
        while (unsettledCities.size() != 0) {
            City currentCity = getLowestDistanceCity(unsettledCities);
            unsettledCities.remove(currentCity);
            for (var adjacencyPair :
                    currentCity.getAdjacentCities().entrySet()) {
                City adjacentCity = adjacencyPair.getKey();
                Integer edgeDistance = adjacencyPair.getValue();
                if (!settledCities.contains(adjacentCity)) {
                    calculateMinimumDistance(adjacentCity, edgeDistance, currentCity);
                    unsettledCities.add(adjacentCity);
                }
            }
            settledCities.add(currentCity);
        }
        return graph;
    }


    private static City getLowestDistanceCity(Set<City> unsettledCities) {
        City lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (City node : unsettledCities) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(City evaluationNode, Integer edgeDistance, City sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeDistance < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeDistance);
            LinkedList<City> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public static int printRouteCost(City city) {
        return city.getDistance();
    }
}
