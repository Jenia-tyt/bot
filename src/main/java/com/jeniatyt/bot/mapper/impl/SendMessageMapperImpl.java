package com.jeniatyt.bot.mapper.impl;

import com.jeniatyt.bot.dto.MessageDto;
import com.jeniatyt.bot.mapper.iface.Mapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;

@Component
public class SendMessageMapperImpl implements Mapper<SendMessage, SendPhoto, MessageDto> {
    
    @Override
    public SendPhoto toFotoMessage(MessageDto dto) {
        SendPhoto message = new SendPhoto();
        message.setChatId(dto.getChatId());
        message.setReplyToMessageId(dto.getMessageId());
        message.setCaption(dto.getData());
        return message;
    }
    
    @Override
    public SendMessage toMessage(@NonNull MessageDto dto) {
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
