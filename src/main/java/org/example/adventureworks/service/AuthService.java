package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.LoginRequest;

public interface AuthService {
    String login(LoginRequest loginRequest);
}
