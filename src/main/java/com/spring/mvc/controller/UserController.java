package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String createUser() {
        return "first-view";
    }
}
