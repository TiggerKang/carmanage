package com.car.manage.sys.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "login",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(){
        return "login";
    }

}
