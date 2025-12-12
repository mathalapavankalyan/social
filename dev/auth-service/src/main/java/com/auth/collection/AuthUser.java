package com.auth.collection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "auth_users")
@Data
public class AuthUser {
	@Id
    private ObjectId id;

    private String userName;

    private String password; 

}
