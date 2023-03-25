package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.HalfYearCompanyInfoMessageHandlerImpl.KEY_HYCI;

public class YearCompanyInfoButton implements Button {
    private static final InlineKeyboardButton YEAR_INFO_BUTTON = new InlineKeyboardButton("Инф. за год");
    
    public YearCompanyInfoButton() {
        YEAR_INFO_BUTTON.setCallbackData(KEY_HYCI);
    }
    
    @Override
    public InlineKeyboardButton get() {
        return YEAR_INFO_BUTTON;
    }
}
