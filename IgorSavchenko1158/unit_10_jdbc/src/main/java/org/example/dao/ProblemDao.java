package org.example.dao;

import org.example.entity.Problem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProblemDao {
    private final Connection connection;

    public ProblemDao(Connection connection) {
        this.connection = connection;
    }

    public List<Problem> read() {
        List<Problem> problems = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM problems");
            while (resultSet.next()) {
                problems.add(new Problem(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return problems;
    }

    public List<Problem> readUnsolved() {
        List<Problem> problems = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT p.* FROM problems p LEFT JOIN solutions s ON p.problem_id = s.solution_id WHERE s.solution_id IS NULL");
            while (resultSet.next()) {
                problems.add(new Problem(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return problems;
    }
}
