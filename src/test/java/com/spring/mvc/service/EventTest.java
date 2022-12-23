package com.spring.mvc.service;

import com.spring.mvc.dao.EventImpl;
import com.spring.mvc.model.Event;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EventTest {

    @Mock
    EventService eventService;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldBeCorrectGetEventMethod() {
        Event event = new EventImpl(1L, "New event", new Date(20));

        when(eventService.getEvent("New event")).thenReturn(event);

        assertEquals(eventService.getEvent("New event"), event);
    }

    @Test
    public void shouldBeNullInsteadEvent() {

        when(eventService.getEvent("New event")).thenReturn(null);

        assertNull(eventService.getEvent("New event"));
    }

    @Test
    public void shouldBeIncorrectEvent() {
        Event event = new EventImpl(1L, "New event", new Date(20));

        when(eventService.getEvent("New event")).thenReturn(event);

        assertNotEquals(eventService.getEvent("Tin"), event);
    }
}
