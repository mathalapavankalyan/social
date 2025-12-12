package com.auth.service.impl;

import org.springframework.stereotype.Service;

import com.auth.client.UserClient;
import com.auth.collection.AuthUser;
import com.auth.dto.AuthResponse;
import com.auth.dto.LoginRequest;
import com.auth.dto.RegisterRequest;
import com.auth.dto.UserDto;
import com.auth.repository.AuthUserRepository;
import com.auth.security.JwtService;
import com.auth.service.AuthService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthUserRepository authUserRepository;
    private final UserClient userClient;
    private final JwtService jwtService;
    private final org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterRequest request) {

        // 1. Check if username already exists
        if (authUserRepository.findByUserName(request.getUserName()).isPresent()) {
            throw new RuntimeException("User already exists with username: " + request.getUserName());
        }

        // 2. Save AuthUser (credentials)
        AuthUser newUser = new AuthUser();
        newUser.setUserName(request.getUserName());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        authUserRepository.save(newUser);

        // 3. Create user profile in user-service via Feign
        UserDto userDto = new UserDto();
        userDto.setUserName(request.getUserName());
        userDto.setFullName(request.getFullName());
        userDto.setStatus("ACTIVE");

        userClient.createUser(userDto);

        // 4. Generate JWT token
        String token = jwtService.generateToken(newUser.getUserName());

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        // 1. Check if username exists
        AuthUser existingUser = authUserRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        // 2. Validate password
        if (!passwordEncoder.matches(request.getPassword(), existingUser.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        // 3. Generate JWT
        String token = jwtService.generateToken(existingUser.getUserName());

        return new AuthResponse(token);
    }
}
