package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.model.dto.MessageDto;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import com.jeniatyt.bot.service.queue.iface.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

import static com.jeniatyt.bot.config.KafkaConfig.REQUEST_HALF_YEAR_ANALYSIS;

@Service
@RequiredArgsConstructor
public class HalfYearCompanyInfoMessageHandlerImpl implements MessageHandler {
    public static final String KEY_HYCI = "hyci";
    
    private final MessageSender sender;
    
    @Override
    public int getOrder() {
        return 4;
    }
    
    @Override
    public String getKey() {
        return KEY_HYCI;
    }
    
    @Override
    public String getDescription() {
        return "Информация по компании за пол год [команда sicId]";
    }
    
    @Override
    public Optional<SendMessage> handle(Message message, String[] arg) {
        sender.send(
            new MessageDto(
                KEY_HYCI,
                message.getChatId().toString(),
                message.getMessageId(),
                arg[0].toUpperCase()
            ),
            REQUEST_HALF_YEAR_ANALYSIS
        );
    
        return Optional.empty();
    }
}
