package com.example.task1.controller;

import com.example.task1.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class CountController {
    @Autowired
    HttpSession httpSession;
    @RequestMapping
    public String counter(Model model){

        if(httpSession.getAttribute("counter")!=null){
           int numberOfView = (int) httpSession.getAttribute("counter");
           //numberOfView++;
            model.addAttribute("numberOfView",numberOfView);
            httpSession.setAttribute("counter",++numberOfView);


            return "home";
        }else {
            httpSession.setAttribute("counter",1);
            int numberOfView = (int) httpSession.getAttribute("counter");
            model.addAttribute("numberOfView",numberOfView);
            return "home";
        }
    }
}

//@Controller
//@SessionAttributes("count")
//public class CountController {
//
//    @ModelAttribute("count")
//    public Counter counter(){
//        return  new Counter();
//    }
//    @RequestMapping
//    public String countView(@ModelAttribute("count") Counter counter, Model model){
//        counter.increment();
//        model.addAttribute("numberOfView",counter.getCount());
//        return "home";
//    }
//}

