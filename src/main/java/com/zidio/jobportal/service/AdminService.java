package com.zidio.jobportal.service;

import com.zidio.jobportal.dto.AdminActionDTO;
import com.zidio.jobportal.dto.AdminDashboardDTO;
import com.zidio.jobportal.dto.UserStatusDTO;
import com.zidio.jobportal.entity.User;
import com.zidio.jobportal.enums.Role;
import com.zidio.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public String blockOrUnblock(AdminActionDTO action) {
        if (action.block == null) {
            throw new IllegalArgumentException("Block value must be true or false");
        }

        User user = userRepository.findByEmail(action.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setIsBlocked(action.block);
        userRepository.save(user);

        return action.block ? "User blocked" : "User unblocked";
    }

    public List<UserStatusDTO> getAllUserStatus() {
        return userRepository.findAll().stream()
                .map(u -> new UserStatusDTO(
                        u.getEmail(),
                        u.getIsOnline(),
                        u.getIsBlocked()
                ))
                .collect(Collectors.toList());
    }

    public AdminDashboardDTO getDashboardSummary() {
        long totalUsers = userRepository.count();
        long totalStudents = userRepository.countByRole(Role.STUDENT);
        long totalRecruiters = userRepository.countByRole(Role.RECRUITER);
        long blockedUsers = userRepository.countByIsBlocked(true);
        long activeUsers = userRepository.countByIsOnline(true);

        return new AdminDashboardDTO(
                totalUsers,
                totalStudents,
                totalRecruiters,
                blockedUsers,
                activeUsers
        );
    }

    public List<UserStatusDTO> searchUsers(String query, String role, Boolean blocked, Boolean online) {
        List<User> users = userRepository.findAll();

        return users.stream()
                .filter(u -> (query == null || u.getEmail().contains(query) || u.getName().contains(query)))
                .filter(u -> (role == null || u.getRole().name().equalsIgnoreCase(role)))
                .filter(u -> (blocked == null || u.getIsBlocked().equals(blocked)))
                .filter(u -> (online == null || u.getIsOnline().equals(online)))
                .map(u -> new UserStatusDTO(u.getEmail(), u.getIsOnline(), u.getIsBlocked()))
                .collect(Collectors.toList());
    }
}
