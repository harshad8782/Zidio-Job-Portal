package com.zidio.jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;

    public Admin() {}
    public Admin(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & setters
}