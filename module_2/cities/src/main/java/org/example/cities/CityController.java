package org.example.cities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CityController {
    private List<String> startEndNameCities;
    private final List<Integer> res;
    private int indexPaths;

    public CityController(){
        res = new ArrayList<>();
        indexPaths = 0;
    }

    public void exec(){
        try(
        PrintWriter writer = new PrintWriter(new FileWriter("module_2/cities/output.txt"))){
            computeCost(readCities());
            for (int i = 1; i < startEndNameCities.size()/2; i++) {
                computeCost(readCities());
            }
            System.out.println("res = " + res);
            for (Integer i : res){
                writer.println(i);
            }
            System.out.println("Result was written to output.txt ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<City> readCities() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("module_2/cities/input.txt"))) {
            List<City> cities = new ArrayList<>();
            List<List<Integer>> vertexEdges = new ArrayList<>();
            int numOfCity = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numOfCity; i++) {
                City c = new City();
                c.setName(reader.readLine());
                c.setIndex(i+1);
                cities.add(c);
                vertexEdges.add(parseEdge(reader));
            }
            linkedEdges(vertexEdges, cities);
            startEndNameCities = getStartEnd(reader);
            return cities;
        }
    }

    private List<Integer> parseEdge(BufferedReader reader) throws IOException {
        List<Integer> edge = new ArrayList<>();
        int numOfEdges = Integer.parseInt(reader.readLine());
        for (int j = 0; j < numOfEdges; j++) {
            String edgeStr = reader.readLine();
            for(String s : edgeStr.split(" ")){
                edge.add(Integer.parseInt(s));
            }
        }
        return edge;
    }

    private void linkedEdges(List<List<Integer>> vertexEdges, List<City> cities){
        for (int i = 0; i < vertexEdges.size(); i++) {
            List<Integer> l = vertexEdges.get(i);
            List<Edge> edges = new ArrayList<>();
            for (int j = 0; j < l.size(); j+=2) {
                edges.add(new Edge(l.get(j+1), cities.get(l.get(j)-1)));
            }
            City c = cities.get(i);
            c.setEdges(edges);
        }
    }

    private List<String> getStartEnd(BufferedReader reader) throws IOException {
        List<String> startEnd = new ArrayList<>();
        int numOfPaths = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfPaths; i++) {
            String startEndString = reader.readLine();
            String[] startEndNames = startEndString.split(" ");
            startEnd.add(startEndNames[0]);
            startEnd.add(startEndNames[1]);
        }
        return startEnd;
    }

    private void computeCost(List<City> cities){
        Dijkstra dijkstra = new Dijkstra(cities);
        City startCity = findCityByName(startEndNameCities.get(indexPaths), cities);
        City endCity = findCityByName(startEndNameCities.get(indexPaths+1), cities);
        int cost = dijkstra.minimalCost(startCity, endCity);
        res.add(cost);
        indexPaths+=2;
    }

    private City findCityByName(String name, List<City> cities){
        return cities
                .stream()
                .filter(c -> c.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
