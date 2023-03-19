package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.MonthCompanyInfoMessageHandlerImpl.KEY_MCI;

public class MonthCompanyInfoButton implements Button {
    private static final InlineKeyboardButton MONTH_INFO_BUTTON = new InlineKeyboardButton("Инф. за месяц");
    
    public MonthCompanyInfoButton() {
        MONTH_INFO_BUTTON.setCallbackData(KEY_MCI);
    }
    
    @Override
    public InlineKeyboardButton get() {
        return MONTH_INFO_BUTTON;
    }
}
