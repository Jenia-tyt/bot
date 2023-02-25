package com.jeniatyt.bot.service.impl;

import com.jeniatyt.bot.service.component.button.ButtonUtils;
import com.jeniatyt.bot.service.iface.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Comparator;
import java.util.Set;

import static com.jeniatyt.bot.service.component.button.impl.HelpButton.HELP_BUTTON;


@Service
@RequiredArgsConstructor
public class HelpMessageHandlerImpl implements MessageHandler {
    public static final String KEY_HELP = "help";
    private final Set<MessageHandler> handlers;
    
    @Override
    public int getOrder() {
        return 14;
    }
    
    @Override
    public String getKey() {
        return KEY_HELP;
    }
    
    @Override
    public String getDescription() {
        return "Помощник";
    }
    
    @Override
    public SendMessage handle(Message message) {
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText(getMassage());
        answer.setReplyMarkup(
            ButtonUtils.inlineMarkup(
                HELP_BUTTON
            )
        );
        return answer;
    }
    
    private String getMassage() {
        StringBuilder builder = new StringBuilder();
        handlers.stream()
            .filter(MessageHandler::isShowInHelp)
            .sorted(Comparator.comparing(MessageHandler::getOrder))
            .forEach(mh -> builder.append("- ").append(mh.getKey()).append("  ->  ").append(mh.getDescription()).append("\n"));
        return builder.toString();
    }
}
