package com.zidio.jobportal.dto;

public class AdminActionDTO {
    public String email;
    public Boolean block; // ✅ Must be Boolean, not boolean

    public AdminActionDTO() {}

    public AdminActionDTO(String email, Boolean block) {
        this.email = email;
        this.block = block;
    }
}
