package org.example.dao;

import org.example.entity.Solution;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SolutionDao {
    private final Connection connection;

    public SolutionDao(Connection connection) {
        this.connection = connection;
    }

    public List<Solution> read() {
        List<Solution> solutions = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM solutions");
            while (resultSet.next()) {
                solutions.add(new Solution(resultSet.getInt(1),
                        resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return solutions;
    }

    public void create(Collection<Solution> solutions) {
        try (PreparedStatement insertSolutions = connection.prepareStatement("INSERT IGNORE INTO solutions (solution_id, cost) VALUES (?, ?)")) {

            for (Solution solution : solutions) {
                insertSolutions.setInt(1, solution.getProblemId());
                insertSolutions.setInt(2, solution.getCost());

                insertSolutions.addBatch();
            }
            insertSolutions.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
