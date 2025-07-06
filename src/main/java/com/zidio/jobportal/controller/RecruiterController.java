package com.zidio.jobportal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zidio.jobportal.dto.RecruiterDTO;
import com.zidio.jobportal.service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @GetMapping("/email/{email}")
    public ResponseEntity<RecruiterDTO> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(recruiterService.getRecruiterByEmail(email));
    }

    @PostMapping
    public ResponseEntity<RecruiterDTO> createOrUpdate(@RequestBody RecruiterDTO dto) {
        return ResponseEntity.ok(recruiterService.createOrUpdateRecruiter(dto));
    }
}