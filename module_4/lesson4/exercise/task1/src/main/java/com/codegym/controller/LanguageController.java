package com.codegym.controller;

import com.codegym.model.Language;
import com.codegym.model.Setting;
import com.codegym.service.ILanguageService;
import com.codegym.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LanguageController {
    @Autowired
    private ILanguageService iLanguageService;
    @Autowired
    ISettingService iSettingService;
    private String currentLanguage = "English";
    @RequestMapping
    public String displayHome(Model model){
        Language language = iLanguageService.checkLanguage(currentLanguage);
        model.addAttribute("language",language);
        //model.addAttribute("setting",new Setting());
        model.addAttribute("languages",new String[] {"English","Vietnamese","Chinese","Japanese"});
        model.addAttribute("sizeList",new int[]{5,10,15,25,50,100});
        model.addAttribute("setting",iSettingService.displayCurrentSetting());
        return "/home";
    }
    @RequestMapping("/change")
    public  String changeSetting(@ModelAttribute Setting setting, Model model){
       currentLanguage = setting.getLanguages();
        Language language = iLanguageService.checkLanguage(currentLanguage);
        model.addAttribute("language",language);
        model.addAttribute("languages",new String[] {"English","Vietnamese","Chinese","Japanese"});
        model.addAttribute("sizeList",new int[]{5,10,15,25,50,100});
        model.addAttribute("setting",setting);
        return  "/home";
    }
    @RequestMapping("/cancel")
    public String cancel(){
        return ("/cancel");
    }
}
