package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

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
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText(getDescription());
        return answer;
    }
}
