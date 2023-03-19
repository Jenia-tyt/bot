
package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class EndEarningsCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_EECC = "eecc";
    
    @Override
    public int getOrder() {
        return 12;
    }
    
    @Override
    public String getKey() {
        return KEY_EECC;
    }
    
    @Override
    public String getDescription() {
        return "Останавливает крон, присылает итоговый заработок";
    }
}
