package com.codegym.controller;

import com.codegym.service.IWordService;
import com.codegym.service.WordImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DictionaryController {
    IWordService iWordService = new WordImpl();
    @GetMapping("/")
    public String search(){
        return "home";
    }
    @PostMapping ("/search")
    public String convert(@RequestParam String english, Model model){

        String result = iWordService.checkWord(english);
        model.addAttribute("result",result);
        return "home";
    }
}
