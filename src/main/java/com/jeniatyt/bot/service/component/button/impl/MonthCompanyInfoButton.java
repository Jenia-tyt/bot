package com.jeniatyt.bot.service.component.button.impl;

import com.jeniatyt.bot.service.component.button.iface.Button;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.impl.MonthCompanyInfoMessageHandlerImpl.KEY_MCI;

@Component
public class MonthCompanyInfoButton implements Button {
    public static final InlineKeyboardButton MONTH_INFO_BUTTON = new InlineKeyboardButton("Инф. за месяц");
    
    public MonthCompanyInfoButton() {
        MONTH_INFO_BUTTON.setCallbackData(KEY_MCI);
    }
}
