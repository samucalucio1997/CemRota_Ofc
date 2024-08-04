package com.rota.cemrota.security;

import com.rota.cemrota.service.request.LoginRequest;

public class Login {
    private String username;
    private String password;

    public Login(LoginRequest loginRequest) {
        this.username = loginRequest.username();
        this.password = loginRequest.password();
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
}
