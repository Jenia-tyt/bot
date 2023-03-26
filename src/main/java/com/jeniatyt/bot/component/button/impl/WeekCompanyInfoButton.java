package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.WeekCompanyInfoMessageHandlerImpl.KEY_WCI;

public class WeekCompanyInfoButton implements Button {
    private static final InlineKeyboardButton WEEK_INFO_BUTTON = new InlineKeyboardButton("Инф. за неделю");
    
    public WeekCompanyInfoButton(String sicId) {
        WEEK_INFO_BUTTON.setCallbackData(KEY_WCI + " " + sicId);
    }
    
    @Override
    public InlineKeyboardButton get() {
        return WEEK_INFO_BUTTON;
    }
}
