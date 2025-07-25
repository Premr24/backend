package com.noticehub.controller;

import com.noticehub.entity.User;
import com.noticehub.response.JwtResponse;
import com.noticehub.request.LoginRequest;
import com.noticehub.repository.UserRepository;
import com.noticehub.security.JwtHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    //Provides /login endpoint

    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequest loginRequest) {

        // Authenticate using Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword())
        );

        // Fetch user from DB
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        String userRole = user.getRole().getName().toUpperCase(); // Just fetch from DB


        // Generate token
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                java.util.List.of(() -> "ROLE_" + userRole)
        );

        String token = jwtHelper.generateToken(userDetails, userRole);

        // Build response
        JwtResponse response = JwtResponse.builder()
                .token(token)
                .email(user.getEmail())
                .role(userRole)
                .build();

        return ResponseEntity.ok(response);
    }
}
