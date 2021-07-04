package org.example.cities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CityController {
    private List<City> cities = new ArrayList<>();

    public void exec(){
        try(BufferedReader reader = new BufferedReader(new FileReader("module_2/cities/input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("module_2/cities/output.txt"))){
            cities = readCities(reader);
            List<Integer> res = getCosts(reader);
            System.out.println("res = " + res);
            for (Integer i : res){
                writer.println(i);
            }
            System.out.println("Result was writed in output.txt ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<City> readCities(BufferedReader reader) throws IOException {
        List<City> cities = new ArrayList<>();
        List<List<Integer>> tempEdges = new ArrayList<>();
        int numOfCity = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numOfCity; i++) {
            City c = new City();
            c.setName(reader.readLine());
            c.setIndex(i+1);
            cities.add(c);
            List<Integer> indexEdge = new ArrayList<>();
            int numOfEdges = Integer.parseInt(reader.readLine());
            for (int j = 0; j < numOfEdges; j++) {
                String edge = reader.readLine();
                for(String s : edge.split(" ")){
                    indexEdge.add(Integer.parseInt(s));
                }
            }
            tempEdges.add(indexEdge);
        }
        for (int i = 0; i < tempEdges.size(); i++) {
            List<Integer> l = tempEdges.get(i);
            List<Edge> edges = new ArrayList<>();
            for (int j = 0; j < l.size(); j+=2) {
                edges.add(new Edge(l.get(j+1), cities.get(l.get(j)-1)));
            }
            City c = cities.get(i);
            c.setEdges(edges);
        }
        return cities;
    }

    private List<Integer> getCosts(BufferedReader reader) throws IOException {
        List<Integer> res = new ArrayList<>();
        int numOfPaths = Integer.parseInt(reader.readLine());
        Dijkstra dijkstra = new Dijkstra(cities);
        for (int i = 0; i < numOfPaths; i++) {
            String startEndString = reader.readLine();
            String[] startEndNames = startEndString.split(" ");
            City startCity = findCityByName(startEndNames[0], cities);
            City endCity = findCityByName(startEndNames[1], cities);
            res.add(dijkstra.minimalCost(startCity, endCity));
        }
        return res;
    }

    private City findCityByName(String name, List<City> cities){
        return cities
                .stream()
                .filter(c -> c.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
