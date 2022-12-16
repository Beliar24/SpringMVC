package com.spring.mvc.repository;

import com.spring.mvc.dao.UserImpl;
import com.spring.mvc.model.User;
import com.spring.mvc.storage.DbConfig;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class UserRepository {

    private DbConfig dbConfig;

    public void createUser(User user) {
        try (Connection connection = dbConfig.dataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Users (id, name, email) values (?, ?, ?)");
            statement.setLong(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser(String username) {
        User user = new UserImpl();
        try (Connection connection = dbConfig.dataSource().getConnection()) {
            String query = "select * from users where name='%s'";
            PreparedStatement statement = connection
                    .prepareStatement(String.format(query, username));
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet
                        .getString("name"));
                user.setEmail(resultSet
                        .getString("email"));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
