package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.ExcludeCompanyMessageHandlerImpl.KEY_EC;

public class ExcludeCompanyButton implements Button {
    private static final InlineKeyboardButton EXCLUDE_COMPANY_BUTTON =
        new InlineKeyboardButton("Исключить эту компанию из поиска");
    
    public ExcludeCompanyButton(String sicId) {
        EXCLUDE_COMPANY_BUTTON.setCallbackData(KEY_EC + " " + sicId);
    }
    
    public InlineKeyboardButton get() {
        return EXCLUDE_COMPANY_BUTTON;
    }
}
