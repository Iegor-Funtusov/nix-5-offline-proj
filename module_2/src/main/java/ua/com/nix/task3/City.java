package ua.com.nix.task3;

import java.util.ArrayList;
import java.util.List;

public class City implements Comparable<City> {

    private int index;
    private String name;
    private final List<Paths> neighbors = new ArrayList<>();
    private int previousCity;
    private int minPath = 20000;

    public int getMinPath() {
        return minPath;
    }

    public void setMinPath(int minPath) {
        this.minPath = minPath;
    }

    public int getPreviousCity() {
        return previousCity;
    }

    public void setPreviousCity(int previousCity) {
        this.previousCity = previousCity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Paths> getNeighbors() {
        return neighbors;
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(Paths city){
        neighbors.add(city);
    }
    public City(String name, int index){
        this.name = name;
        this.index = index;
    }

    @Override
    public int compareTo(City o) {
        return Double.compare(this.minPath,o.minPath);
    }

    @Override
    public String toString() {
        return name;
    }
}
