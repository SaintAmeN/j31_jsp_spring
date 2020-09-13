package com.sda.javagda31.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
//    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/calculator")
    public String getCalculator(){
        return "calculator";
    }

    @PostMapping("/calculator")
    public String displayCalculator(Model model, Integer sizeX, Integer sizeY){
        // model to obiekt który jest nam potrzebny do wysłania/zaprezentowania czegoś na widok/u
        model.addAttribute("rowNumber", sizeY);
        model.addAttribute("colNumber", sizeX);

        return "calculator";
    }
}
