package com.message.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.message.collection.Message;
import com.message.dto.ChatMessageEvent;

@Service
public interface MessageService {


	    void saveIncomingMessage(ChatMessageEvent event);
	    List<Message> getChatHistory(String senderId, String receiverId);
	    List<Message> getAllMessagesForUser(String userId);


}
