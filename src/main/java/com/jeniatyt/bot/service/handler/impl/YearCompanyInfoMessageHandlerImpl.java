package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.component.button.ButtonUtils;
import com.jeniatyt.bot.component.button.impl.MonthCompanyInfoButton;
import com.jeniatyt.bot.component.button.impl.WeekCompanyInfoButton;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class YearCompanyInfoMessageHandlerImpl implements MessageHandler {
    public static final String KEY_YCI = "yci";
    
    @Override
    public int getOrder() {
        return 4;
    }
    
    @Override
    public String getKey() {
        return KEY_YCI;
    }
    
    @Override
    public String getDescription() {
        return "Информация по компании за год";
    }
    
    @Override
    public void enrichAnswer(SendMessage answer) {
        answer.setReplyMarkup(
            ButtonUtils.inlineMarkup(
                new MonthCompanyInfoButton().get(),
                new WeekCompanyInfoButton().get()
            )
        );
    }
}
