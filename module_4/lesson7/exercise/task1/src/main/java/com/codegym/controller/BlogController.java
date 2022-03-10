package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private  boolean isSortByTime = false;
    @RequestMapping
    public String display(@RequestParam(required = false,defaultValue = "abc") String sort , Model model){
        //        if(isSortByTime){
        ////            @PageableDefault(value = 6,sort = "time",direction = Sort.Direction.ASC)
        ////                pageable.getSortOr()
        //            pageable.getSortOr(Sort.by(Sort.Direction.ASC,"time"));
        //        }else{
        //        }
//                    pageable.getSortOr(Sort.by(Sort.Direction.DESC,"title"));
//                    PageRequest.of()
        Pageable sortedByPriceDesc =
                PageRequest.of(0, 3, Sort.by("time").descending());
        Pageable sortedByPriceAsc =
                PageRequest.of(0, 3, Sort.by("time").ascending());
        if(!sort.contains("abc")){
          isSortByTime = !isSortByTime;
        }

//        if(title!= null){
//
//            Page<Blog> blogList = iBlogService.search(title,pageable);
//            model.addAttribute("listBlog",blogList);
//            return "/home";
//        }else{
            if(isSortByTime){
                model.addAttribute("sort","true");
            }else{
                model.addAttribute("sort","false");
            }
            if(isSortByTime){
                Page<Blog> blogList = iBlogService.findAll(sortedByPriceDesc);
                model.addAttribute("listBlog",blogList);
            }else{
                Page<Blog> blogList = iBlogService.findAll(sortedByPriceAsc);
                model.addAttribute("listBlog",blogList);
            }

//            Page<Blog> blogList = iBlogService.findAll(pageable);
//            model.addAttribute("listBlog",blogList);
//            if("ok".equals(name)){
//                Page<Blog> blogList = iBlogService.findAll(sortedByPriceDesc);
//                model.addAttribute("listBlog",blogList);
//            }else{
//                Page<Blog> blogList = iBlogService.findAll(sortedByPriceAsc);
//                model.addAttribute("listBlog",blogList);
            //}

            return "/home";
       // }


    }
    @GetMapping("/show-create-form")
    public String showCreateForm( Model model,@PageableDefault(size = 10)Pageable pageable){
        Page<Category> categories = categoryService.findAll(pageable);
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
    public  String showFormEdit(@PageableDefault Pageable pageable,@PathVariable Long id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
       Page<Category> categories = categoryService.findAll(pageable);
       model.addAttribute("category",categories);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog){
        iBlogService.edit(blog);
        System.out.println(blog.getId());
        return "redirect: /";
    }

    @GetMapping("/search")
    public String search(@RequestParam String title,@PageableDefault(5) Pageable pageable,Model model){
        Page<Blog> blogList = iBlogService.search(title,pageable);
        model.addAttribute("listBlog",blogList);
      //  System.out.println(blogList.size());
        return "search";
    }

//    private String setSortByTimeAsc(@RequestParam(required = false) String title,@PageableDefault(value = 6,sort = "time",direction = Sort.Direction.ASC)Pageable pageable, Model model){
//            if(title!= null){
//                Page<Blog> blogList = iBlogService.search(title,pageable);
//                model.addAttribute("listBlog",blogList);
//                return "/home";
//            }else{
//                Page<Blog> blogList = iBlogService.findAll(pageable);
//                model.addAttribute("listBlog",blogList);
//                return "/home";
//            }
//
//
//        }
//
//    private String setSortByTimeDesc(@RequestParam(required = false) String title,@PageableDefault(value = 6,sort = "time",direction = Sort.Direction.ASC)Pageable pageable, Model model){
//        if(title!= null){
//            Page<Blog> blogList = iBlogService.search(title,pageable);
//            model.addAttribute("listBlog",blogList);
//            return "/home";
//        }else{
//            Page<Blog> blogList = iBlogService.findAll(pageable);
//            model.addAttribute("listBlog",blogList);
//            return "/home";
//        }
//
//
//    }
}
