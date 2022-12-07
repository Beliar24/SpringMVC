package com.spring.mvc.controller;

import com.spring.mvc.dao.UserImpl;
import com.spring.mvc.facade.BookingFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class UserController {

    private final BookingFacade bookingFacade;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String createUser() {
        bookingFacade.createUser(new UserImpl("test", 1L, "test@test.com"));
        return "first-view.html";
    }
}
