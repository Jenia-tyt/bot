package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.model.dto.MessageDto;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import com.jeniatyt.bot.service.queue.iface.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

import static com.jeniatyt.bot.config.KafkaConfig.REQUEST_EXCLUDE_COMPANY_BROKER_TOPIC;

@Service
@RequiredArgsConstructor
public class ExcludeCompanyMessageHandlerImpl implements MessageHandler {
    public static final String KEY_EC = "ec";
    
    private final MessageSender sender;
    
    @Override
    public String getKey() {
        return KEY_EC;
    }
    
    @Override
    public Optional<SendMessage> handle(Message message, String[] arg) {
        sender.send(
            new MessageDto(
                KEY_EC,
                message.getChatId().toString(),
                message.getMessageId(),
                arg[0].toUpperCase()
            ),
            REQUEST_EXCLUDE_COMPANY_BROKER_TOPIC
        );
        
        return Optional.empty();
    }
    
    @Override
    public String getDescription() {
        return "Исключает компанию из поиска [команда SicId] НЕРЕАЛИЗОВАННО";
    }
    
    @Override
    public int getOrder() {
        return 0;
    }
}
