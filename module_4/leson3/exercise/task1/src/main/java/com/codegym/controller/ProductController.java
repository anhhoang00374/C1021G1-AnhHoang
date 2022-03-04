package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @RequestMapping
    public String displayHome(Model model){
        List<Product> productList = iProductService.findAll();
        model.addAttribute("listProduct",productList);
        return "/home";
    }

    @RequestMapping("/create")
    public String showCreateForm(Model model){
        Product product = new Product();
        product.setId(iProductService.lastId()+1);
        model.addAttribute("product",product);
        return "/creating";
    }

    @RequestMapping("/create/new_product")
    public String create(Product product, RedirectAttributes redirectAttributes){
        iProductService.create(product);
        redirectAttributes.addFlashAttribute("message","add successfully");
        return ("redirect:/home");
    }

    @GetMapping("delete/{id}")
    public String showFromDelete(@PathVariable int id,Model model){
        Product product = iProductService.view(id);
        model.addAttribute(product);
        return "/delete";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
        iProductService.delete(id);
        redirectAttributes.addFlashAttribute("message","delete successfully");
        return ("redirect:/home");
    }

    @GetMapping("edit/{id}")
    public String showFromEdit(@PathVariable int id,Model model){
        Product product = iProductService.view(id);
        model.addAttribute(product);
        return "/edit";
    }

    @PostMapping("edit/{id}")
    public String edit(@PathVariable int id,Product product,RedirectAttributes redirectAttributes){
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("message","edit successfully");
        return ("redirect:/home");
    }

    @RequestMapping("/view/{id}")
    public String showView(@PathVariable int id,Model model){
        Product product = iProductService.view(id);
        model.addAttribute("product",product);
        return "/view";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String name,Model model){
        List<Product> products = iProductService.searchByName(name);
        if(products.size()==0){
            model.addAttribute("message","not exits");
        }
        model.addAttribute("listProduct",products);
        return ("/home");
    }
}
