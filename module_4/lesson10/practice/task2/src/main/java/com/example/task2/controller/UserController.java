package com.example.task2.controller;

import com.example.task2.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {
    @ModelAttribute("user")
    public User createUser(){
        return new User();
    }

    @RequestMapping
    public String showLoginForm(@CookieValue(name = "email",defaultValue = "") String email, Model model,HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("email",email);
      //  httpServletResponse.addCookie(cookie);
        model.addAttribute("email",cookie);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes, Model model, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest){
        if(user.getEmail().equals("admin@gmail.com")&&user.getPassword().equals("12345")){
            Cookie cookie = new Cookie("email", user.getEmail());
            cookie.setMaxAge(10);
            httpServletResponse.addCookie(cookie);
            model.addAttribute("email",cookie);
            return "login";
        }else {
            model.addAttribute("message","userName dosen't exits");
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(60);
            httpServletResponse.addCookie(cookie);
            model.addAttribute("email",cookie);
            return "login";
        }

    }
}
