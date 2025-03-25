package com.fashion.backend.eccommerce_backend.api.controller.auth;

import com.fashion.backend.eccommerce_backend.api.model.RegistrationBody;
import com.fashion.backend.eccommerce_backend.exception.UserAlreadyExistException;
import com.fashion.backend.eccommerce_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody RegistrationBody registrationBody) {
        try{
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
