package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class AllExcludeCompanyMessageHandlerImpl implements MessageHandler {
    public static final String KEY_AEC = "aec";
    
    @Override
    public String getKey() {
        return KEY_AEC;
    }
    
    @Override
    public String getDescription() {
        return "Список исключенных компаний ";
    }
    
    @Override
    public int getOrder() {
        return 0;
    }
}
