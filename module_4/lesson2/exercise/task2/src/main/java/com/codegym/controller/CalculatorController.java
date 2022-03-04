package com.codegym.controller;

import com.codegym.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping
    public String displayHome() {
        return "/home";
    }

    @PostMapping("/calculate")
    public String calculate(String operator, int num1, int num2, Model model) {
            String result = new CalculatorService().Calculate(num1,num2,operator);
            model.addAttribute("result", result);
        return "/home";
    }
}
