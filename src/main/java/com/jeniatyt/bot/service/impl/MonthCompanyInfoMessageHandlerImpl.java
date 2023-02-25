package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.component.button.ButtonUtils;
import com.jeniatyt.bot.service.iface.MessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.jeniatyt.bot.service.component.button.impl.DayCompanyInfoButton.DAY_INFO_BUTTON;
import static com.jeniatyt.bot.service.component.button.impl.WeekCompanyInfoButton.WEEK_INFO_BUTTON;

@Service
public class MonthCompanyInfoMessageHandlerImpl implements MessageHandler {
    public static final String KEY_MCI = "mci";
    
    @Override
    public int getOrder() {
        return 5;
    }
    
    @Override
    public String getKey() {
        return KEY_MCI;
    }
    
    @Override
    public String getDescription() {
        return "Информация по компании за месяц";
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText(getDescription());
        answer.setReplyMarkup(
            ButtonUtils.inlineMarkup(
                WEEK_INFO_BUTTON,
                DAY_INFO_BUTTON
            )
        );
        return answer;
    }
}
