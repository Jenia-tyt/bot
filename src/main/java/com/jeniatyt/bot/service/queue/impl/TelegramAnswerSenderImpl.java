package com.jeniatyt.bot.service.queue.impl;

import com.jeniatyt.bot.TelegramBotMessageHandler;
import com.jeniatyt.bot.component.button.ButtonUtils;
import com.jeniatyt.bot.mapper.impl.SendMessageMapperImpl;
import com.jeniatyt.bot.model.dto.CompanyMessageDto;
import com.jeniatyt.bot.model.dto.MessageDto;
import com.jeniatyt.bot.service.draw.iface.DrawService;
import com.jeniatyt.bot.service.queue.iface.TelegramAnswerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramAnswerSenderImpl implements TelegramAnswerSender {
    private final SendMessageMapperImpl sendMessageMapper;
    private final TelegramBotMessageHandler messageHandler;
    private final DrawService drawService;
    
    @Override
    public <M extends MessageDto> void send(M dto, String topic, InlineKeyboardButton... buttons) {
        try {
            if (hasChart(dto)) {
                Optional.of(dto)
                    .map(CompanyMessageDto.class::cast)
                    .ifPresent(company -> {
                        SendPhoto sendPhoto = sendMessageMapper.toFotoMessage(dto);
                        sendPhoto.setReplyMarkup(ButtonUtils.inlineMarkup(buttons));
                        try {
                            sendPhoto.setPhoto(drawService.draw(company));
                            messageHandler.execute(sendPhoto);
                        } catch (TelegramApiException | IOException e) {
                            log.error(topic, e);
                        }
                    });
            } else {
                SendMessage sendMessage = sendMessageMapper.toMessage(dto);
                sendMessage.setReplyMarkup(ButtonUtils.inlineMarkup(buttons));
                messageHandler.execute(sendMessage);
            }
        } catch (TelegramApiException e) {
            log.error(topic, e);
        }
    }
    
    private <M extends MessageDto> boolean hasChart(M dto) {
        return dto instanceof CompanyMessageDto companyMessageDto
            && companyMessageDto.getCompany() != null
            && companyMessageDto.getCost().length > 0;
    }
}
