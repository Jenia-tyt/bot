package com.jeniatyt.bot.service.component.button.impl;

import com.jeniatyt.bot.service.component.button.iface.Button;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.impl.DayCompanyInfoMessageHandlerImpl.KEY_DCI;

@Component
public class DayCompanyInfoButton implements Button {
    public static final InlineKeyboardButton DAY_INFO_BUTTON = new InlineKeyboardButton("Инф. за день");
    
    public DayCompanyInfoButton() {
        DAY_INFO_BUTTON.setCallbackData(KEY_DCI);
    }
}
