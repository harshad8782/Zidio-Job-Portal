package com.zidio.jobportal.controller;

import com.zidio.jobportal.entity.Notification;
import com.zidio.jobportal.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody NotificationRequest request) {
        // Get authenticated user's email
        String email = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
        Notification notification = notificationService.createNotification(email, request.title, request.message, request.type);
        return ResponseEntity.ok(notification);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getMyNotifications() {
        String email = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName();
        List<Notification> notifications = notificationService.getNotificationsForUser(email);
        return ResponseEntity.ok(notifications);
    }

    @PostMapping("/read/{id}")
    public ResponseEntity<Notification> markAsRead(@PathVariable Long id) {
        Notification notification = notificationService.markAsRead(id);
        return ResponseEntity.ok(notification);
    }

    // DTO for request body
    public static class NotificationRequest {
        public String title;
        public String message;
        public String type;
    }
}
