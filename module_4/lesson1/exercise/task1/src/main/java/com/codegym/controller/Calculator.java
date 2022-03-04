package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @GetMapping("/")
    public String calculatorPage(){
        return "/result";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam int value, @RequestParam int price, Model model){
        int result = value*price;
        model.addAttribute("result",result);
        return "/result";
    }
}
