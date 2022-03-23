package com.example.case_study.controller.APIController;

import com.example.case_study.DTO.CustomerDTO;
import com.example.case_study.model.Customer;
import com.example.case_study.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer/1.0")
public class APICustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> getListCustomer(@PageableDefault(size = 2) Pageable pageable,Model model){
        Page<Customer> customerList = customerService.findAll(pageable);
        if(customerList.isEmpty()){
            //return new ModelAndView("table-content/empty");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            //return new ModelAndView("table-content/customer","customerList",customerList);
            return new ResponseEntity<>(customerList,HttpStatus.OK);
        }
    }

//    @PostMapping("/add-customer")
//    public ModelAndView addCustomer(@ModelAttribute Customer customer,@PageableDefault Pageable pageable){
//        customerService.save(customer);
//        Page<Customer> customerList = customerService.findAll(pageable);
//        return new ModelAndView("table-content/customer","customerList",customerList);
//
//    }
@PostMapping("/add-customer")
public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer,@PageableDefault Pageable pageable){
    customerService.save(customer);
//    Page<Customer> customerList = customerService.findAll(pageable);
    return new ResponseEntity<>(customer,HttpStatus.OK);

}
@GetMapping("edit/{id}")
    public ResponseEntity<CustomerDTO> delete(@PathVariable Long id){
        Customer customer = customerService.findById(id);
    CustomerDTO customerDTO = new CustomerDTO();
    BeanUtils.copyProperties(customer,customerDTO);
    customerDTO.setCustomerTypeId(customer.getCustomerType().getId());
    if(customer!=null){
        return new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
