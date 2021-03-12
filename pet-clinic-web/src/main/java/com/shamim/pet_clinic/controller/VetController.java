package com.shamim.pet_clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/vets")
@Controller
public class VetController {

    @RequestMapping({"","/","/index","/index.html"})
    public String vetList(){
        return "vets/index";
    }
}
