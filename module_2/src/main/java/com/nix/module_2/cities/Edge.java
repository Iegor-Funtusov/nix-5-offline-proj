package com.nix.module_2.cities;

public class Edge {

    private Node startNode;
    private Node endNode;
    private int weight;

    public Edge() {
    }

    public Edge(Node startNode, Node endNode, int weight) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
