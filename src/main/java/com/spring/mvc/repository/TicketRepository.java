package com.spring.mvc.repository;

import com.spring.mvc.dao.EventImpl;
import com.spring.mvc.dao.TicketImpl;
import com.spring.mvc.model.Event;
import com.spring.mvc.model.Ticket;
import com.spring.mvc.storage.DbConfig;
import com.spring.mvc.storage.Storage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class TicketRepository {

    private DbConfig dbConfig;

    public void createTicket(Ticket ticket) {
        try (Connection connection = dbConfig.dataSource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Ticket (id, user_id, event_id, place) values (?, ?, ?, ?)");
            statement.setLong(1, ticket.getId());
            statement.setLong(2, ticket.getUserId());
            statement.setLong(3, ticket.getEventId());
            statement.setInt(4, ticket.getPlace());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Ticket getTicket(Long id) {
        Ticket ticket = new TicketImpl();
        try (Connection connection = dbConfig.dataSource().getConnection()) {
            String query = "select * from ticket where id='%d'";
            PreparedStatement statement = connection
                    .prepareStatement(String.format(query, id));
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ticket.setId(resultSet.getLong("id"));
                ticket.setId(resultSet.getLong("user_id"));
                ticket.setId(resultSet.getLong("event_id"));
                ticket.setPlace(resultSet.getInt("place"));
                ticket.setCategory((Ticket.Category) resultSet.getObject("category"));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ticket;
    }

    public void cancelTicket(Ticket ticket) {
        try (Connection connection = dbConfig.dataSource().getConnection()) {
            String query = "delete from ticket where id='%d'";
            PreparedStatement statement = connection
                    .prepareStatement(String.format(query, ticket.getId()));
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
