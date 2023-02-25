package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.component.button.ButtonUtils;
import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.jeniatyt.bot.service.component.button.impl.MonthCompanyInfoButton.MONTH_INFO_BUTTON;
import static com.jeniatyt.bot.service.component.button.impl.YearCompanyInfoButton.YEAR_INFO_BUTTON;

@Service
public class StartSearchingMessageHandlerImpl implements MessageHandler {
    public static final String KEY_SS = "ss";
    
    @Override
    public int getOrder() {
        return 2;
    }
    
    @Override
    public String getKey() {
        return KEY_SS;
    }
    
    @Override
    public String getDescription() {
        return "Начинает поиск компаний";
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText(getDescription());
        answer.setReplyMarkup(
            ButtonUtils.inlineMarkup(
                YEAR_INFO_BUTTON,
                MONTH_INFO_BUTTON
            )
        );
        return answer;
    }
}
