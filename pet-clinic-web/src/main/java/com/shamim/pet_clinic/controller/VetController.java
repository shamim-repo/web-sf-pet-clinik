package com.shamim.pet_clinic.controller;

import com.shamim.pet_clinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/vets")
@Controller
public class VetController {
    private final VetService vetService;
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }
    @RequestMapping({"","/","/index","/index.html"})
    public String vetList(Model model){
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
