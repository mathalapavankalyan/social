package com.auth.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String userName;
    private String password;
    private String fullName;
}
