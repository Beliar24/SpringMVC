package com.spring.mvc.service;

import com.spring.mvc.model.Ticket;
import com.spring.mvc.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class TicketService {

    private TicketRepository ticketRepository;

    public void createTicket(Ticket ticket) {
        ticketRepository.createTicket(ticket);
    }

    public Ticket getTicket(Long id) {
        return ticketRepository.getTicket(id);
    }

    public void cancelTicket(Ticket ticket) {
        ticketRepository.cancelTicket(ticket);
    }
}
