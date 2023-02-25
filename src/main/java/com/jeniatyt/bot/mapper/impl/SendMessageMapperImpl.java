package com.jeniatyt.bot.mapper.impl;

import com.jeniatyt.bot.dto.MessageDto;
import com.jeniatyt.bot.mapper.iface.Mapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class SendMessageMapperImpl implements Mapper<SendMessage, MessageDto> {
    
    @Override
    public SendMessage to(@NonNull MessageDto dto) {
        SendMessage message = new SendMessage();
        message.setReplyToMessageId(dto.getMessageId());
        message.setText(dto.getData());
        message.setChatId(dto.getChatId());
        return message;
    }
    
    @Override
    public MessageDto from(@NonNull SendMessage target) {
        MessageDto dto = new MessageDto();
        dto.setMessageId(target.getReplyToMessageId());
        dto.setData(target.getText());
        dto.setChatId(target.getChatId());
        return dto;
    }
}
