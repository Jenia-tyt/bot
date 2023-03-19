package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.component.button.ButtonUtils;
import com.jeniatyt.bot.component.button.impl.HelpButton;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


@Service("defaultMessageHandlerImpl")
@RequiredArgsConstructor
public class DefaultMessageHandlerImpl implements MessageHandler {
    public static final String KEY_DEFAULT_HANDLER = "default";
    
    @Override
    public int getOrder() {
        return 0;
    }
    
    @Override
    public String getKey() {
        return KEY_DEFAULT_HANDLER;
    }
    
    @Override
    public String getDescription() {
        return "Обработчик команд которых нет";
    }
    
    @Override
    public boolean isShowInHelp() {
        return false;
    }
    
    @Override
    public void enrichAnswer(SendMessage answer) {
        answer.setReplyMarkup(ButtonUtils.inlineMarkup(new HelpButton().get()));
    }
}
