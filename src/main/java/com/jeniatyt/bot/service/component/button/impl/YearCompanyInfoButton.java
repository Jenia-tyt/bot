package com.jeniatyt.bot.service.component.button.impl;

import com.jeniatyt.bot.service.component.button.iface.Button;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.impl.YearCompanyInfoMessageHandlerImpl.KEY_YCI;

@Component
public class YearCompanyInfoButton implements Button {
    public static final InlineKeyboardButton YEAR_INFO_BUTTON = new InlineKeyboardButton("Инф. за год");
    private static final String DATA = KEY_YCI;
    
    public YearCompanyInfoButton() {
        YEAR_INFO_BUTTON.setCallbackData(DATA);
    }
}
