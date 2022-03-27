package com.example.case_study.controller;

import com.example.case_study.model.*;
import com.example.case_study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IFuramaSevice iFuramaSevice;
    @Autowired
    IRentypeService rentypeService;
    @Autowired
    IServiceTypeService serviceTypeService;
    @Autowired
    IComplimentaryService complimentaryService;
    @Autowired
    IStandRoomService standRoomService;
    @GetMapping
    public String displayService(@PageableDefault Pageable pageable, Model model){
        List<RentType> rentTypeList = rentypeService.findAll();
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        List<Complimentary> complimentaryList = complimentaryService.findAll();
        List<StandRoom> standRoomList = standRoomService.findAll();
        model.addAttribute("rentTypeList",rentTypeList);
        model.addAttribute("serviceTypeList",serviceTypeList);
        model.addAttribute("complimentaryList",complimentaryList);
        model.addAttribute("standRoomList",standRoomList);
        model.addAttribute("furamaservice",new FuramaService());
        Page<FuramaService> furamaServiceList = iFuramaSevice.findAll(pageable);
        model.addAttribute("serviceList",furamaServiceList);
        return "service/service";
    }

    @PostMapping("add-new")
    public String addNew(@ModelAttribute("furamaservice") FuramaService furamaService, RedirectAttributes redirectAttributes){
        iFuramaSevice.save(furamaService);
        redirectAttributes.addFlashAttribute("message","Add new successfully");
        redirectAttributes.addFlashAttribute("color","color:green");
        return "redirect:/service";
    }
}
