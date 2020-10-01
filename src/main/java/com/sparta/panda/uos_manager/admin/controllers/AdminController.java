package com.sparta.panda.uos_manager.admin.controllers;

import com.sparta.panda.uos_manager.admin.services.*;
import com.sparta.panda.uos_manager.common.entities.Resident;
import com.sparta.panda.uos_manager.common.services.BookingService;
import com.sparta.panda.uos_manager.common.services.IssueService;
import com.sparta.panda.uos_manager.common.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/newResidentForm")
    public String getResidentForm(ModelMap modelMap) {
        modelMap.addAttribute("resident", new Resident());
        return "admin/newResidentForm";
    }

    @PostMapping("/submitNewResident")
    public String addNewResident(@ModelAttribute Resident resident) {
        residentService.addNewResident(resident);
        return "admin/allResidents";
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

}
