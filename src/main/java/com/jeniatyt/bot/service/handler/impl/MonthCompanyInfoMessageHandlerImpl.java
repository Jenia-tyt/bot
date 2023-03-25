package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.component.button.ButtonUtils;
import com.jeniatyt.bot.component.button.impl.DayCompanyInfoButton;
import com.jeniatyt.bot.component.button.impl.WeekCompanyInfoButton;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class MonthCompanyInfoMessageHandlerImpl implements MessageHandler {
    public static final String KEY_MCI = "mci";
    
    @Override
    public int getOrder() {
        return 5;
    }
    
    @Override
    public String getKey() {
        return KEY_MCI;
    }
    
    @Override
    public String getDescription() {
        return "Информация по компании за месяц НЕРЕАЛИЗОВАННО";
    }
    
    @Override
    public void enrichAnswer(SendMessage answer) {
        answer.setReplyMarkup(
            ButtonUtils.inlineMarkup(
                new WeekCompanyInfoButton().get(),
                new DayCompanyInfoButton().get()
            )
        );
    }
}
