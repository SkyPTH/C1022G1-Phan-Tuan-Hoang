package com.example.riotshop_api.sercurity.request;

import java.util.Set;

public class SignUpForm {
    private String username;
    private String password;
    private Set<String> roles;
    private String email;
    private String phoneNumber;

    public SignUpForm() {
    }

    public SignUpForm(String username, String password, Set<String> roles, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}