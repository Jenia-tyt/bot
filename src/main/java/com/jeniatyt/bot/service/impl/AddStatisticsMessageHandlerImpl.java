package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class AddStatisticsMessageHandlerImpl implements MessageHandler {
    public static final String KEY_AS = "as";
    
    @Override
    public int getOrder() {
        return 8;
    }
    
    @Override
    public String getKey() {
        return KEY_AS;
    }
    
    @Override
    public String getDescription() {
        return "Добавить статистику о сделке";
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText(getDescription());
        return answer;
    }
}
