package com.spring.mvc.repository;

import com.spring.mvc.model.Event;
import com.spring.mvc.storage.Storage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRepository {

    private Storage storage;

    public void crateEvent(Event event) {
        storage.addToEventStorage(event);
    }

    public Event getEvent(String title) {
        return storage.getEvent(title);
    }
}
