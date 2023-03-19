package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.ClearExcludeCompanyMessageHandlerImpl.KEY_CEC;

public class ClearAllExcludeCompaniesButton implements Button {
    private static final InlineKeyboardButton CLEAR_ALL_EXCLUDE_COMPANIES_BUTTON = new InlineKeyboardButton("Очистить список");
    
    public ClearAllExcludeCompaniesButton() {
        CLEAR_ALL_EXCLUDE_COMPANIES_BUTTON.setCallbackData(KEY_CEC);
    }
    
    @Override
    public InlineKeyboardButton get() {
        return CLEAR_ALL_EXCLUDE_COMPANIES_BUTTON;
    }
}
