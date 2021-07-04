package com.nix.module_2.cities;

public class Edge {

    private Node startNode;
    private Node endNode;
    private int weight;

    public Edge(Node startNode, Node endNode, int weight) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "A=" + startNode.getName() +
                ", B=" + endNode.getName() +
                ", weight=" + weight +
                '}';
    }
}
