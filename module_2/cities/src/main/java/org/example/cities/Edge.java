package org.example.cities;

public class Edge implements Comparable<Edge>{
    private int weight;
    private City nextCity;

    public Edge(int weight, City nextCity){
        this.weight = weight;
        this.nextCity = nextCity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public City getNextCity() {
        return nextCity;
    }

    public void setNextCity(City nextCity) {
        this.nextCity = nextCity;
    }

    @Override
    public int compareTo(Edge n) {
        return Integer.compare(weight, n.getWeight());
    }
}
