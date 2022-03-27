package com.example.case_study.controller.APIController;

import com.example.case_study.model.Employee;
import com.example.case_study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee/1.0")
public class APIEmployee {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("/edit/{id}")
    public ResponseEntity<Employee> showEditForm(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        if(employee!=null){
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
