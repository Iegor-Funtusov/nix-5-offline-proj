package com.nix.module_2.cities;

import java.util.HashMap;

public class Node {

    private String name;
//    private HashMap<Node, Integer> neighbors = null;


    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
//    public HashMap<Node, Integer> getNeighbors() {
//        return neighbors;
//    }
//
//    public void setNeighbors(HashMap<Node, Integer> neighbors) {
//        this.neighbors = neighbors;
//    }
}
