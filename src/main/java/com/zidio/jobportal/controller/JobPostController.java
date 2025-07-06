package com.zidio.jobportal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio.jobportal.dto.JobPostDTO;
import com.zidio.jobportal.service.JobPostService;

@RestController
@RequestMapping("/api/jobPosts")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @PostMapping
    public ResponseEntity<JobPostDTO> createJob(@RequestBody JobPostDTO dto) {
        return ResponseEntity.ok(jobPostService.postJob(dto));
    }

    @GetMapping("/recruiter")
    public ResponseEntity<List<JobPostDTO>> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok(jobPostService.getByPostedByEmail(email));
    }

    @GetMapping("/jobTitle")
    public ResponseEntity<List<JobPostDTO>> getByJobTitle(@RequestParam String jobTitle) {
        return ResponseEntity.ok(jobPostService.getByJobTitle(jobTitle));
    }

    @GetMapping("/jobType")
    public ResponseEntity<List<JobPostDTO>> getByJobType(@RequestParam String jobType) {
        return ResponseEntity.ok(jobPostService.getByJobType(jobType));
    }

    @GetMapping("/companyName")
    public ResponseEntity<List<JobPostDTO>> getByCompany(@RequestParam String companyName) {
        return ResponseEntity.ok(jobPostService.getByCompanyName(companyName));
    }
}
