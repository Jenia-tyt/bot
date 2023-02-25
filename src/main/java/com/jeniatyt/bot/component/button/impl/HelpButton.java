package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.HelpMessageHandlerImpl.KEY_HELP;

@Component
public class HelpButton implements Button {
    public static final InlineKeyboardButton HELP_BUTTON = new InlineKeyboardButton("help");
    
    public HelpButton() {
        HELP_BUTTON.setCallbackData(KEY_HELP);
    }
}
