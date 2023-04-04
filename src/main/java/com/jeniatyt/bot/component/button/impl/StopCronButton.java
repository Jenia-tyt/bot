package com.jeniatyt.bot.component.button.impl;

import com.jeniatyt.bot.component.button.iface.Button;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import static com.jeniatyt.bot.service.handler.impl.StopCronCheckCostMessageHandlerImpl.KEY_ESCC;

public class StopCronButton implements Button {
    private static final InlineKeyboardButton STOP_CRON_BUTTON = new InlineKeyboardButton("Остановить крон");
    
    public StopCronButton(String chatId, String secId) {
        STOP_CRON_BUTTON.setCallbackData(KEY_ESCC + " " + chatId + " " + secId);
    }
    
    @Override
    public InlineKeyboardButton get() {
        return STOP_CRON_BUTTON;
    }
}
