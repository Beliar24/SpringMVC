package com.spring.mvc.facade;

import com.spring.mvc.model.Event;
import com.spring.mvc.model.Ticket;
import com.spring.mvc.model.User;

public interface Booking {
    
    Event getEventsByTitle(String title);
    
    void createEvent(Event event);
    
    User getUsersByName(String name);
    
    void createUser(User user);
    
    void createTicket(Ticket ticket);
    
    Ticket getBookedTickets(Long id);

    void cancelTicket(Ticket ticket);
}
