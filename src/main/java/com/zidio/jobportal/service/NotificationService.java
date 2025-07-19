package com.zidio.jobportal.service;

import com.zidio.jobportal.entity.Notification;
import com.zidio.jobportal.entity.User;
import com.zidio.jobportal.repository.NotificationRepository;
import com.zidio.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private org.springframework.mail.javamail.JavaMailSender mailSender;

    public Notification createNotification(String email, String title, String message, String type) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found for email: " + email));
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setType(type);
        notification.setIsRead(false);
        notification.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        // Send email notification
        org.springframework.mail.SimpleMailMessage mail = new org.springframework.mail.SimpleMailMessage();
        mail.setTo(email);
        mail.setSubject(title);
        mail.setText(message);
        mailSender.send(mail);
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsForUser(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found for email: " + email));
        return notificationRepository.findByUser(user);
    }

    public Notification markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
            .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setIsRead(true);
        notification.setReadAt(new Timestamp(System.currentTimeMillis()));
        return notificationRepository.save(notification);
    }
}
