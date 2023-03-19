package com.jeniatyt.bot.service.queue.iface;

import com.jeniatyt.bot.model.dto.MessageDto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public interface TelegramAnswerSender {
    <M extends MessageDto> void send(M dto, String topic, InlineKeyboardButton... buttons);
}
