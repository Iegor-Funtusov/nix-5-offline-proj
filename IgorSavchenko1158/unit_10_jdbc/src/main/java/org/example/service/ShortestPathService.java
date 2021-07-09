package org.example.service;

import org.example.entity.Location;
import org.example.entity.Problem;
import org.example.entity.Route;
import org.example.entity.Solution;
import org.example.graph.GraphUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ShortestPathService {

    public void execute() {
        DriverManager.setLogWriter(new PrintWriter(System.out));

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM locations");
            List<Location> locations = new ArrayList<>();
            while (resultSet.next()) {
                locations.add(new Location(resultSet.getInt(1), resultSet.getString(2)));
            }

            resultSet = statement.executeQuery("SELECT to_id, from_id, cost FROM routes");
            List<Route> routes = new ArrayList<>();
            while (resultSet.next()) {
                routes.add(new Route(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)));
            }

            resultSet = statement.executeQuery("SELECT * FROM problems");
            List<Problem> problems = new ArrayList<>();
            while (resultSet.next()) {
                problems.add(new Problem(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)));
            }

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

            try (PreparedStatement insertSolutions = connection.prepareStatement("INSERT INTO solutions (solution_id, cost) VALUES (?, ?) ON CONFLICT DO NOTHING")) {

                for (Solution solution : solutions) {
                    insertSolutions.setInt(1, solution.getProblemId());
                    insertSolutions.setInt(2, solution.getCost());

                    insertSolutions.addBatch();
                }

                insertSolutions.executeBatch();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();

        try (InputStream input = ShortestPathService.class.getResourceAsStream("/jdbc.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        String url = properties.getProperty("url");
        return DriverManager.getConnection(url, properties);
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
