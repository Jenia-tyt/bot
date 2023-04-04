package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class StopCronCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_ESCC = "escc";
    
    @Override
    public int getOrder() {
        return 9;
    }
    
    @Override
    public String getKey() {
        return KEY_ESCC;
    }
    
    @Override
    public String getDescription() {
        return """
            Останавливает крон [команда secId]
            """;
    }
}
