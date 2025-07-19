package com.zidio.jobportal.dto;

public class AdminActionDTO {
    public Long userId; // Added userId field
    public String email;
    public Boolean block; // ✅ Must be Boolean, not boolean

    public AdminActionDTO() {}

    public AdminActionDTO(Long userId, String email, Boolean block) {
        this.userId = userId;
        this.email = email;
        this.block = block;
    }
}
