package com.user.service.impl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.user.collection.User;
import com.user.dto.UserDto;
import com.user.helper.GridService;
import com.user.mapper.UserMapper;
import com.user.repository.UserRepository;
import com.user.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final GridService gridService;
    private final UserRepository userRepository;

    @Override
    public String uploadProfilePicture(ObjectId userId, MultipartFile profilePictureFile) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not found"));

        if (user.getProfilePictureId() != null) {
            gridService.deleteFile(user.getProfilePictureId());
        }

        ObjectId fileId = gridService.saveFile(profilePictureFile);
        user.setProfilePictureId(fileId);
        userRepository.save(user);

        return "Profile photo saved successfully!";
    }

    @Override
    public GridFsResource getProfileImage(ObjectId userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getProfilePictureId() == null) {
            throw new RuntimeException("User has no profile picture");
        }

        return gridService.getFile(user.getProfilePictureId());
    }

    @Override
    public UserDto createUser(UserDto dto) {
        User user = UserMapper.toEntity(dto);
        user = userRepository.save(user);
        return UserMapper.toDto(user);
    }

    @Override
    public UserDto getUser(ObjectId userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(UserDto dto) {

        if (dto.getUserId() == null) {
            throw new RuntimeException("User ID must not be null for update");
        }

        User existingUser = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUserName(dto.getUserName());
        existingUser.setFullName(dto.getFullName());
        existingUser.setStatus(dto.getStatus());

        existingUser = userRepository.save(existingUser);

        return UserMapper.toDto(existingUser);
    }

    @Override
    public void deleteUser(ObjectId userId) {

        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (existingUser.getProfilePictureId() != null) {
            gridService.deleteFile(existingUser.getProfilePictureId());
        }

        userRepository.delete(existingUser);
    }
}
