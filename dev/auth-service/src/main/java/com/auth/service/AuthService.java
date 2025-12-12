package com.auth.service;

import com.auth.dto.RegisterRequest;
import com.auth.dto.LoginRequest;
import com.auth.dto.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
