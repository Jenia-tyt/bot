package com.jeniatyt.bot.service.component.button.impl;

import com.jeniatyt.bot.service.component.button.iface.Button;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.impl.WeekCompanyInfoMessageHandlerImpl.KEY_WCI;

@Component
public class WeekCompanyInfoButton implements Button {
    public static final InlineKeyboardButton WEEK_INFO_BUTTON = new InlineKeyboardButton("Инф. за неделю");
    
    public WeekCompanyInfoButton() {
        WEEK_INFO_BUTTON.setCallbackData(KEY_WCI);
    }
}
