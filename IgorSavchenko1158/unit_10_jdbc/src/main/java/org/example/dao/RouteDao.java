package org.example.dao;

import org.example.entity.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RouteDao {
    private final Connection connection;

    public RouteDao(Connection connection) {
        this.connection = connection;
    }

    public List<Route> read() {
        List<Route> routes = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM routes");
            while (resultSet.next()) {
                routes.add(new Route(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return routes;
    }
}
