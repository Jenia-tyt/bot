package com.jeniatyt.bot.service.component.button.impl;

import com.jeniatyt.bot.service.component.button.iface.Button;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.impl.DayCompanyInfoMessageHandlerImpl.KEY_DCI;

@Component
public class DayCompanyInfoButton implements Button {
    public static final InlineKeyboardButton DAY_INFO_BUTTON = new InlineKeyboardButton("Инф. за день");
    private static final String DATA = KEY_DCI;
    
    public DayCompanyInfoButton() {
        DAY_INFO_BUTTON.setCallbackData(DATA);
    }
}
