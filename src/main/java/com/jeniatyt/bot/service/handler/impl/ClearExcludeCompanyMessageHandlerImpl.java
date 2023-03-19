package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class ClearExcludeCompanyMessageHandlerImpl implements MessageHandler {
    public static final String KEY_CEC = "cec";
    
    @Override
    public String getKey() {
        return KEY_CEC;
    }
    
    @Override
    public String getDescription() {
        return "Очистить список исключенных компаний";
    }
    
    @Override
    public int getOrder() {
        return 0;
    }
}
