package com.codegym;


import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String addEmployee(Model model) {
        model.addAttribute("employee1", new Student());
        return "/add-employee";
    }
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String doAddEmployee(@ModelAttribute("employee") Student employee, ModelMap modelMap) {
        employee.setName(employee.getName().toUpperCase());
        modelMap.addAttribute("employee", employee);
        return "/view-employee";
    }

    @RequestMapping(value = "/id",params = {"id=5"})
    String getIdByValue(@RequestParam("id") String personId){
        System.out.println("ID is "+personId);
        return "Get ID from query string of URL with value element";
    }

    @RequestMapping(value = "/personId")
    String getId(@RequestParam String personId){
        System.out.println("ID is "+personId);
        return "Get ID from query string of URL without value element";
    }

}
