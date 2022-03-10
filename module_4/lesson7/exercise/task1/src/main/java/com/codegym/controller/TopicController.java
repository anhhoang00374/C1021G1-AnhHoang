package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    ICategoryService categoryService;
    @RequestMapping("show-create-topic-form")
    public String showFormTopic(Model model){
        model.addAttribute("category",new Category());
        return "/topic/add";
    }

    @GetMapping("/list")
    public String displayList(@PageableDefault(size = 5)Pageable pageable,Model model){
        Page<Category> categories = categoryService.findAll(pageable);
        model.addAttribute("categoryList",categories);
        return "topic/list";
    }
    @PostMapping("/create-topic")
    public String create(Category category){
        categoryService.add(category);
        return "redirect: /topic/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "topic/edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("category") Category category){
        categoryService.edit(category);
        return "redirect: /topic/list";
    }
    @GetMapping("/cancel/{id}")
    public String cancel(@PathVariable Long id,Model model){
        categoryService.remove(id);
        return "redirect:/topic/list";
    }
}
