package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

@Service
public class StartScheduleCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_SSCC = "sscc";
    
    @Override
    public int getOrder() {
        return 9;
    }
    
    @Override
    public String getKey() {
        return KEY_SSCC;
    }
    
    @Override
    public String getDescription() {
        return "Запускаем крон который, присылает стоимость акций компании в диапазоне времени которое указали и кол-во раз";
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
