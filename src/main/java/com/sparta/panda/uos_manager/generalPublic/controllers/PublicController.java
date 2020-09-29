package com.sparta.panda.uos_manager.generalPublic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {

    @GetMapping("/")
    public String getHomepage() {
        return "index";
    }


}
