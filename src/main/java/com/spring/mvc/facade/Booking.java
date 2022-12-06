package com.spring.mvc.facade;

import com.spring.mvc.model.Event;
import com.spring.mvc.model.Ticket;
import com.spring.mvc.model.User;

public interface Booking {
    
    Event getEventsByTitle(Event event);
    
    void createEvent(Event event);
    
    User getUsersByName(User user);
    
    void createUser(User user);
    
    void createTicket(Ticket ticket);
    
    Ticket getBookedTickets(Ticket ticket);

    void cancelTicket(Ticket ticket);
}
