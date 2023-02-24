package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class StartScheduleCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_SSCC = "sscc";
    
    @Override
    public String getKey() {
        return KEY_SSCC;
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText("""
            Запускаем крон который,
            присылает стоимость акций компании в диапазоне времени которое указали и кол-во раз
            """);
        return answer;
    }
}
