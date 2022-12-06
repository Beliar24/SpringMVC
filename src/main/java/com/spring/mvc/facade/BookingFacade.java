package com.spring.mvc.facade;

import com.spring.mvc.model.Event;
import com.spring.mvc.model.Ticket;
import com.spring.mvc.model.User;
import com.spring.mvc.service.EventService;
import com.spring.mvc.service.TicketService;
import com.spring.mvc.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Setter
@Component
public class BookingFacade implements Booking {
    
    private EventService eventService;
    private UserService userService;
    private TicketService ticketService;


    @Override
    public Event getEventsByTitle(Event event) {
        return eventService.getEvent(event);
    }

    @Override
    public void createEvent(Event event) {
        eventService.crateEvent(event);
    }

    @Override
    public User getUsersByName(User user) {
        return userService.getUser(user);
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
    public Ticket getBookedTickets(Ticket ticket) {
        return ticketService.getTicket(ticket);
    }

    @Override
    public void cancelTicket(Ticket ticket) {
        ticketService.cancelTicket(ticket);
    }
}
