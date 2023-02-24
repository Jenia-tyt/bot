package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.component.button.ButtonHelp;
import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;


@Service("defaultMessageHandlerImpl")
public class DefaultMessageHandlerImpl implements MessageHandler {
    public static final String KEY_DEFAULT_HANDLER = "default";
    
    @Override
    public String getKey() {
        return KEY_DEFAULT_HANDLER;
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText("Клоун такой команды нет");
        answer.setReplyMarkup(ButtonHelp.inlineMarkup());
        return answer;
    }
}
