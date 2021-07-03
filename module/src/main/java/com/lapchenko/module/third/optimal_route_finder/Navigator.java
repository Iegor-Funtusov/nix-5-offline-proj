package com.lapchenko.module.third.optimal_route_finder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Navigator {
    private BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
    private BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
    private Graph cityMap = new Graph();
    private List<City> listOfCities = new ArrayList();



    public Navigator() throws IOException {
    }

    public void start() throws IOException {
        buildGraph();
        findPaths();
    }

    public void buildGraph() throws IOException {
        int amountOfCities = Integer.parseInt(reader.readLine());
        for (int i = 0; i < amountOfCities; i++) {
            listOfCities.add(new City("Temp name" + i));
        }
        for (int i = 0; i < amountOfCities; i++) {
            listOfCities.get(i).setCityName(reader.readLine());
            int amountOfCityNeighbours = Integer.parseInt(reader.readLine());
            for (int j = 0; j < amountOfCityNeighbours; j++) {
                String[] neighbourAndRouteCost = reader.readLine().split(" ");
                int neighbour = Integer.parseInt(neighbourAndRouteCost[0]);
                int cost = Integer.parseInt(neighbourAndRouteCost[1]);
                addNeighbour(i, neighbour, cost);
            }
        }
        addCitiesToGraph();
    }

    public void findPaths() throws IOException {
        int amountOfPaths = Integer.parseInt(reader.readLine());
        for (int i = 0; i < amountOfPaths; i++) {
            String[] pathsBetween = reader.readLine().split(" ");
            int firstCityId = -1, secondCityId = -1;
            for (int j = 0; j < listOfCities.size(); j++) {
                if(listOfCities.get(j).getCityName().equals(pathsBetween[0])) {
                    firstCityId = j;
                }
                if(listOfCities.get(j).getCityName().equals(pathsBetween[1])) {
                    secondCityId = j;
                }
            }
                Graph dijkstraGraph = ShortestPathFinder.calculateShortestPathFromSource(cityMap, listOfCities.get(firstCityId));
            writer.write(ShortestPathFinder.printRouteCost(listOfCities.get(secondCityId)) + "\n");
            writer.flush();
        }
    }

    private void addNeighbour(int neighbourIndex, int neighbour, int cost) {
        listOfCities.get(neighbourIndex).addDestination(listOfCities.get(neighbour -1), cost);
    }

    private void addCitiesToGraph() {
        for (int i = 0; i < listOfCities.size(); i++) {
            cityMap.addNode(listOfCities.get(i));
        }
    }
}
