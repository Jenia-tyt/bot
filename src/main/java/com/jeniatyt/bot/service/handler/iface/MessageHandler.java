package com.jeniatyt.bot.service.handler.iface;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

public interface MessageHandler {
    String getKey();
    Optional<SendMessage> handle(Message message);
    String getDescription();
    
    int getOrder();
    
    default boolean isShowInHelp() {
        return true;
    }
}
