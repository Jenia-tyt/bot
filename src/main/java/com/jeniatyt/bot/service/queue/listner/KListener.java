package com.jeniatyt.bot.service.queue.listner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeniatyt.bot.TelegramBotMessageHandler;
import com.jeniatyt.bot.component.button.ButtonUtils;
import com.jeniatyt.bot.dto.MessageDto;
import com.jeniatyt.bot.mapper.impl.SendMessageMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.jeniatyt.bot.component.button.impl.EndSearchingButton.END_SEARCHING_BUTTON;
import static com.jeniatyt.bot.config.KafkaConfig.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class KListener {
    private final TelegramBotMessageHandler messageHandler;
    private final SendMessageMapperImpl sendMessageMapper;
    private final ObjectMapper mapper;

    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_START_STOP_BROKER_TOPIC)
    public void startStopListener(String message) {
        try {
            MessageDto dto = mapper.readValue(message, MessageDto.class);
            SendMessage sendMessage = sendMessageMapper.to(dto);
            sendMessage.setReplyMarkup(ButtonUtils.inlineMarkup(END_SEARCHING_BUTTON));
            messageHandler.execute(sendMessage);
        } catch (TelegramApiException  | JsonProcessingException e) {
            log.error(RESPONSE_START_STOP_BROKER_TOPIC, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_STATISTIC_BROKER_TOPIC)
    public void statisticListener(String message) {
        try {
            MessageDto dto = mapper.readValue(message, MessageDto.class);
            messageHandler.execute(sendMessageMapper.to(dto));
        } catch (TelegramApiException  | JsonProcessingException e) {
            log.error(RESPONSE_STATISTIC_BROKER_TOPIC, e);
        }
    }
}
