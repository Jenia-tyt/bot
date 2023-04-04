package com.jeniatyt.bot.service.handler.iface;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

public interface MessageHandler {
    String getKey();
    String getDescription();
    int getOrder();
    default Optional<SendMessage> handle(Message message, String[] arg) {
        SendMessage answer = new SendMessage();
        answer.setReplyToMessageId(message.getMessageId());
        answer.setChatId(message.getChatId());
        answer.setText(getDescription());
        enrichAnswer(answer);
        return Optional.of(answer);
    }
    
    default String getArguments(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String str : args) {
            builder.append(str.toUpperCase()).append(" ");
        }
        return builder.toString();
    }
    
    default void enrichAnswer(SendMessage answer) {
    }
    
    default boolean isShowInHelp() {
        return true;
    }
}
