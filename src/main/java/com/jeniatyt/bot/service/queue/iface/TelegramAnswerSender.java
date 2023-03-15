package com.jeniatyt.bot.service.queue.iface;

import com.jeniatyt.bot.dto.MessageDto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public interface TelegramAnswerSender {
    void send(MessageDto dto, String topic, InlineKeyboardButton... buttons);
}
