package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.dto.MessageDto;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import com.jeniatyt.bot.service.queue.iface.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

import static com.jeniatyt.bot.config.KafkaConfig.REQUEST_START_STOP_BROKER_TOPIC;

@Service
@RequiredArgsConstructor
public class StartSearchingMessageHandlerImpl implements MessageHandler {
    public static final String KEY_SS = "ss";
    
    private final MessageSender sender;
    
    @Override
    public int getOrder() {
        return 2;
    }
    
    @Override
    public String getKey() {
        return KEY_SS;
    }
    
    @Override
    public String getDescription() {
        return "Начинает поиск компаний";
    }
    
    @Override
    public Optional<SendMessage> handle(Message message) {
        sender.send(
            new MessageDto(
                message.getText(),
                message.getChatId().toString(),
                message.getMessageId(),
                ""
            ),
            REQUEST_START_STOP_BROKER_TOPIC
        );
    
        return Optional.empty();
    }
}
