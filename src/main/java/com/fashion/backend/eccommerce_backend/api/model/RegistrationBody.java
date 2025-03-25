package com.fashion.backend.eccommerce_backend.api.model;

import jakarta.validation.constraints.*;

public class RegistrationBody {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String username;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    @Size(min = 6, max = 32)
    private String password;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
