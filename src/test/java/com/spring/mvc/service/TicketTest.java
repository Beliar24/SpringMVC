package com.spring.mvc.service;

import com.spring.mvc.dao.EventImpl;
import com.spring.mvc.dao.TicketImpl;
import com.spring.mvc.dao.UserImpl;
import com.spring.mvc.model.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TicketTest {

    @Mock
    TicketService ticketService;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldBeCorrectGetTicketMethod() {
        UserImpl user = new UserImpl("Nick", 1L, "Noick@gmail.com");
        EventImpl event = new EventImpl(1L, "New event", new Date(20));
        Ticket ticket = new TicketImpl(1L, event, user, 2, Ticket.Category.STANDARD);

        when(ticketService.getTicket(1L)).thenReturn(ticket);

        assertEquals(ticketService.getTicket(1L), ticket);
    }

    @Test
    public void shouldBeNullInsteadEvent() {

        when(ticketService.getTicket(1L)).thenReturn(null);

        assertNull(ticketService.getTicket(1L));
    }

    @Test
    public void shouldBeIncorrectEvent() {
        UserImpl user = new UserImpl("Nick", 1L, "Noick@gmail.com");
        EventImpl event = new EventImpl(1L, "New event", new Date(20));
        Ticket ticket = new TicketImpl(1L, event, user, 2, Ticket.Category.STANDARD);

        when(ticketService.getTicket(1L)).thenReturn(ticket);

        assertNotEquals(ticketService.getTicket(2L), ticket);
    }
}
