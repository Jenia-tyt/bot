
package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

@Service
public class EndEarningsCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_EECC = "eecc";
    
    @Override
    public int getOrder() {
        return 12;
    }
    
    @Override
    public String getKey() {
        return KEY_EECC;
    }
    
    @Override
    public String getDescription() {
        return "Останавливает крон, присылает итоговый заработок";
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
