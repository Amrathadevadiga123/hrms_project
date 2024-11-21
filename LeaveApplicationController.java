package com.MagadhUniversity.HRMS_MU.controller;

import com.MagadhUniversity.HRMS_MU.model.LeaveApplication;
import com.MagadhUniversity.HRMS_MU.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/leaves")
public class LeaveApplicationController {

    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @GetMapping("/create")
    public String createLeaveForm(Model model) {
        model.addAttribute("leaveApplication", new LeaveApplication());
        return "create_leave";
    }

    @PostMapping
    public String createLeave(@ModelAttribute LeaveApplication leaveApplication) {
        leaveApplicationService.createLeaveApplication(leaveApplication);
        return "redirect:/leaves";
    }

    @GetMapping
    public String listLeaves(Model model) {
        List<LeaveApplication> leaves = leaveApplicationService.getAllLeaveApplications();
        model.addAttribute("leaves", leaves);
        return "list_leaves";
    }

    @GetMapping("/view/{id}")
    public String viewLeave(@PathVariable Long id, Model model) {
        LeaveApplication leaveApplication = leaveApplicationService.getLeaveApplicationById(id);
        model.addAttribute("leaveApplication", leaveApplication);
        return "view_leave";
    }

    @PostMapping("/update/{id}")
    public String updateLeaveStatus(@PathVariable Long id, @RequestParam String status) {
        leaveApplicationService.updateLeaveApplicationStatus(id, status);
        return "redirect:/leaves";
    }

    @PostMapping("/delete/{id}")
    public String deleteLeave(@PathVariable Long id) {
        leaveApplicationService.deleteLeaveApplication(id);
        return "redirect:/leaves";
    }
}
