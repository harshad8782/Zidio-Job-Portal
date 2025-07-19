package com.zidio.jobportal.repository;

import com.zidio.jobportal.entity.Notification;
import com.zidio.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUser(User user);
}
