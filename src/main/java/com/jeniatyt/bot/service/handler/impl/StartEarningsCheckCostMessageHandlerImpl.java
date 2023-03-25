
package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class StartEarningsCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_SECC = "secc";
    
    @Override
    public int getOrder() {
        return 11;
    }
    
    @Override
    public String getKey() {
        return KEY_SECC;
    }
    
    @Override
    public String getDescription() {
        return "Запускаем крон который, присылает сколько заработал по сделанной сделки НЕРЕАЛИЗОВАННО";
    }
}
