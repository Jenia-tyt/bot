package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class AllHistoryMessageHandlerImpl implements MessageHandler {
    public static final String KEY_AH = "ah";
    
    @Override
    public String getKey() {
        return KEY_AH;
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText("""
            Тут возвращаем компании и их конкурентов за все время которые предлагали,
            с коэффициентами и графиком и описанием
            (Храним только за 3 месяца)
            """);
        return answer;
    }
}
