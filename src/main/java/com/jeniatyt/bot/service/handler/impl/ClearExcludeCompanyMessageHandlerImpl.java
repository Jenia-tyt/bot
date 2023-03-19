package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.model.dto.MessageDto;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import com.jeniatyt.bot.service.queue.iface.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

import static com.jeniatyt.bot.config.KafkaConfig.REQUEST_CLEAR_ALL_EXCLUDE_COMPANIES;

@Service
@RequiredArgsConstructor
public class ClearExcludeCompanyMessageHandlerImpl implements MessageHandler {
    public static final String KEY_CEC = "cec";
    
    private final MessageSender sender;
    
    @Override
    public String getKey() {
        return KEY_CEC;
    }
    
    @Override
    public String getDescription() {
        return "Очистить список исключенных компаний";
    }
    
    @Override
    public int getOrder() {
        return 0;
    }
    
    @Override
    public Optional<SendMessage> handle(Message message, String[] arg) {
        sender.send(
            new MessageDto(
                KEY_CEC,
                message.getChatId().toString(),
                message.getMessageId(),
                ""
            ),
            REQUEST_CLEAR_ALL_EXCLUDE_COMPANIES
        );
        
        return Optional.empty();
    }
}
