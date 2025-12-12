package com.message.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.message.dto.ChatMessageEvent;
import com.message.service.MessageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageKafkaListener {
	
	private final MessageService messageService;
	
	@KafkaListener(topics = "message-sent" , groupId = "messaging-service")
	public void onMessageReceived(ChatMessageEvent event) {
		
		messageService.saveIncomingMessage(event);
		
	}

}
