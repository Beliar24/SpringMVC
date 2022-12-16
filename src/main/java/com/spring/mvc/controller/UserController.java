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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class UserController {

    private final BookingFacade facade;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String createUser() {
        return "create-user.html";
    }

    @RequestMapping("/createEvent")
    public String createEvent() {
        return "create-event.html";
    }

    @RequestMapping("/createTicket")
    public String createTicket() {
        return "create-ticket.html";
    }

    @RequestMapping("/showUser")
    public String showUserDetail(@RequestParam("name")String name, @RequestParam("id") Long id,
                                 @RequestParam("email") String email, Model model) {
        User user = new UserImpl(name, id, email);
        facade.createUser(user);
        model.addAttribute("userName", name);
        model.addAttribute("userEmail", email);
        return "show-user.html";
    }

    @RequestMapping("/showTicket")
    public String showTicketDetail(@RequestParam("ticketId")Long id, @RequestParam("place") int place, Model model) {
        Ticket ticket = new TicketImpl(id,(EventImpl) facade.getEventsByTitle("Title"),
                (UserImpl) facade.getUsersByName("QA"), place, Ticket.Category.STANDARD);
        facade.createTicket(ticket);
        model.addAttribute("ticketId", id);
        model.addAttribute("ticketPlace", place);
        return "show-ticket.html";
    }

    @RequestMapping("/showEvent")
    public String showEventDetail(@RequestParam("title")String title, @RequestParam("eventId") Long id, Model model) {
        Event event = new EventImpl(id, title, new Date(2020,12,2));
        facade.createEvent(event);
        model.addAttribute("eventTitle", title);
        model.addAttribute("eventId", id);
        return "show-event.html";
    }

    @RequestMapping("/deleteTicket")
    public String deleteTicket() {
        facade.cancelTicket(facade.getBookedTickets(1L));
        return "delete-ticket.html";
    }
}
