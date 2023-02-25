package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.YearCompanyInfoMessageHandlerImpl.KEY_YCI;

@Component
public class YearCompanyInfoButton implements Button {
    public static final InlineKeyboardButton YEAR_INFO_BUTTON = new InlineKeyboardButton("Инф. за год");
    
    public YearCompanyInfoButton() {
        YEAR_INFO_BUTTON.setCallbackData(KEY_YCI);
    }
}
