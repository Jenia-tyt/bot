package com.jeniatyt.bot.service.queue.iface;

import com.jeniatyt.bot.dto.MessageDto;

public interface MessageSender {
    void send(MessageDto value, String topic);
}
