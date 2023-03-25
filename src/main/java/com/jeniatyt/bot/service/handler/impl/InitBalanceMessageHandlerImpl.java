package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class InitBalanceMessageHandlerImpl implements MessageHandler {
    public static final String KEY_I = "i";
    
    @Override
    public int getOrder() {
        return 13;
    }
    
    @Override
    public String getKey() {
        return KEY_I;
    }
    
    @Override
    public String getDescription() {
        return "Инициализируешь/обновляешь свой баланс НЕРЕАЛИЗОВАННО";
    }
}
