package com.zidio.jobportal.controller;

import com.zidio.jobportal.dto.AdminActionDTO;
import com.zidio.jobportal.dto.AdminDashboardDTO;
import com.zidio.jobportal.dto.UserStatusDTO;
import com.zidio.jobportal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/block")
    public ResponseEntity<String> blockUser(@RequestBody AdminActionDTO action) {
        return ResponseEntity.ok(adminService.blockOrUnblock(action));
    }

    @GetMapping("/status")
    public ResponseEntity<List<UserStatusDTO>> getAllUserStatus() {
        return ResponseEntity.ok(adminService.getAllUserStatus());
    }

    @GetMapping("/summary")
    public ResponseEntity<AdminDashboardDTO> getSummary() {
        return ResponseEntity.ok(adminService.getDashboardSummary());
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<UserStatusDTO>> getAllUserStatuses() {
        return ResponseEntity.ok(adminService.getAllUserStatus());
    }
    @GetMapping("/search")
public ResponseEntity<List<UserStatusDTO>> searchUsers(
        @RequestParam(required = false) String query,
        @RequestParam(required = false) String role,
        @RequestParam(required = false) Boolean blocked,
        @RequestParam(required = false) Boolean online) {
    return ResponseEntity.ok(adminService.searchUsers(query, role, blocked, online));
}
}
