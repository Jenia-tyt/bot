package com.jeniatyt.bot.service.queue.impl;

import com.jeniatyt.bot.TelegramBotMessageHandler;
import com.jeniatyt.bot.component.button.ButtonUtils;
import com.jeniatyt.bot.mapper.impl.SendMessageMapperImpl;
import com.jeniatyt.bot.model.dto.MessageDto;
import com.jeniatyt.bot.service.queue.iface.TelegramAnswerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramAnswerSenderImpl implements TelegramAnswerSender {
    private final SendMessageMapperImpl sendMessageMapper;
    private final TelegramBotMessageHandler messageHandler;
    
    @Override
    public <M extends MessageDto> void send(M dto, String topic, InlineKeyboardButton... buttons) {
        try {
//            if (dto.getChartPoints().length == 0) {
                
                
                SendMessage sendMessage = sendMessageMapper.toMessage(dto);
                sendMessage.setReplyMarkup(ButtonUtils.inlineMarkup(buttons));
                messageHandler.execute(sendMessage);
                
                
//            } else {
//                SendPhoto sendPhoto = sendMessageMapper.toFotoMessage(dto);
//                sendPhoto.setReplyMarkup(ButtonUtils.inlineMarkup(buttons));
//                messageHandler.execute(sendPhoto);
//            }
        } catch (TelegramApiException e) {
            log.error(topic, e);
        }
    }
}
