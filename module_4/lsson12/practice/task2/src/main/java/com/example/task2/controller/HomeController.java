package com.example.task2.controller;

import com.example.task2.model.SmartPhone;
import com.example.task2.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ISmartPhoneService smartPhoneService;

    @GetMapping("/")
    public String showIndex(Model model) {
        List<SmartPhone> smartPhoneList = smartPhoneService.findAll();
        model.addAttribute("smartphones",smartPhoneList);
        return "/list";
    }
}
