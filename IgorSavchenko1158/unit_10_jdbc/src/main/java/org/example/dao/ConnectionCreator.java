package org.example.dao;

import org.example.service.ShortestPathService;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static final String PROPERTIES = "/jdbc.properties";
    private final Properties properties;
    private final String url;

    public ConnectionCreator() {
        properties = new Properties();
        try (InputStream input = getClass().getResourceAsStream(PROPERTIES)) {
            properties.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        url = properties.getProperty("url");
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
