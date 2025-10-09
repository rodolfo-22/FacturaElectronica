package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.Security.JwtTokenProvider;
import org.example.adventureworks.models.dto.Request.LoginRequest;
import org.example.adventureworks.service.AuthService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    AuthenticationManager authenticationManager;
    JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginRequest loginRequest) {

        System.out.println("Login request received for email: " + loginRequest.getEmail() + " and password: " + loginRequest.getPassword());

        // Authenticates the user using the provided username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(), // User's email
                        loginRequest.getPassword()  // User's password
                )
        );

        // Sets the authentication in Spring Security's context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generates a JWT token for the authenticated user
        String token = jwtTokenProvider.generateToken(authentication);

        // Returns the generated token
        return token;
    }
}
