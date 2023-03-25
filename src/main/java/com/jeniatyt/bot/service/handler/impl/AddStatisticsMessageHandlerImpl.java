package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class AddStatisticsMessageHandlerImpl implements MessageHandler {
    public static final String KEY_AS = "as";
    
    @Override
    public int getOrder() {
        return 8;
    }
    
    @Override
    public String getKey() {
        return KEY_AS;
    }
    
    @Override
    public String getDescription() {
        return "Добавить статистику о сделке НЕРЕАЛИЗОВАННО";
    }
}
