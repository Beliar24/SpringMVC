package com.spring.mvc.facade;

import com.spring.mvc.dao.UserImpl;
import com.spring.mvc.model.Event;
import com.spring.mvc.model.Ticket;
import com.spring.mvc.model.User;
import com.spring.mvc.service.EventService;
import com.spring.mvc.service.TicketService;
import com.spring.mvc.service.UserService;
import com.spring.mvc.storage.DbConfig;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.*;

@AllArgsConstructor
@Setter
@Component
public class BookingFacade implements Booking {

    private EventService eventService;
    private UserService userService;
    private TicketService ticketService;


    @Override
    public Event getEventsByTitle(String title) {
        return eventService.getEvent(title);
    }

    @Override
    public void createEvent(Event event) {
        eventService.crateEvent(event);
    }

    @Override
    public User getUsersByName(String username) {
        return userService.getUser(username);
    }

    @Override
    public void createUser(User user) {
        userService.createUser(user);
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketService.createTicket(ticket);
    }

    @Override
    public Ticket getBookedTickets(Long id) {
        return ticketService.getTicket(id);
    }

    @Override
    public void cancelTicket(Ticket ticket) {
        ticketService.cancelTicket(ticket);
    }
}
