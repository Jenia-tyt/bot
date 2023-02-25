package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.component.button.ButtonUtils;
import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.jeniatyt.bot.service.component.button.impl.HelpButton.HELP_BUTTON;

@Service
public class EndSearchingMessageHandlerImpl implements MessageHandler {
    public static final String KEY_ES = "es";
    
    @Override
    public int getOrder() {
        return 3;
    }
    
    @Override
    public String getKey() {
        return KEY_ES;
    }
    
    @Override
    public String getDescription() {
        return "Останавливает поиск компаний";
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText(getDescription());
        answer.setReplyMarkup(ButtonUtils.inlineMarkup(HELP_BUTTON));
        return answer;
    }
}
