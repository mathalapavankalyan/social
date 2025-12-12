package com.user.service;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

import com.user.dto.UserDto;

public interface UserService {

    String uploadProfilePicture(ObjectId userId, MultipartFile file);

    GridFsResource getProfileImage(ObjectId userId);

    UserDto createUser(UserDto dto);

    // (Optional future methods)
    UserDto getUser(ObjectId userId);
    UserDto updateUser(UserDto dto);
    void deleteUser(ObjectId userId);
}
