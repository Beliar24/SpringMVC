package com.spring.mvc.repository;

import com.spring.mvc.model.Ticket;
import com.spring.mvc.storage.Storage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class TicketRepository {

    private Storage storage;

    public void createTicket(Ticket ticket) {
        storage.addToTicketStorage(ticket);
    }

    public Ticket getTicket(Long id) {
        return storage.getTicket(id);
    }

    public void cancelTicket(Ticket ticket) {
        storage.cancelTicket(ticket);
    }
}
