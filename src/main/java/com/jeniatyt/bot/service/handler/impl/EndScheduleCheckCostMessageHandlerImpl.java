package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

@Service
public class EndScheduleCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_ESCC = "escc";
    
    @Override
    public int getOrder() {
        return 10;
    }
    
    @Override
    public String getKey() {
        return KEY_ESCC;
    }
    
    @Override
    public String getDescription() {
        return "Завершаем крон по компании";
    }
    
    @Override
    public Optional<SendMessage> handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setReplyToMessageId(message.getMessageId());
        answer.setChatId(message.getChatId());
        answer.setText("""
            Завершаем крон по компании
            """);
        return Optional.of(answer);
    }
}
