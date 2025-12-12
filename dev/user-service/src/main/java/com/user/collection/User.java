package com.user.collection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class User {

    @Id
    private ObjectId userId;

    private String userName;
    private String fullName;
    private ObjectId profilePictureId;
    private String status;     // ACTIVE / INACTIVE / ONLINE / OFFLINE
}
