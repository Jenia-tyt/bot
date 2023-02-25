package com.jeniatyt.bot.service.queue.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeniatyt.bot.dto.MessageDto;
import com.jeniatyt.bot.service.queue.iface.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageSender implements MessageSender {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    
    @Override
    public void send(MessageDto dto, String topic) {
        try {
            String json = objectMapper.writeValueAsString(dto);
            kafkaTemplate.send(topic, json);
        } catch (JsonProcessingException e) {
            log.error("Ошибка записи в JSON", e);
        }
    }
}
