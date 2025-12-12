package com.user.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.collection.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{

}
