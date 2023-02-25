package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.component.button.ButtonUtils;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

import static com.jeniatyt.bot.component.button.impl.MonthCompanyInfoButton.MONTH_INFO_BUTTON;
import static com.jeniatyt.bot.component.button.impl.WeekCompanyInfoButton.WEEK_INFO_BUTTON;

@Service
public class YearCompanyInfoMessageHandlerImpl implements MessageHandler {
    public static final String KEY_YCI = "yci";
    
    @Override
    public int getOrder() {
        return 4;
    }
    
    @Override
    public String getKey() {
        return KEY_YCI;
    }
    
    @Override
    public String getDescription() {
        return "Информация по компании за год";
    }
    
    @Override
    public Optional<SendMessage> handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setReplyToMessageId(message.getMessageId());
        answer.setChatId(message.getChatId());
        answer.setText(getDescription());
        answer.setReplyMarkup(
            ButtonUtils.inlineMarkup(
                MONTH_INFO_BUTTON,
                WEEK_INFO_BUTTON
            )
        );
        return Optional.of(answer);
    }
}
