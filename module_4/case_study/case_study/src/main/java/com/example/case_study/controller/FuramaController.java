package com.example.case_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuramaController {
    @RequestMapping
    public String display(){
        return "home";
    }
}
