package com.projeto.backend.helpdesk.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.projeto.backend.helpdesk.enums.ProfileEnum;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;

    @NotBlank(message = "Email required")
    @Email(message = "Email invalid")
    private String email;

    @NotBlank(message = "Password invalid")
    @Size(min = 6)
    private String password;

    private ProfileEnum profile;


    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }
    
}