package com.jeniatyt.bot.service.queue.listner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeniatyt.bot.dto.MessageDto;
import com.jeniatyt.bot.service.queue.iface.TelegramAnswerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.jeniatyt.bot.component.button.impl.EndSearchingButton.END_SEARCHING_BUTTON;
import static com.jeniatyt.bot.config.KafkaConfig.GROUP_ID;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_START_STOP_BROKER_TOPIC;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_STATISTIC_BROKER_TOPIC;


@Slf4j
@Service
@RequiredArgsConstructor
public class KListener {
    private final TelegramAnswerSender answerSender;
    private final ObjectMapper mapper;

    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_START_STOP_BROKER_TOPIC)
    public void startStopListener(String message) {
        try {
            MessageDto dto = mapper.readValue(message, MessageDto.class);
            answerSender.send(dto, RESPONSE_START_STOP_BROKER_TOPIC, END_SEARCHING_BUTTON);
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_START_STOP_BROKER_TOPIC, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_STATISTIC_BROKER_TOPIC)
    public void statisticListener(String message) {
        try {
            MessageDto dto = mapper.readValue(message, MessageDto.class);
            answerSender.send(dto, RESPONSE_STATISTIC_BROKER_TOPIC);
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_STATISTIC_BROKER_TOPIC, e);
        }
    }
}
