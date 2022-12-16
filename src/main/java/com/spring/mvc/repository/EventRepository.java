package com.spring.mvc.repository;

import com.spring.mvc.dao.EventImpl;
import com.spring.mvc.model.Event;
import com.spring.mvc.storage.DbConfig;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRepository {

    private DbConfig dbConfig;

    public void crateEvent(Event event) {
        try (Connection connection = dbConfig.dataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Event (id, title, date) values (?, ?, ?)");
            statement.setLong(1, event.getId());
            statement.setString(2, event.getTitle());
            statement.setDate(3, event.getDate());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Event getEvent(String title) {
        Event event = new EventImpl();
        try (Connection connection = dbConfig.dataSource().getConnection()) {
            String query = "select * from event where title='%s'";
            PreparedStatement statement = connection
                    .prepareStatement(String.format(query, title));
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                event.setId(resultSet.getLong("id"));
                event.setTitle(resultSet
                        .getString("title"));
                event.setDate(resultSet
                        .getDate("date"));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return event;
    }
}
