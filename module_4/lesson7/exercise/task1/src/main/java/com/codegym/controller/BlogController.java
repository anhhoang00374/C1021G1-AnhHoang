package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    ICategoryService categoryService;
    @RequestMapping
    public String display(@RequestParam(required = false) String title,@PageableDefault(value = 6,sort = "time",direction = Sort.Direction.ASC)Pageable pageable, Model model){

        if(title!= null){
            Page<Blog> blogList = iBlogService.search(title,pageable);
            model.addAttribute("listBlog",blogList);
            return "/home";
        }else{
            Page<Blog> blogList = iBlogService.findAll(pageable);
            model.addAttribute("listBlog",blogList);
            return "/home";
        }


    }
    @GetMapping("/show-create-form")
    public String showCreateForm( Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("blog",new Blog());
        return "/createFrom";
    }

    @PostMapping("/create")
    public String create(Blog blog){
        blog.setTime(new Date().getTime());
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

//    @GetMapping("/search")
//    public String search(@RequestParam String name,@PageableDefault(5) Pageable pageable){
//        Page<Blog> blogList = iBlogService.search(name,pageable);
//        System.out.println(blogList.size());
//        return "";
//    }
}
