//package com.spring.mvc;
//
//import com.spring.mvc.facade.BookingFacade;
//import com.spring.mvc.repository.EventRepository;
//import com.spring.mvc.repository.TicketRepository;
//import com.spring.mvc.repository.UserRepository;
//import com.spring.mvc.service.EventService;
//import com.spring.mvc.service.TicketService;
//import com.spring.mvc.service.UserService;
//import com.spring.mvc.storage.Storage;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ComponentScan("com.spring.mvc")
//public class SpringConfiguration {
//
//    @Bean
//    public Storage storage() {
//        return new Storage();
//    }
//
//    @Bean
//    public UserRepository userRepository() {
//        return new UserRepository(storage());
//    }
//
//    @Bean
//    public EventRepository eventRepository() {
//        return new EventRepository(storage());
//    }
//
//    @Bean
//    public TicketRepository ticketRepository() {
//        return new TicketRepository(storage());
//    }
//
//    @Bean
//    public UserService userService() {
//        return new UserService(userRepository());
//    }
//
//    @Bean
//    public EventService eventService() {
//        return new EventService(eventRepository());
//    }
//
//    @Bean
//    public TicketService ticketService() {
//        return new TicketService(ticketRepository());
//    }
//
//    @Bean
//    public BookingFacade bookingFacade() {
//        return new BookingFacade(eventService(), userService(), ticketService());
//    }
//}
