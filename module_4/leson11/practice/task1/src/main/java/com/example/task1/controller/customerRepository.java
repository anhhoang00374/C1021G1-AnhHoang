package com.example.task1.controller;

import com.example.task1.model.Customer;
import com.example.task1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/api/1.0")
public class customerRepository {
    @Autowired
    ICustomerService customerService;
    @RequestMapping("/list")
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> customerList = customerService.findAll();
        if(customerList==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return  new ResponseEntity<>(customerList,HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(customer,HttpStatus.OK);
        }
    }

    @PostMapping("/add-customer")
    public ResponseEntity<Customer> addNew(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer){
        Customer customer1 = customerService.findById(id);
        if(customer1==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            customer.setId(customer.getId());
           return new ResponseEntity<>(customer1,HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer!=null){
            customerService.remove(id);
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
