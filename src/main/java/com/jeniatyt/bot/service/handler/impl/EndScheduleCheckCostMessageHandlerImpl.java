package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;

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
}
