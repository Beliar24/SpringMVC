package com.spring.mvc.storage;

import com.spring.mvc.model.Event;
import com.spring.mvc.model.Ticket;
import com.spring.mvc.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Storage {
    public Storage() {
    }

    private static Storage instance;

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    private final List<User> userStorage = new ArrayList<>();
    private final List<Ticket> ticketStorage = new ArrayList<>();
    private final List<Event> eventStorage = new ArrayList<>();

    public void addToUserStorage(User user) {
        userStorage.add(user);
    }

    public void addToEventStorage(Event event) {
        eventStorage.add(event);
    }

    public void addToTicketStorage(Ticket ticket) {
        ticketStorage.add(ticket);
    }

    public User getUser(String name) {
        return userStorage
                .stream()
                .filter(u -> u.getName().equals(name))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public Event getEvent(String title) {
        return eventStorage
                .stream()
                .filter(u -> u.getTitle().equals(title))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public Ticket getTicket(Long id) {
        return ticketStorage
                .stream()
                .filter(u -> u.getId() == id)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public void cancelTicket(Ticket ticket) {
        ticketStorage.remove(ticket);
    }
}
