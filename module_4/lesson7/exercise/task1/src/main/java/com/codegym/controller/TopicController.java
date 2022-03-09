package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopicController {
    @Autowired
    ICategoryService categoryService;
    @RequestMapping("show-create-topic-form")
    public String showFormTopic(Model model){
        model.addAttribute("category",new Category());
        return "/topic/add";
    }
    @RequestMapping("/create-topic")
    public String create(Category category){
        categoryService.add(category);
        return "redirect: /";
    }
}
