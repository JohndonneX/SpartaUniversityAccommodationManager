package com.sparta.panda.uos_manager.resident.controllers;
import com.sparta.panda.uos_manager.admin.services.AdminService;
import com.sparta.panda.uos_manager.common.entities.*;
import com.sparta.panda.uos_manager.common.services.BookingService;
import com.sparta.panda.uos_manager.common.services.IssueService;
import com.sparta.panda.uos_manager.common.services.LoginService;
import com.sparta.panda.uos_manager.generalPublic.services.RecreationalRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.sparta.panda.uos_manager.common.utilities.CurrentUser;
import com.sparta.panda.uos_manager.resident.services.ResidentNoticeBoardService;
import com.sparta.panda.uos_manager.common.services.ResidentService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@Controller
public class ResidentController {

    private final ResidentNoticeBoardService residentNoticeBoardService;
    private final ResidentService residentService;
    private final RecreationalRoomTypeService recreationalRoomTypeService;
    private final IssueService issueService;
    private final BookingService bookingService;
    private final LoginService loginService;
    private final AdminService adminService;

    @Autowired
    public ResidentController(ResidentNoticeBoardService residentNoticeBoardService, ResidentService residentService,
                              RecreationalRoomTypeService recreationalRoomTypeService, IssueService issueService,
                              BookingService bookingService, LoginService loginService, AdminService adminService) {
      
        this.residentNoticeBoardService = residentNoticeBoardService;
        this.residentService = residentService;
        this.recreationalRoomTypeService = recreationalRoomTypeService;
        this.issueService = issueService;
        this.bookingService = bookingService;
        this.loginService = loginService;
        this.adminService = adminService;
    }

    @GetMapping("/rr")
    public String getRulesRegulations() {
        return "/resident/rr";
    }

    @GetMapping("/residentHome")
    public String getResidentHomePage(ModelMap modelMap) {
        modelMap.addAttribute("welcomeMessage", "Welcome to your resident landing page name");
        return "/resident/resident";
    }

    @GetMapping("/managementTeam")
    public String getManagementTeam(ModelMap modelMap) {
        List<Admin> admins = adminService.getAllAdmin();
        modelMap.addAttribute("admins", admins);
        return "/resident/managementInfo";
    }

    @GetMapping("/residentNoticeBoard")
    public String getResidentNoticeBoard(Model model) {
        model.addAttribute("notices", residentNoticeBoardService.getAllNoticesOrderedByDateTimePostedDesc());
        model.addAttribute("role", CurrentUser.getResident().getRole());
        return "/resident/residentNoticeBoard";
    }

    @GetMapping("/residentNoticeBoardCreatePost")
    public String getResidentNoticeBoardCreatePost(Model model) {
        model.addAttribute("newResidentPost", new ResidentNotice());
        return "/resident/residentNoticeBoardCreatePost";
    }

    @PostMapping("/residentNoticeBoardCreatePost")
    public ModelAndView postResidentNoticeBoardCreatePost(@ModelAttribute ResidentNotice newResidentPost, ModelMap modelMap, Principal principal) {
        Optional<Login> optionalLogin = loginService.getLoginByEmail(principal.getName());
        if (optionalLogin.isEmpty()) {
            return new ModelAndView("redirect:http://localhost:8080/error", modelMap);
        }
        Resident resident = residentService.getResidentByEmail(optionalLogin.get().getEmail()).get();
        Integer residentID = resident.getResidentId();

        newResidentPost.setResidentId(residentID);
        newResidentPost.setResidentByResidentId(residentService.getResidentById(CurrentUser.getResident().getResidentId()));
        newResidentPost.setDateTimePosted(LocalDateTime.now());
        residentNoticeBoardService.saveResidentNotice(newResidentPost);
        return new ModelAndView("redirect:http://localhost:8080/residentNoticeBoard", modelMap);
    }

    @PostMapping("/residentNoticeBoardDelete")
    public ModelAndView postResidentNoticeBoardDelete(@RequestParam int postId) {
        residentNoticeBoardService.deleteNotice(postId);
        return new ModelAndView("redirect:http://localhost:8080/residentNoticeBoard");
    }

    @GetMapping("/residentBooking")
    public String getResidentBooking(Model model) {
        model.addAttribute("recRoomTypes", recreationalRoomTypeService.getRecRoomTypes());
        model.addAttribute("booking", new Booking());
        return "/resident/residentBooking";
    }

    @PostMapping("/submitResidentBooking")
    public String postResidentBooking(@ModelAttribute Booking booking, Model model) {
        booking.setResidentId(CurrentUser.getResident().getResidentId());
        booking.setStatus("Pending");
        bookingService.saveBooking(booking);
        return "/resident/submitResidentBooking";
    }

    @GetMapping("/reportIssue")
    public String reportIssueForm(Model model) {
        model.addAttribute("issue", new Issue());
        return "/resident/issueRequestForm";
    }

    @PostMapping("/submitIssueForm")
    public String contactUsSubmit(@ModelAttribute Issue issue){
        issue.setStatus("Pending");
        issue.setDateTimePosted(LocalDateTime.now());
        issueService.saveIssue(issue);

        return "/resident/issueSubmitSuccess";
    }
}
