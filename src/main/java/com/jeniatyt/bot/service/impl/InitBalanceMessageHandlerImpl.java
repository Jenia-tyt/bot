package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class InitBalanceMessageHandlerImpl implements MessageHandler {
    public static final String KEY_I = "i";
    @Override
    public String getKey() {
        return KEY_I;
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText("""
            Инициализируешь/обновляешь свой баланс
            """);
        return answer;
    }
}
