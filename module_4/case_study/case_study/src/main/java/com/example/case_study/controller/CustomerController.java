package com.example.case_study.controller;

import com.example.case_study.DTO.CustomerDTO;
import com.example.case_study.model.Customer;
import com.example.case_study.repository.ICustomerTypeRepository;
import com.example.case_study.service.ICustomerService;
import com.example.case_study.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerTypeService customerTypeService;
    @Autowired
    ICustomerService customerService;
    @RequestMapping
    public String displayList(Model model,@PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerEdit",new Customer());
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customerList",customerService.findAll(pageable));
        return "/customer/customer-home";
    }
    @PostMapping("/add-new")
    public String displayList(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes, @PageableDefault(size = 4)Pageable pageable){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","add new successfully");
        redirectAttributes.addFlashAttribute("color","color:green");
        return "redirect:/customer";
    }
    @PostMapping("/delete")
    public String delete( RedirectAttributes redirectAttributes,Long id){
        Customer customer = customerService.findById(id);
        if(customer!=null){
            customerService.delete(customer);
            redirectAttributes.addFlashAttribute("message","delete successfully");
            redirectAttributes.addFlashAttribute("color","color:red");
            return "redirect:/customer";
        }else{
            redirectAttributes.addFlashAttribute("message","Id doesn't exits");
            redirectAttributes.addFlashAttribute("color","color:red");
            return "redirect:/customer";
        }
    }

    @GetMapping("edit/{id}")
    public String showFormEdit(@PathVariable Long id,RedirectAttributes redirectAttributes){
        Customer customer = customerService.findById(id);
        if(customer!=null){
            redirectAttributes.addFlashAttribute("editCustomer",customer);
            return "redirect:/customer";
        }else {
            redirectAttributes.addFlashAttribute("message","Id doesn't exits");
            redirectAttributes.addFlashAttribute("color","color:red");
            return "redirect:/customer";
        }
    }
    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute("customerEdit")Customer customer,RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Update successfully");
        redirectAttributes.addFlashAttribute("color","color:green");
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(required = false,defaultValue = "") String search,@PageableDefault(size = 5) Pageable pageable,Model model){
        Page<Customer> customerList = customerService.findByName(search,pageable);
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerEdit",new Customer());
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customerList",customerList);
        model.addAttribute("message","There are "+customerList.getTotalElements()+" customers are found");
        model.addAttribute("color","color:green");
        return "/customer/customer-home";
    }
}
