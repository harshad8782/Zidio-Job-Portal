package com.zidio.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.jobportal.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Student does not have an email field. Use findByUser_Email if needed.
}
