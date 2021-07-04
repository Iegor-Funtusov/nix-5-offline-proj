package org.example.cities;

import java.util.List;

public class Dijkstra {
    private final List<City> cities;

    public Dijkstra(List<City> cities) {
        this.cities = cities;
    }

    public int minimalCost(City startCity, City endCity){
        startCity.setWeight(0);
        findShortestPath(endCity);
        return endCity.getWeight();
    }

    private void findShortestPath(City endCity){
        while(true) {
            City currentCity = getMinWeightCity();

            if(currentCity.equals(endCity)){
                return;
            }

            List<Edge> edges = currentCity.getEdges();
            for(Edge e : edges){
                City nextCity = e.getNextCity();
                if (currentCity.getWeight() + e.getWeight() < nextCity.getWeight()) {
                    nextCity.setWeight(currentCity.getWeight() + e.getWeight());
                    nextCity.setFromCity(currentCity);
                }
            }
            currentCity.setVisited(true);
        }
    }

    private City getMinWeightCity(){
        return cities
                .stream()
                .filter(c -> !c.isVisited())
                .min(City::compareTo)
                .orElseThrow();
    }
}
