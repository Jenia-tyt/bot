package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.HelpMessageHandlerImpl.KEY_HELP;

public class HelpButton implements Button {
    private static final InlineKeyboardButton HELP_BUTTON = new InlineKeyboardButton("help");
    
    public HelpButton() {
        HELP_BUTTON.setCallbackData(KEY_HELP);
    }
    
    @Override
    public InlineKeyboardButton get() {
        return HELP_BUTTON;
    }
}
