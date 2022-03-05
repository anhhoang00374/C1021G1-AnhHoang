package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @RequestMapping
    public String display(Model model){
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("listBlog",blogList);
        return "/home";
    }
    @GetMapping("/show-create-form")
    public String showCreateForm( Model model){
        model.addAttribute("blog",new Blog());
        return "/createFrom";
    }

    @PostMapping("/create")
    public String create(Blog blog){
        iBlogService.add(blog);
        return ("redirect:/");
    }

    @GetMapping("/cancel/{id}")
    public String cancel(@PathVariable Long id){
        iBlogService.remove(id);
        return ("redirect:/");
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return ("/view");
    }
    @GetMapping("/edit/{id}")
    public  String showFormEdit(@PathVariable Long id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        System.out.println(blog.getId());
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog){
        iBlogService.edit(blog);
        System.out.println(blog.getId());
        return "redirect: /";
    }

    @GetMapping("/search")
    public String search(){
        List<Blog> blogList = iBlogService.search();
        System.out.println(blogList.size());
        return "";
    }
}
