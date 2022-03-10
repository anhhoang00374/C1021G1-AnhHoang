package com.example.demo.controller;

import com.example.demo.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class PhonenumberController {
    @RequestMapping
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "/home";
    }

    @PostMapping("/")
    public String checkValidation(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult, Model model) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/home";
        } else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "/result";
        }
    }
}
