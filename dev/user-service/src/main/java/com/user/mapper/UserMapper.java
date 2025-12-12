package com.user.mapper;

import com.user.collection.User;
import com.user.dto.UserDto;

public class UserMapper {

    private UserMapper() {} 

    public static User toEntity(UserDto dto) {
        if (dto == null) return null;

        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUserName(dto.getUserName());
        user.setFullName(dto.getFullName());
        user.setStatus(dto.getStatus());
        user.setProfilePictureId(dto.getProfilePictureId());
        return user;
    }

    public static UserDto toDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setFullName(user.getFullName());
        dto.setStatus(user.getStatus());
        dto.setProfilePictureId(user.getProfilePictureId());
        return dto;
    }

}
