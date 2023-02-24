package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class CompanyCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_CC = "cc";
    
    @Override
    public String getKey() {
        return KEY_CC;
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText("""
            Тут возвращаем стоимость компании на данный момент
            """);
        return answer;
    }
}
