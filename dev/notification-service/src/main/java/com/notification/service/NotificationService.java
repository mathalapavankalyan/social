package com.notification.service;

import org.springframework.stereotype.Service;

import com.notification.dto.ChatMessageEvent;

@Service
public interface NotificationService {

	void sendNotification(ChatMessageEvent event);

}
