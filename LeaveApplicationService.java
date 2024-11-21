package com.MagadhUniversity.HRMS_MU.service;

import com.MagadhUniversity.HRMS_MU.model.LeaveApplication;
import com.MagadhUniversity.HRMS_MU.repository.LeaveApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveApplicationService {

    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    public LeaveApplication createLeaveApplication(LeaveApplication leaveApplication) {
        return leaveApplicationRepository.save(leaveApplication);
    }

    public List<LeaveApplication> getAllLeaveApplications() {
        return leaveApplicationRepository.findAll();
    }

    public LeaveApplication getLeaveApplicationById(Long id) {
        Optional<LeaveApplication> leaveApplication = leaveApplicationRepository.findById(id);
        return leaveApplication.orElse(null);
    }

    public LeaveApplication updateLeaveApplicationStatus(Long id, String status) {
        LeaveApplication leaveApplication = getLeaveApplicationById(id);
        if (leaveApplication != null) {
            leaveApplication.setStatus(status);
            leaveApplicationRepository.save(leaveApplication);
        }
        return leaveApplication;
    }

    public void deleteLeaveApplication(Long id) {
        leaveApplicationRepository.deleteById(id);
    }
}
