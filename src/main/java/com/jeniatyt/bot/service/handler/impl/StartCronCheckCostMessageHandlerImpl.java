package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.model.dto.MessageDto;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import com.jeniatyt.bot.service.queue.iface.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

import static com.jeniatyt.bot.config.KafkaConfig.REQUEST_START_CRON;

@Service
@RequiredArgsConstructor
public class StartCronCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_SSCC = "sscc";
    
    private final MessageSender sender;
    
    @Override
    public int getOrder() {
        return 9;
    }
    
    @Override
    public String getKey() {
        return KEY_SSCC;
    }
    
    @Override
    public String getDescription() {
        return """
            Запускаем крон который,
            присылает стоимость акций и дельту с покупки каждый час по будням, c 9 до 18
            [команда secId цена-покупки]
            """;
    }
    
    @Override
    public Optional<SendMessage> handle(Message message, String[] arg) {
        sender.send(
            new MessageDto(
                KEY_SSCC,
                message.getChatId().toString(),
                message.getMessageId(),
                getArguments(arg)
            ),
            REQUEST_START_CRON
        );
    
        return Optional.empty();
    }
}
