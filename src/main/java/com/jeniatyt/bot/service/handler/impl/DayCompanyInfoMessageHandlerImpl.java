package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class DayCompanyInfoMessageHandlerImpl implements MessageHandler {
    public static final String KEY_DCI = "dci";
    
    @Override
    public int getOrder() {
        return 7;
    }
    
    @Override
    public String getKey() {
        return KEY_DCI;
    }
    
    @Override
    public String getDescription() {
        return "Информация по компании за день";
    }
}
