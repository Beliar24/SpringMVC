package com.spring.mvc.facade;

import com.spring.mvc.dao.EventImpl;
import com.spring.mvc.dao.TicketImpl;
import com.spring.mvc.dao.UserImpl;
import com.spring.mvc.model.Event;
import com.spring.mvc.model.Ticket;
import com.spring.mvc.model.User;
import com.spring.mvc.service.EventService;
import com.spring.mvc.service.TicketService;
import com.spring.mvc.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FacadeTest {

    @Mock
    UserService userService;

    @Mock
    EventService eventService;

    @Mock
    TicketService ticketService;

    BookingFacade facade;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
        facade = new BookingFacade(eventService, userService, ticketService);
    }

    @Test
    public void shouldBeCorrectGetUserMethodFromFacade() {
        User user = new UserImpl("Nick", 1L, "Noick@gmail.com");

        when(userService.getUser("Nick")).thenReturn(user);

        assertEquals(facade.getUsersByName("Nick"), user);
    }

    @Test
    public void shouldBeCorrectGetEventMethodFromFacade() {
        Event event = new EventImpl(1L, "New event", new Date(20));

        when(eventService.getEvent("New event")).thenReturn(event);

        assertEquals(facade.getEventsByTitle("New event"), event);
    }

    @Test
    public void shouldBeCorrectGetTicketMethodFromFacade() {
        UserImpl user = new UserImpl("Nick", 1L, "Noick@gmail.com");
        EventImpl event = new EventImpl(1L, "New event", new Date(20));
        Ticket ticket = new TicketImpl(1L, event, user, 2, Ticket.Category.STANDARD);

        when(ticketService.getTicket(1L)).thenReturn(ticket);

        assertEquals(facade.getBookedTickets(1L), ticket);
    }
}
