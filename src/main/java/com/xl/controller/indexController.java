package com.xl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class indexController {

    @RequestMapping("/index")
    public String uploadPage() {
        return "index";
    }
}