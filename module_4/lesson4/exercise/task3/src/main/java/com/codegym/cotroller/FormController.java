package com.codegym.cotroller;

import com.codegym.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
    @RequestMapping
    public String displayHome(Model model){
        model.addAttribute("form",new Form());
        model.addAttribute("travel",new String[]{"Tàu bay","Tàu thuyền","Ô tô","Khác"});
        return "/home";
    }

    @PostMapping("/regist")
    public String regist(Form form,Model model){
        String info = form.toString();
        model.addAttribute("info",info);
        return "/result";
    }
}
