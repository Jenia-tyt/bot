package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.component.button.ButtonUtils;
import com.jeniatyt.bot.component.button.impl.DayCompanyInfoButton;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class WeekCompanyInfoMessageHandlerImpl implements MessageHandler {
    public static final String KEY_WCI = "wci";
    
    @Override
    public int getOrder() {
        return 6;
    }
    
    @Override
    public String getKey() {
        return KEY_WCI;
    }
    
    @Override
    public String getDescription() {
        return "Информация по компании за неделю НЕРЕАЛИЗОВАННО";
    }
    
    @Override
    public void enrichAnswer(SendMessage answer) {
        answer.setReplyMarkup(
            ButtonUtils.inlineMarkup(
                new DayCompanyInfoButton().get()
            )
        );
    }
}
