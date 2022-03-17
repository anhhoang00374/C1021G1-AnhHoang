package com.example.task1.controller;

import com.example.task1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserCustomer {
    @RequestMapping
    public String login(Model model){
        model.addAttribute("user",new User());
        return "index";
    }

    @RequestMapping("/doLogin")
    public String success(Model model){
        model.addAttribute("user",new User());
        return "sucess";
    }
}
