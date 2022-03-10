package com.example.task1.controller;

import com.example.task1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @RequestMapping
    public String displayForm(Model model){
        model.addAttribute("user", new User());
        return "addForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addForm";
        }else{
            return "success";
        }
    }
}
