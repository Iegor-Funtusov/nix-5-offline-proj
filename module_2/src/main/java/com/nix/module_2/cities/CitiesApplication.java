package com.nix.module_2.cities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CitiesApplication {

    private static List<Node> nodes;
    private static List<Edge> edges;
    private static Set<Node> settledNodes;
    private static Set<Node> unSettledNodes;
    private static Map<Node, Integer> distance;

    private static final int MAX_WEIGHT = 200000;


    public static void run() {

        System.out.println("\n======\nCities\n======");

        nodes = new ArrayList<>();
        edges = new ArrayList<>();

        List<String> inputData = new ArrayList<>();
        try {
            Files.lines(Paths.get("input.txt"))
                    .forEach(inputData::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Input data loaded from file input.txt");

        for (int i = 0; i < Integer.parseInt(inputData.get(0)); i++) {
            nodes.add(new Node());
        }

        int pointer = 1;

        for (Node currentNode : nodes) {
            currentNode.setName(inputData.get(pointer));
            pointer++;
            for (int j = 0; j < Integer.parseInt(inputData.get(pointer)); j++) {
                String[] parameters = inputData.get(pointer + j + 1).split(" ");
                edges.add(new Edge(
                        currentNode,
                        nodes.get(Integer.parseInt(parameters[0]) - 1),
                        Integer.parseInt(parameters[1])
                ));
            }
            pointer += Integer.parseInt(inputData.get(pointer)) + 1;
        }

        String output = "";
        for (int i = 0; i < Integer.parseInt(inputData.get(pointer)); i++) {
            String[] nodeNames = inputData.get(pointer + i + 1).split(" ");
            int shortestDistance = findShortestWay(findNodeByName(nodeNames[0]),
                    findNodeByName(nodeNames[1]));
            output += shortestDistance + "\n";
        }

        output = output.trim();

        try(FileWriter fw = new FileWriter("output.txt")) {
            fw.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Result is written to file output.txt");

    }

    private static Node findNodeByName(String name) {
        for (Node node : nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    private static int findShortestWay(Node firstNode, Node secondNode) {
        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        distance.put(firstNode, 0);
        unSettledNodes.add(firstNode);
        while (unSettledNodes.size() > 0) {
            Node node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }

        return distance.get(secondNode);
    }

    private static void findMinimalDistances(Node node) {
        List<Node> adjacentNodes = getAdjacentNodes(node);
        for (Node target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                unSettledNodes.add(target);
            }
        }
    }

    private static int getDistance(Node node, Node target) {
        for (Edge edge : edges) {
            if (edge.getStartNode().equals(node) &&
                edge.getEndNode().equals(target))
                return edge.getWeight();
        }
        throw new RuntimeException("Something gone wrong");
    }

    private static List<Node> getAdjacentNodes(Node node) {
        List<Node> adjacentNodes = new ArrayList<>();
        for (Edge edge : edges)
            if (edge.getStartNode().equals(node) &&
                !isSettled(edge.getEndNode()))
                adjacentNodes.add(edge.getEndNode());
        return adjacentNodes;
    }

    private static Node getMinimum(Set<Node> nodes) {
        Node minimum = null;
        for (Node node : nodes)
            if (minimum == null)
                minimum = node;
            else if (getShortestDistance(node) < getShortestDistance(minimum))
                minimum = node;

        return minimum;
    }

    private static boolean isSettled(Node node) {
        return settledNodes.contains(node);
    }

    private static int getShortestDistance(Node target) {
        Integer d = distance.get(target);
        if (d == null)
            return MAX_WEIGHT;
        else
            return d;
    }

}
