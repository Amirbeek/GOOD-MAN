package com.fashion.backend.eccommerce_backend.api.model;

public class LoginResponse {
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    private String jwt;

}
