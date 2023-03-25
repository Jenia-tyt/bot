package com.jeniatyt.bot.service.handler.impl;

import com.jeniatyt.bot.component.button.ButtonUtils;
import com.jeniatyt.bot.component.button.impl.HelpButton;
import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.Comparator;
import java.util.Set;


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
    public void enrichAnswer(SendMessage answer) {
        answer.setText(getMassage());
        answer.setReplyMarkup(
            ButtonUtils.inlineMarkup(
                new HelpButton().get()
            )
        );
    }
    
    private String getMassage() {
        StringBuilder builder = new StringBuilder();
        handlers.stream()
            .filter(MessageHandler::isShowInHelp)
            .sorted(Comparator.comparing(MessageHandler::getOrder))
            .forEach(mh ->
                builder
                    .append("- ")
                    .append(mh.getKey())
                    .append("\t")
                    .append(">>")
                    .append("\t")
                    .append(mh.getDescription())
                    .append("\n\n")
            );
        return builder.toString();
    }
}
