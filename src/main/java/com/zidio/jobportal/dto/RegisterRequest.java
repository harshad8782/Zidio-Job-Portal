package com.zidio.jobportal.dto;

public class RegisterRequest {

    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private String name; // Deprecated, use firstName and lastName instead
    private String email;
    private String password;
    private String role; // We use String here for flexible deserialization

    public RegisterRequest() {}

    public RegisterRequest(String username, String firstName, String lastName, String phone, String email, String password, String role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
