package com.example.task1.Controller;

import com.example.task1.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @RequestMapping
    public String showDisplay(Model model){
        model.addAttribute("user",new UserDto());
        return "/views/home";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute(name = "user") UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/views/home";
        }else{
            return "views/congratulation";
        }
    }
}
