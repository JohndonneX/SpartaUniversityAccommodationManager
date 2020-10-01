package com.sparta.panda.uos_manager.generalPublic.controllers;

import com.sparta.panda.uos_manager.common.entities.Enquiry;
import com.sparta.panda.uos_manager.common.entities.OccupancyType;
import com.sparta.panda.uos_manager.common.entities.RecreationalRoomType;
import com.sparta.panda.uos_manager.common.services.EnquiryService;
import com.sparta.panda.uos_manager.generalPublic.services.OccupanyTypeService;
import com.sparta.panda.uos_manager.generalPublic.services.RecreationalRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PublicController {
    private final EnquiryService enquiryService;
    private final OccupanyTypeService occupanyTypeService;
    private final RecreationalRoomTypeService recreationalRoomTypeService;

    @Autowired
    public PublicController(EnquiryService enquiryService, OccupanyTypeService occupanyTypeService, RecreationalRoomTypeService recreationalRoomTypeService) {
        this.enquiryService = enquiryService;
        this.occupanyTypeService = occupanyTypeService;
        this.recreationalRoomTypeService = recreationalRoomTypeService;
    }

    @GetMapping("/")
    public ModelAndView getHomepage() {
        return new ModelAndView("redirect:http://localhost:8080/home");
    }

    @GetMapping("/home")
    public String getHome() {
        return "/public/home";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "/public/login/login";
    }

    @PostMapping("/loginProcessing")
    public ModelAndView processLogin() {
        return new ModelAndView("redirect:http://localhost:8080/login");
    }

    @GetMapping("/loginFailure")
    public String loginFailureGET() {
        return "public/login/loginFailure";
    }

    @PostMapping("/loginFailure")
    public String loginFailurePOST() {
        return "public/login/loginFailure";
    }

    @GetMapping("/rooms")
    public String getRoomsPage(ModelMap modelMap) {
        List<OccupancyType> roomTypes = occupanyTypeService.getRoomTypes();
        List<RecreationalRoomType> recRoomTypes = recreationalRoomTypeService.getRecRoomTypes();
        modelMap.addAttribute("roomTypes", roomTypes);
        modelMap.addAttribute("recRoomTypes", recRoomTypes);
        return "/public/rooms";
    }

    @GetMapping("/facilities")
    public String getFacilitiesPage() {
        return "/public/facilities";
    }

    @GetMapping("/contactUs")
    public String contactUsForm(Model model) {
        model.addAttribute("enquiry", new Enquiry());
        return "/public/contactUs";
    }

    @PostMapping("/publicSubmitContactUs")
    public String contactUsSubmit(@ModelAttribute Enquiry enquiry){
        enquiry.setStatus("In Progress");
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
