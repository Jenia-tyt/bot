
package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class EndEarningsCheckCostMessageHandlerImpl implements MessageHandler {
    public static final String KEY_EECC = "eecc";
    
    @Override
    public String getKey() {
        return KEY_EECC;
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText("""
            Останавливает крон,
            присылает итоговый заработок
            """);
        return answer;
    }
}
