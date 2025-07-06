package com.zidio.jobportal.controller;

import com.zidio.jobportal.dto.JobApplicationDTO;
import com.zidio.jobportal.service.JobApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobapplications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @PostMapping
    public ResponseEntity<JobApplicationDTO> applyForJob(@RequestBody JobApplicationDTO dto) {
        return ResponseEntity.ok(jobApplicationService.applyForJob(dto));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<JobApplicationDTO>> getByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(jobApplicationService.getByStudentId(studentId));
    }

    @GetMapping("/job/{jobPostId}")
    public ResponseEntity<List<JobApplicationDTO>> getByJobPostId(@PathVariable Long jobPostId) {
        return ResponseEntity.ok(jobApplicationService.getByJobPostId(jobPostId));
    }
}
