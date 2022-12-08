package com.spring.mvc.controller;

import com.spring.mvc.dao.EventImpl;
import com.spring.mvc.dao.TicketImpl;
import com.spring.mvc.dao.UserImpl;
import com.spring.mvc.facade.BookingFacade;
import com.spring.mvc.model.Event;
import com.spring.mvc.model.Ticket;
import com.spring.mvc.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final BookingFacade facade;

    @RequestMapping("/")
    public String createUser(Model model) {
        User user = new UserImpl();
        user.setId(1);
        facade.createUser(user);
        model.addAttribute("Users", user);
        return "create-user";
    }

    @RequestMapping("/createEvent")
    public String createEvent(Model model) {
        Event event = new EventImpl();
        event.setDate(new Date());
        facade.createEvent(event);
        model.addAttribute("Events", event);
        return "create-event";
    }

    @RequestMapping("/createTicket")
    public String createTicket(Model model) {
        Ticket ticket = new TicketImpl();
        ticket.setUserId(facade.getUsersByName((User) model.getAttribute("Users")).getId());
        ticket.setCategory(Ticket.Category.STANDARD);
        ticket.setEventId(facade.getEventsByTitle((Event) model.getAttribute("Events")).getId());
        facade.createTicket(ticket);
        model.addAttribute("Tickets", ticket);
        return "create-ticket";
    }

    @RequestMapping("/showUser")
    public String showUserDetail(@ModelAttribute("Users") UserImpl user) {
        return "show-user";
    }

    @RequestMapping("/showTicket")
    public String showUserDetail(@ModelAttribute("Tickets") TicketImpl ticket) {
        return "show-ticket";
    }

    @RequestMapping("/showEvent")
    public String showEventDetail(@ModelAttribute("Event") EventImpl event) {
        return "show-event";
    }
}
