package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

@Service
public class DayCompanyInfoMessageHandlerImpl implements MessageHandler {
    public static final String KEY_DCI = "dci";
    
    @Override
    public int getOrder() {
        return 7;
    }
    
    @Override
    public String getKey() {
        return KEY_DCI;
    }
    
    @Override
    public String getDescription() {
        return "Информация по компании за день";
    }
    
    @Override
    public Optional<SendMessage> handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setReplyToMessageId(message.getMessageId());
        answer.setChatId(message.getChatId());
        answer.setText(getDescription());
        return Optional.of(answer);
    }
}
