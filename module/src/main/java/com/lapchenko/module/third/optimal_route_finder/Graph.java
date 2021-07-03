package com.lapchenko.module.third.optimal_route_finder;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<City> cities = new HashSet<>();

    public void addNode(City cityA) {
        cities.add(cityA);
    }

    public Set<City> getNodes() {
        return cities;
    }

    public void setNodes(Set<City> cities) {
        this.cities = cities;
    }
}
