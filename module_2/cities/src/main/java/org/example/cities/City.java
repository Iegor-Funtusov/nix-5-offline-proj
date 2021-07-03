package org.example.cities;

import java.util.List;
import java.util.Objects;

public class City implements Comparable<City>{
    private String name;
    private int index;
    private int weight = 10000;
    private City fromCity;
    private boolean isVisited = false;
    private List<Edge> edges;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public City getFromCity() {
        return fromCity;
    }

    public void setFromCity(City fromCity) {
        this.fromCity = fromCity;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return index == city.index && name.equals(city.name) && Objects.equals(edges, city.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, index, edges);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(City c) {
        return Integer.compare(weight, c.getWeight());
    }
}
