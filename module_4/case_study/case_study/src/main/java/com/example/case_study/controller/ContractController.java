package com.example.case_study.controller;

import com.example.case_study.model.Contract;
import com.example.case_study.model.Customer;
import com.example.case_study.model.Employee;
import com.example.case_study.model.FuramaService;
import com.example.case_study.service.ContractService;
import com.example.case_study.service.ICustomerService;
import com.example.case_study.service.IEmployeeService;
import com.example.case_study.service.IFuramaSevice;
import com.example.case_study.service.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IFuramaSevice furamaSevice;
    @Autowired
    ContractService contractService;
    @GetMapping
    public String displayContract(Model model){
        List<Employee> employeeList = employeeService.findAll();
        List<Customer> customerList = customerService.findAll();
        List<FuramaService> furamaServiceList = furamaSevice.findAll();
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("customerList",customerList);
        model.addAttribute("furamaServiceList",furamaServiceList);
        model.addAttribute("contract",new Contract());
        return "contract/contract";
    }
    @PostMapping("add-new")
    public String addNew(@ModelAttribute("contract")Contract contract){
        contractService.AddNew(contract);
        return "redirect:/contract";
    }
}
