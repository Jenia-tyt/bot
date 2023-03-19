package com.jeniatyt.bot.service.queue.iface;

import com.jeniatyt.bot.model.dto.MessageDto;

public interface MessageSender {
    void send(MessageDto value, String topic);
}
