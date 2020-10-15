package com.website.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Fan {

    @NotBlank
    private final String userName;
    @NotBlank
    private final String password;
    @NotBlank
    private final String email;

    public Fan(@JsonProperty("username") String userName,
               @JsonProperty("password") String password,
               @JsonProperty("email") String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
