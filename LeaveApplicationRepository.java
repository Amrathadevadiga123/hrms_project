package com.MagadhUniversity.HRMS_MU.repository;

import com.MagadhUniversity.HRMS_MU.model.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Long> {
}
