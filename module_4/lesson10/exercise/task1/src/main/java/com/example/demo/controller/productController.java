package com.example.demo.controller;

import com.example.demo.dto.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@SessionAttributes("cart")
@Controller
public class productController {
    @ModelAttribute("cart")
    public Cart initCart(){
        return new Cart();
    }

    @Autowired
    IProductService productService;

    @RequestMapping
    public String home(@PageableDefault(size = 6)Pageable pageable, Model model){
        Page<Product> productPage = productService.productList(pageable);
        if(productPage.getTotalElements()>0){
            model.addAttribute("productList",productPage);
        }

        return "home";
    }

    @GetMapping("add-new")
    public String showAddForm(Model model){
        model.addAttribute("product",new Product());
        return "add-form";
    }

    @PostMapping("add-new")
    public String addNew(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes){
        Long currentTime = new Date().getTime();
        product.setTimeAdd(currentTime);
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","add new successfully");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id,@SessionAttribute("cart") Cart cart){
        Product product = productService.findById(id);
        if(product!=null){
            productService.delete(product);
        }
        return "redirect:/";
    }

    @GetMapping("buy")
    public String buyProduct(@SessionAttribute("cart") Cart cart,@RequestParam("id") Long id){
        Product product =productService.findById(id);
        cart.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("check-cart")
    public String checkCart(@SessionAttribute("cart") Cart cart,Model model){
        model.addAttribute("cart",cart);
        return "cart";
    }
}

