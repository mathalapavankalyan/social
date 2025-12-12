package com.websocket.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.websocket.dto.ChatMessageEvent;
import com.websocket.service.WebSocketService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageDeliveredListener {

    private final WebSocketService webSocketService;

    @KafkaListener(topics = "message-delivered", groupId = "websocket-gateway")
    public void onMessageDelivered(ChatMessageEvent event) {
        webSocketService.sendToUser(event.getReceiverId(), event);
    }
}
