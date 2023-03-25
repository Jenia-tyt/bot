package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class StartScheduleCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_SSCC = "sscc";
    
    @Override
    public int getOrder() {
        return 9;
    }
    
    @Override
    public String getKey() {
        return KEY_SSCC;
    }
    
    @Override
    public String getDescription() {
        return "Запускаем крон который, присылает стоимость акций компании в диапазоне времени которое указали и кол-во раз НЕРЕАЛИЗОВАННО";
    }
}
