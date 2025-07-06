package com.zidio.jobportal.dto;

public class RecruiterDTO {
    public Long id;
    public String name;
    public String email;
    public String phone;
    public String company;
    public String designation;

    public RecruiterDTO() {}

    public RecruiterDTO(Long id, String name, String email, String phone, String company, String designation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.designation = designation;
    }
}
