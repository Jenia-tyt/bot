package com.jeniatyt.bot.service.iface;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface MessageHandler {
    String getKey();
    SendMessage handle(Message message);
    String getDescription();
    
    int getOrder();
    
    default boolean isShowInHelp() {
        return true;
    }
}
