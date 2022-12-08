package com.spring.mvc;


import com.spring.mvc.dao.EventImpl;
import com.spring.mvc.dao.TicketImpl;
import com.spring.mvc.dao.UserImpl;
import com.spring.mvc.facade.BookingFacade;
import com.spring.mvc.model.Ticket;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Application {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        BookingFacade facade = context.getBean("bookingFacade", BookingFacade.class);

        UserImpl user = new UserImpl("Nick", 1L, "email@gmail.com");

        EventImpl event = new EventImpl(2L, "Title", new Date());

        Ticket ticket = new TicketImpl(3L, event, user, 24, Ticket.Category.STANDARD);

        facade.createUser(user);
        facade.createEvent(event);
        facade.createTicket(ticket);

        System.out.println(facade.getBookedTickets(ticket));

        facade.cancelTicket(ticket);

    }
}
