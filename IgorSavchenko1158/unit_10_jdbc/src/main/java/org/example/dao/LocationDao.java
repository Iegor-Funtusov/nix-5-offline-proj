package org.example.dao;

import org.example.entity.Location;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocationDao {
    private final Connection connection;

    public LocationDao(Connection connection) {
        this.connection = connection;
    }

    public List<Location> read() {
        List<Location> locations = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM locations");
            while (resultSet.next()) {
                locations.add(new Location(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locations;
    }

}
