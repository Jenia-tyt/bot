package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.component.button.ButtonHelp;
import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;


@Service
public class HelpMessageHandlerImpl implements MessageHandler {
    public static final String KEY_HELP = "help";
    
    @Override
    public String getKey() {
        return KEY_HELP;
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText("""
            Клоун такой команды нет, вот тебе описание:
            - s     ->  statistic
            - i     ->  init balance
            - as    ->  add statistic (компания, заработок)
            - dh    ->  day history
            - ah    ->  all history
            - cc    ->  company cost (название компании)
            - sscc  ->  start schedule check cost (название компании, интервал времени, количество раз, нижний порог просадки)
            - escc  ->  end schedule check cost (название компании)
            - secc  ->  start earnings schedule check cost (название компании, по чем купил)
            - eecc  ->  end earnings schedule check cost (название компании)
            """);
        answer.setReplyMarkup(ButtonHelp.inlineMarkup());
        return answer;
    }
}
