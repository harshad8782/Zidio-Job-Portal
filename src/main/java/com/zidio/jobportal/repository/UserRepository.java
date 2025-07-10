package com.zidio.jobportal.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.jobportal.entity.User;
import com.zidio.jobportal.enums.Role;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    long countByRole(Role role);
    long countByIsBlocked(boolean isBlocked);
    long countByIsOnline(boolean isOnline);
    List<User> findByRole(com.zidio.jobportal.enums.Role role);
    List<User> findByIsBlocked(boolean blocked);
    List<User> findByIsOnline(boolean isOnline);
    List<User> findByEmailContainingIgnoreCaseOrNameContainingIgnoreCase(String email, String name);

}
