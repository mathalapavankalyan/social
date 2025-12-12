package com.websocket.service;

import com.websocket.dto.ChatMessageEvent;

public interface WebSocketService {
    void sendToUser(String userId, ChatMessageEvent event);
}
