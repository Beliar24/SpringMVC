package com.spring.mvc.service;

import com.spring.mvc.model.Event;
import com.spring.mvc.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventService {

    private EventRepository eventRepository;

    public void crateEvent(Event event) {
        eventRepository.crateEvent(event);
    }

    public Event getEvent(Event event) {
        return eventRepository.getEvent(event.getTitle());
    }
}
