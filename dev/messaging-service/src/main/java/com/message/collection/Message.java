package com.message.collection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("messages")
@Data
public class Message {
    @Id
    private ObjectId id;
    private String senderId;
    private String receiverId;
    private String content;
    private String type;
    private long timestamp;
}
