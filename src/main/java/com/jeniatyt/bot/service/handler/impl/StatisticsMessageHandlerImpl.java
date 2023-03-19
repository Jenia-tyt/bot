package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import com.jeniatyt.bot.service.queue.iface.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
@RequiredArgsConstructor
public class StatisticsMessageHandlerImpl implements MessageHandler {
    public static final String KEY_S = "s";
    
    private final MessageSender sender;
    
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
    public void enrichAnswer(SendMessage answer) {
        answer.setText("Сообщение приняли в обработку\n" + getDescription());

//        sender.send(message, REQUEST_STATISTIC_BROKER_TOPIC);
    }
}
