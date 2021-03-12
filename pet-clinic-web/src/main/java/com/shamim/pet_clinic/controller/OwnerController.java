package com.shamim.pet_clinic.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    @RequestMapping({"","/","/index","/index.html"})
    public String vetList(){
        return "owners/index";
    }
}
