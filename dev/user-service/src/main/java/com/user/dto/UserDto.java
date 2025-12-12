package com.user.dto;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class UserDto {

    private ObjectId userId;
    private String userName;
    private String fullName;
    private String status;
    private ObjectId profilePictureId;  
}
