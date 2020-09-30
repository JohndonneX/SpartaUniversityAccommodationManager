package com.sparta.panda.uos_manager.admin.controllers;

import com.sparta.panda.uos_manager.admin.services.*;
import com.sparta.panda.uos_manager.common.entities.Resident;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final AdminService adminService;
    private final IssueService issueService;
    private final ResidentService residentService;
    private final OccupancyService occupancyService;
    private final DeliveryService deliveryService;
    private final BookingService bookingService;

    @Autowired
    public AdminController(AdminService adminService, IssueService issueService, ResidentService residentService,
                           OccupancyService occupancyService, DeliveryService deliveryService,
                           BookingService bookingService) {
        this.adminService = adminService;
        this.issueService = issueService;
        this.residentService = residentService;
        this.occupancyService = occupancyService;
        this.deliveryService = deliveryService;
        this.bookingService = bookingService;
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

}
