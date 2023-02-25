package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.EndSearchingMessageHandlerImpl.KEY_ES;

@Component
public class EndSearchingButton implements Button {
    public static final InlineKeyboardButton END_SEARCHING_BUTTON = new InlineKeyboardButton("Остановить поиск");
    
    public EndSearchingButton() {
        END_SEARCHING_BUTTON.setCallbackData(KEY_ES);
    }
}
