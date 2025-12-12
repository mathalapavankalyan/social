package com.message.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.message.collection.Message;

public interface MessageRepository extends MongoRepository<Message,ObjectId>{

}
