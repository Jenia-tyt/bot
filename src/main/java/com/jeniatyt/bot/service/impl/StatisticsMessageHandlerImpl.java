package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class StatisticsMessageHandlerImpl implements MessageHandler {
    public static final String KEY_S = "s";
    
    @Override
    public int getOrder() {
        return 8;
    }
    
    @Override
    public String getKey() {
        return KEY_S;
    }
    
    @Override
    public String getDescription() {
        return "Возвращает всю статистику операций и итог баланс и прибыль";
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText(getDescription());
        return answer;
    }
}
