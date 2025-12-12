package com.message.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.message.collection.Message;
import com.message.dto.ChatMessageEvent;
import com.message.kafka.KafkaProducerService;
import com.message.repository.MessageRepository;
import com.message.service.MessageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{
	
	private final MessageRepository messageRepository;
	
	private final KafkaProducerService kafkaProducerService;

	@Override
	public void saveIncomingMessage(ChatMessageEvent event) {
		 Message message = new Message();
	        message.setSenderId(event.getSenderId());
	        message.setReceiverId(event.getReceiverId());
	        message.setContent(event.getContent());
	        message.setType(event.getType());
	        message.setTimestamp(event.getTimestamp());
	        Message savedMessage = messageRepository.save(message);
	        event.setMessageId(savedMessage.getId().toHexString());
	        kafkaProducerService.send("message-delivered", event);
		
	}
	
	
	
	@Override
	public List<Message> getChatHistory(String senderId, String receiverId) {
	    return messageRepository.findAll().stream()
	            .filter(m ->
	                    (m.getSenderId().equals(senderId) && m.getReceiverId().equals(receiverId)) ||
	                    (m.getSenderId().equals(receiverId) && m.getReceiverId().equals(senderId))
	            )
	            .toList();
	}

	@Override
	public List<Message> getAllMessagesForUser(String userId) {
	    return messageRepository.findAll().stream()
	            .filter(m ->
	                    m.getSenderId().equals(userId) ||
	                    m.getReceiverId().equals(userId)
	            )
	            .toList();
	}


}
