package com.zidio.jobportal.dto;

public class AdminDashboardDTO {
    public long totalUsers;
    public long totalStudents;
    public long totalRecruiters;
    public long blockedUsers;
    public long activeUsers;

    public AdminDashboardDTO(long totalUsers, long totalStudents, long totalRecruiters, long blockedUsers, long activeUsers) {
        this.totalUsers = totalUsers;
        this.totalStudents = totalStudents;
        this.totalRecruiters = totalRecruiters;
        this.blockedUsers = blockedUsers;
        this.activeUsers = activeUsers;
    }
}
