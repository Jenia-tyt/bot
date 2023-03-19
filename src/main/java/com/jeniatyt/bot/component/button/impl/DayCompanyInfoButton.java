package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.DayCompanyInfoMessageHandlerImpl.KEY_DCI;

public class DayCompanyInfoButton implements Button {
    private static final InlineKeyboardButton DAY_COMPANY_INFO_BUTTON = new InlineKeyboardButton("Инф. за день");
    
    public DayCompanyInfoButton() {
        DAY_COMPANY_INFO_BUTTON.setCallbackData(KEY_DCI);
    }
    
    @Override
    public InlineKeyboardButton get() {
        return DAY_COMPANY_INFO_BUTTON;
    }
}
