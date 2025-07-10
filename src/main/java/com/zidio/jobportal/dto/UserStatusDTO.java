package com.zidio.jobportal.dto;

public class UserStatusDTO {
    public String email;
    public Boolean isOnline;
    public Boolean isBlocked;

    public UserStatusDTO(String email, Boolean isOnline, Boolean isBlocked) {
        this.email = email;
        this.isOnline = isOnline;
        this.isBlocked = isBlocked;
    }
}