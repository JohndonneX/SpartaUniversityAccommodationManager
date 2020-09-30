package com.sparta.panda.uos_manager.generalPublic.controllers;

import com.sparta.panda.uos_manager.common.entities.Enquiry;
import com.sparta.panda.uos_manager.generalPublic.services.EnquiryService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/contactUs")
    public String contactUsForm(Model model) {
        model.addAttribute("enquiry", new Enquiry());
        return "/public/contactUs";
    }

    @PostMapping("/submitContactUs")
    public String contactUsSubmit(@ModelAttribute Enquiry enquiry){
        enquiry.setStatus("Pending");
        enquiry.setDateTimePosted(LocalDateTime.now());
        enquiryService.saveEnquiry(enquiry);

        return "/public/formSubmitResult";
    }

    @PostMapping("/login")
    public String postLoginPage() {
        return "/resident/resident";
    }

    @GetMapping("/success")
    public String getSuccess() {
        return "/public/success";
    }


}
