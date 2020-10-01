package com.sparta.panda.uos_manager.admin.controllers;

import com.sparta.panda.uos_manager.admin.services.*;
import com.sparta.panda.uos_manager.common.entities.AdminNotice;
import com.sparta.panda.uos_manager.common.entities.Resident;
import com.sparta.panda.uos_manager.common.services.EnquiryService;
import com.sparta.panda.uos_manager.common.services.BookingService;
import com.sparta.panda.uos_manager.common.services.IssueService;
import com.sparta.panda.uos_manager.common.services.ResidentService;
import com.sparta.panda.uos_manager.common.utilities.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class AdminController {

    private final AdminNoticeService adminNoticeService;
    private final IssueService issueService;
    private final ResidentService residentService;
    private final OccupancyService occupancyService;
    private final DeliveryService deliveryService;
    private final BookingService bookingService;
    private final EnquiryService enquiryService;
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminNoticeService adminNoticeService, IssueService issueService, ResidentService residentService,
                           OccupancyService occupancyService, DeliveryService deliveryService,
                           BookingService bookingService, EnquiryService enquiryService, AdminService adminService) {
        this.adminNoticeService = adminNoticeService;
        this.issueService = issueService;
        this.residentService = residentService;
        this.occupancyService = occupancyService;
        this.deliveryService = deliveryService;
        this.bookingService = bookingService;
        this.enquiryService = enquiryService;
        this.adminService = adminService;
    }


    @GetMapping("/adminHome")
    public String getAdminHome() {
        return "admin/admin";
    }

    @GetMapping("/adminNewResidentForm")
    public String getResidentForm(ModelMap modelMap) {
        modelMap.addAttribute("resident", new Resident());
        return "admin/newResidentForm";
    }

    @GetMapping("/adminNoticeBoard")
    public String getAdminPosts(ModelMap modelMap) {
        modelMap.addAttribute("adminNotices", adminNoticeService.getAllNoticesOrderedByDateTimePostedDesc());
        return "admin/adminNoticeBoard";
    }

    @GetMapping("/adminNoticeBoardCreatePost")
    public String adminNotices(Model model) {
        model.addAttribute("newAdminPost", new AdminNotice());
        return "/admin/adminNoticeBoardCreatePost";
    }

    @PostMapping("/adminNoticeBoardCreatePost")
    public ModelAndView postAdminNoticeBoardCreatePost(@ModelAttribute AdminNotice newAdminPost, ModelMap modelMap) {
        newAdminPost.setAdminId(CurrentUser.getAdmin().getAdminId());
        newAdminPost.setAdminByAdminId(adminService.getAdminById(CurrentUser.getAdmin().getAdminId()));
        newAdminPost.setDateTimePosted(LocalDateTime.now());
        adminNoticeService.saveAdminNotice(newAdminPost);
        return new ModelAndView("redirect:http://localhost:8080/adminNoticeBoard", modelMap);
    }

    @PostMapping("/adminNoticeBoardDelete")
    public ModelAndView postAdminNoticeBoardDelete(@RequestParam int postId) {
        adminNoticeService.deleteNotice(postId);
        return new ModelAndView("redirect:http://localhost:8080/adminNoticeBoard");
    }

    @PostMapping("/submitNewResident")
    public ModelAndView addNewResident(@ModelAttribute Resident resident) {
        residentService.addNewResident(resident);
        return new ModelAndView("redirect:http://localhost:8080/adminResident");
    }

    @PostMapping("/updateIssue")
    public ModelAndView updateIssue(@RequestParam Integer issueID, ModelMap modelMap) {
        issueService.markIssueAsCompletedById(issueID);
        return new ModelAndView("redirect:http://localhost:8080/adminIssue", modelMap);
    }

    @PostMapping("/approveBooking")
    public ModelAndView approveBooking(@RequestParam Integer bookingID, ModelMap modelMap) {
        bookingService.approveBookingById(bookingID);
        return new ModelAndView("redirect:http://localhost:8080/adminBooking", modelMap);
    }

    @PostMapping("/removeBooking")
    public ModelAndView removeBooking(@RequestParam Integer bookingID, ModelMap modelMap) {
        bookingService.deleteBookingById(bookingID);
        return new ModelAndView("redirect:http://localhost:8080/adminBooking", modelMap);
    }

    @PostMapping("approveEnquiry")
    public ModelAndView approveEnquiry(@RequestParam Integer enquiryID, ModelMap modelMap) {
        enquiryService.approveEnquiryById(enquiryID);
        return new ModelAndView("redirect:http://localhost:8080/adminEnquiry", modelMap);
    }

    @PostMapping("rejectEnquiry")
    public ModelAndView rejectEnquiry(@RequestParam Integer enquiryID, ModelMap modelMap) {
        enquiryService.rejectEnquiryById(enquiryID);
        return new ModelAndView("redirect:http://localhost:8080/adminEnquiry", modelMap);
    }

    @PostMapping("/markDelivery")
    public ModelAndView markDeliveryAsCollected(@RequestParam Integer deliveryID, ModelMap modelMap) {
        deliveryService.updateDeliveryStatusById(deliveryID);
        return new ModelAndView("redirect:http://localhost:8080/adminDelivery", modelMap);
    }

    @GetMapping("/adminIssue")
    public String getIssues(ModelMap modelMap) {
        modelMap.addAttribute("issues", issueService.getAllIssues());
        return "/admin/allIssues";
    }

    @GetMapping("/adminResident")
    public String getResidents(ModelMap modelMap) {
        modelMap.addAttribute("residents", residentService.getAllResidents());
        return "/admin/allResidents";
    }

    @GetMapping("/adminOccupancy")
    public String getOccupancies(ModelMap modelMap) {
        modelMap.addAttribute("occupancies", occupancyService.getAllOccupancies());
        return "/admin/allOccupancies";
    }

    @GetMapping("/adminDelivery")
    public String getDeliveries(ModelMap modelMap) {
        modelMap.addAttribute("deliveries", deliveryService.getAllDeliveries());
        return "/admin/allDeliveries";
    }

    @GetMapping("/adminBooking")
    public String getBookings(ModelMap modelMap) {
        modelMap.addAttribute("bookings", bookingService.getAlBookings());
        return "/admin/allBookings";
    }

    @GetMapping("/adminEnquiry")
    public String getEnquiries(ModelMap modelMap) {
        modelMap.addAttribute("enquiries", enquiryService.getAllEnquiries());
        return "/admin/allEnquiries";
    }

}
