package com.sparta.panda.uos_manager.generalPublic.controllers;

import com.sparta.panda.uos_manager.common.entities.Enquiry;
import com.sparta.panda.uos_manager.generalPublic.services.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class PublicController {

    private EnquiryService enquiryService;

    @Autowired
    public PublicController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    @GetMapping("/")
    public String getHomepage() {
        return "/public/home";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "/public/login/login";
    }

    @PostMapping("/login")
    public String postLoginPage() {
        return "/resident/resident";
    }

    @GetMapping("success")
    public String getSuccess() {
        return "/public/success";
    }

    @GetMapping("/addEnquiry")
    public String addEnquiry() {
        Enquiry enquiry = new Enquiry();
        enquiry.setDateTimePosted(LocalDateTime.now());
        enquiry.setEmail("test@test.com");
        enquiry.setContactNo("+99 999999999");
        enquiry.setContent("This is a test text content");
        enquiry.setStatus("Completed");

        enquiryService.saveEnquiry(enquiry);
        return "/public/success";
    }


}
