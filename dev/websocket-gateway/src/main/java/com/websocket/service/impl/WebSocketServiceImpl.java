package com.websocket.service.impl;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.websocket.dto.ChatMessageEvent;
import com.websocket.service.WebSocketService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WebSocketServiceImpl implements WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public void sendToUser(String userId, ChatMessageEvent event) {
        messagingTemplate.convertAndSend("/topic/" + userId, event);
    }
}
