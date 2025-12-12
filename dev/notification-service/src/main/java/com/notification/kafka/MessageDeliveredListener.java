package com.notification.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.notification.dto.ChatMessageEvent;
import com.notification.service.NotificationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageDeliveredListener {
	
	private final NotificationService notificationService;
	
	@KafkaListener(
			topics = "message-delivered" , 
			groupId = "notification-service" ,
			containerFactory = "kafkaListenerContainerFactory")
	public void handleDeliveredMessage(ChatMessageEvent event) {
        System.out.println("Received message-delivered event for user: " + event.getReceiverId());
        notificationService.sendNotification(event);

	}

}
