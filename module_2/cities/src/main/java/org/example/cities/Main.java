package org.example.cities;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        City g = new City();
        g.setName("gdansk");
        g.setIndex(1);
        City b = new City();
        b.setName("bydgaszcz");
        b.setIndex(2);
        City t = new City();
        t.setName("torun");
        t.setIndex(3);
        City w = new City();
        w.setName("warszawa");
        w.setIndex(4);

        List<Edge> gN = new ArrayList<>();
        gN.add(new Edge(1, b));
        gN.add(new Edge(3, t));
        g.setEdges(gN);

        List<Edge> bN = new ArrayList<>();
        bN.add(new Edge(1, g));
        bN.add(new Edge(1, t));
        bN.add(new Edge(4, w));
        b.setEdges(bN);

        List<Edge> tN = new ArrayList<>();
        tN.add(new Edge(3, g));
        tN.add(new Edge(1, b));
        tN.add(new Edge(1, w));
        t.setEdges(tN);

        List<Edge> wN = new ArrayList<>();
        wN.add(new Edge(4, b));
        wN.add(new Edge(1, t));
        w.setEdges(wN);

        List<City> cities = new ArrayList<>();
        cities.add(g);
        cities.add(b);
        cities.add(t);
        cities.add(w);

        Dijkstra dijkstra = new Dijkstra(cities);
        System.out.println("From bydgaszcz to warszawa: " + dijkstra.minimalCost(b, w));
    }
}

