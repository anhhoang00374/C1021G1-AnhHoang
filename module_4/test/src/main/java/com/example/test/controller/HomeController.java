package com.example.test.controller;

import com.example.test.dto.ProductDTO;
import com.example.test.model.Product;
import com.example.test.model.Type;
import com.example.test.service.impl.IProductService;
import com.example.test.service.impl.ITypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    IProductService productService;
    @Autowired
    ITypeService typeService;
    @GetMapping
    public String displayHome(@PageableDefault(size = 2)Pageable pageable, Model model){
        List<Type> typeList = typeService.findAll();
        model.addAttribute("typeList",typeList);
        Page<Product> products =productService.findAll(pageable);
        model.addAttribute("productList",products);
        return "home";
    }
    @GetMapping("/form-add")
    public String showFormAdd(Model model){
        List<Type> typeList = typeService.findAll();
        model.addAttribute("typeList",typeList);
        model.addAttribute("dto",new ProductDTO());
        return "addNew";
    }
    @PostMapping("/add-new")
    public String addNew(@Valid @ModelAttribute("dto")ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        new ProductDTO().validate(productDTO,bindingResult);
        if(bindingResult.hasErrors()){
            List<Type> typeList = typeService.findAll();
            model.addAttribute("typeList",typeList);
            return "addNew";
        }else{
            Product product = new Product();
            BeanUtils.copyProperties(productDTO,product);
            Type type = typeService.findById(productDTO.getType());
            product.setStatus("waiting");
            product.setType(type);
            productService.save(product);
            redirectAttributes.addFlashAttribute("message","Add new successfully");
            return "redirect:/";
        }

    }

    @GetMapping("/search")
    public String search(@PageableDefault(size = 2) Pageable pageable,@RequestParam(required = false,defaultValue = "") String searchName,
                         @RequestParam(required = false,defaultValue = "") String searchPrice,
                         @RequestParam(required = false,defaultValue = "") String searchType,Model model){
        //Type type = typeService.findById(Long.parseLong(searchType));
        List<Type> typeList = typeService.findAll();
        model.addAttribute("typeList",typeList);
        Float price;
        if(searchPrice.trim()==""){
            price=0F;
        }else{
            price = Float.parseFloat(searchPrice);
        }
        if(!(searchType.equals("-1"))){
            Page<Product> products = productService.searchAll(searchName,price,searchType,pageable);
            model.addAttribute("productList",products);
            return "search";
        }else{
            Page<Product> products = productService.searchByNameAndPrice(searchName,price,pageable);
            model.addAttribute("productList",products);
            return "search";
        }

    }

}
