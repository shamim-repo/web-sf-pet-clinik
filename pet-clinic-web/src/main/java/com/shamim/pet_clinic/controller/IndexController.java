package com.shamim.pet_clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","index","index.html"})
    public String index(){
        return "index";
    }
    @RequestMapping({"/oups","/oups/","/oups/index","/oups/index.html"})
    public String oupsHandeler(){
        return "notImplemented";
    }
}
