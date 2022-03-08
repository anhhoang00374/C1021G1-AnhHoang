package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.IProvinceRepository;
import com.codegym.cms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    IProvinceRepository iProvinceRepository;
    @GetMapping
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/customer/list","customers",customerService.findAll());
       // System.out.println(customerService.findAll().size());
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces",iProvinceRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
       // redirectAttributes.addFlashAttribute("customers",customerService.findAll());
       // System.out.println(customerService.findAll().size());
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customer", new Customer());
        redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        return ("redirect:/");
    }

    @GetMapping("/customers")
    public ModelAndView listCustomers() {
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("provinces",iProvinceRepository.findAll());
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("message", "Customer updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete-customer/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "/customer/delete";
    }

    @PostMapping("/delete-customer")
    public String delete(@RequestParam Long id){
        customerService.remove(id);
        return "redirect:/";
    }
}
