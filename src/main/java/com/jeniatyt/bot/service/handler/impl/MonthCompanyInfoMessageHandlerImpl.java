package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.model.dto.MessageDto;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import com.jeniatyt.bot.service.queue.iface.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

import static com.jeniatyt.bot.config.KafkaConfig.REQUEST_MONTH_ANALYSIS;

@Service
@RequiredArgsConstructor
public class MonthCompanyInfoMessageHandlerImpl implements MessageHandler {
    public static final String KEY_MCI = "mci";
    
    private final MessageSender sender;
    
    @Override
    public int getOrder() {
        return 5;
    }
    
    @Override
    public String getKey() {
        return KEY_MCI;
    }
    
    @Override
    public String getDescription() {
        return "Информация по компании за месяц [команда sicId]";
    }
    
    @Override
    public Optional<SendMessage> handle(Message message, String[] arg) {
        sender.send(
            new MessageDto(
                KEY_MCI,
                message.getChatId().toString(),
                message.getMessageId(),
                arg[0].toUpperCase()
            ),
            REQUEST_MONTH_ANALYSIS
        );
    
        return Optional.empty();
    }
}
