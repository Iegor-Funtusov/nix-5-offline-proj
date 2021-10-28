package org.example.service;

import org.example.dao.*;
import org.example.entity.Location;
import org.example.entity.Problem;
import org.example.entity.Route;
import org.example.entity.Solution;
import org.example.graph.GraphUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShortestPathService {

    public void execute() {

        try (Connection connection = new ConnectionCreator().getConnection()) {

            LocationDao locationDao = new LocationDao(connection);
            List<Location> locations = locationDao.read();

            RouteDao routeDao = new RouteDao(connection);
            List<Route> routes = routeDao.read();

            ProblemDao problemDao = new ProblemDao(connection);
            List<Problem> unsolvedProblems = problemDao.readUnsolved();
            if (!unsolvedProblems.isEmpty()) {
                List<Solution> solutions = solveProblems(locations, routes, unsolvedProblems);
                new SolutionDao(connection).create(solutions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Solution> solveProblems(List<Location> locations, List<Route> routes, List<Problem> problems) {
        List<Solution> solutions = new ArrayList<>();
        int[][] matrix = buildAdjacencyMatrix(locations, routes);
        for (Problem problem : problems) {
            int fromIndex = -1;
            int toIndex = -1;
            for (int i = 0; i < locations.size(); i++) {
                if (locations.get(i).getId() == problem.getFromId()) {
                    fromIndex = i;
                } else if (locations.get(i).getId() == problem.getToId()) {
                    toIndex = i;
                }
            }
            int[] paths = GraphUtils.calculateDistance(matrix, fromIndex);
            solutions.add(new Solution(problem.getId(), paths[toIndex]));
        }
        return solutions;
    }

    private int[][] buildAdjacencyMatrix(List<Location> locations, List<Route> routes) {

        int[][] matrix = new int[locations.size()][locations.size()];

        for (Route route : routes) {
            int fromIndex = -1;
            int toIndex = -1;
            for (int i = 0; i < locations.size(); i++) {
                if (locations.get(i).getId() == route.getFromId()) {
                    fromIndex = i;
                } else if (locations.get(i).getId() == route.getToId()) {
                    toIndex = i;
                }
            }
            matrix[fromIndex][toIndex] = route.getCost();
            matrix[toIndex][fromIndex] = route.getCost(); //Presuming graph is undirected
        }

        return matrix;
    }
}
