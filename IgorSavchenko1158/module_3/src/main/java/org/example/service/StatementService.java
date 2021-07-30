package org.example.service;

import org.example.dto.OperationDTO;
import org.example.entity.Category;
import org.example.utils.CSVWriter;
import org.example.utils.JDBCUtils;
import org.example.dto.AccountDTO;
import org.example.entity.User;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class StatementService {
    private final String username = System.getenv("username");
    private final String password = System.getenv("password");

    public List<AccountDTO> getAccountsByUser(User user) {
        try (Connection connection = JDBCUtils.getConnection(username, password)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("select * from accounts where user_id=?")) {
                preparedStatement.setLong(1, user.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                List<AccountDTO> result = new ArrayList<>();
                while (resultSet.next()) {
                    String alias = resultSet.getString("alias");
                    Long balance = resultSet.getLong("balance");
                    result.add(new AccountDTO(alias, balance));
                }
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void operationsToCsv(AccountDTO account, Instant from, Instant to) {
        List<OperationDTO> operations = new ArrayList<>();

        try (Connection connection = JDBCUtils.getConnection(username, password)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("select * from operations o inner join categories c on o.category_id=c.id where account_id=1 and o.time between ? and ?")) {
                preparedStatement.setString(1, from.toString());
                preparedStatement.setString(2, to.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Long sum = resultSet.getLong("sum");
                    Instant time = resultSet.getTimestamp("time").toInstant();
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    Category.CategoryType type = Category.CategoryType.valueOf(resultSet.getString("type"));
                    operations.add(new OperationDTO(sum, time, name, description, type));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!operations.isEmpty()) {
            String[] headers = {"time", "sum", "category_name", "category_description", "category_type"};

            List<String[]> rows = new ArrayList<>(operations.size());
            for (OperationDTO operation : operations) {
                rows.add(new String[]{operation.getTime().toString(), operation.getSum().toString(), operation.getName(), operation.getDescription(), operation.getType().toString()});
            }

            CSVWriter.write(headers, rows, account.getAlias() + ".csv");
        } else {
            throw new RuntimeException("Nothing to write");
        }
    }
}
