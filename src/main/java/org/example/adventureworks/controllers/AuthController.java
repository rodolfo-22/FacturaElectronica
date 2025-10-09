package org.example.adventureworks.controllers;

import org.example.adventureworks.models.dto.Request.LoginRequest;
import org.example.adventureworks.models.dto.Response.TokenResponse;
import org.example.adventureworks.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);
        TokenResponse.builder().accessToken(token).build();
        return ResponseEntity.ok(TokenResponse.builder().accessToken(token).build());
    }
}
