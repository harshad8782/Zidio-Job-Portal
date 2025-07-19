package com.zidio.jobportal.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zidio.jobportal.entity.*;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    // Recruiter does not have an email field. Use findByUser_Email if needed.
}