package com.auth.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.auth.collection.AuthUser;

@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser, ObjectId> {

    Optional<AuthUser> findByUserName(String userName);
}
