package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class EndScheduleCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_ESCC = "escc";
    
    @Override
    public String getKey() {
        return KEY_ESCC;
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText("""
            Завершаем крон по компании
            """);
        return answer;
    }
}
