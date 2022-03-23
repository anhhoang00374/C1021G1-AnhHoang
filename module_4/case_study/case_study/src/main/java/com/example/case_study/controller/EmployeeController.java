package com.example.case_study.controller;

import com.example.case_study.model.Employee;
import com.example.case_study.repository.IEmployeeRepository;
import com.example.case_study.service.IDivisionService;
import com.example.case_study.service.IEducationService;
import com.example.case_study.service.IEmployeeService;
import com.example.case_study.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IEducationService educationService;
    @GetMapping
    public String display(@PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Employee> employeeList = employeeService.findAll(pageable);
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("employeeCreate",new Employee());
        model.addAttribute("divisionList",divisionService.findAll());
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("educationList",educationService.findAll());
        return "employee/employee-home";
    }

    @PostMapping("/add-new")
    public String addNew (@ModelAttribute("employeeCreate")Employee employee, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","Add new successfully");
        redirectAttributes.addFlashAttribute("color","color:green");
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") Long deleteId,RedirectAttributes redirectAttributes){
        Employee employee = employeeService.findById(deleteId);
        if(employee!=null){
            employeeService.delete(employee);
            redirectAttributes.addFlashAttribute("message","Delete employee successfully");
            redirectAttributes.addFlashAttribute("color","color:red");
            return "redirect:/employee";
        }else{
            redirectAttributes.addFlashAttribute("message","This id does not exits");
            redirectAttributes.addFlashAttribute("color","color:red");
            return "redirect:/employee";
        }
    }

    @GetMapping("/search")
    public String searchEmployee(@RequestParam(required = false,defaultValue = "") String search,
                                 @PageableDefault(size = 5)Pageable pageable,Model model){
        Page<Employee> employeeList = employeeService.findByName(search,pageable);
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("employeeCreate",new Employee());
        model.addAttribute("divisionList",divisionService.findAll());
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("educationList",educationService.findAll());
        model.addAttribute("message","There are "+employeeList.getTotalElements()+" employees are found");
        model.addAttribute("color","color:green");
        return "employee/employee-home";
    }
}
