package com.example.task2.controller;

import com.example.task2.model.SmartPhone;
import com.example.task2.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smartphone/api/1.0")
@CrossOrigin("*")
public class SmartPhoneController {
    @Autowired
    ISmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> create(@RequestBody SmartPhone smartPhone){
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(smartPhone, HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<List<SmartPhone>> findAll(){
        List<SmartPhone> smartPhoneList = smartPhoneService.findAll();
        return new ResponseEntity<>(smartPhoneList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        SmartPhone smartphoneOptional = smartPhoneService.findById(id);
        if (smartphoneOptional==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional, HttpStatus.NO_CONTENT);
    }

}
