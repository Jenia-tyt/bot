package com.jeniatyt.bot;

import com.jeniatyt.bot.service.iface.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static com.jeniatyt.bot.service.component.command.Commands.LIST_OF_COMMANDS;
import static com.jeniatyt.bot.service.impl.DefaultMessageHandlerImpl.KEY_DEFAULT_HANDLER;


@Slf4j
@Service
public class TelegramBotMessageHandler extends TelegramLongPollingBot {
    private final String botName;
    private final ConcurrentMap<String, MessageHandler> handlersMap;
    private final MessageHandler defaultHandler;
    
    public TelegramBotMessageHandler(
        @Value("${bot.name}")String botName,
        @Value("${bot.token}")String token,
        Set<MessageHandler> handlers,
        @Qualifier("defaultMessageHandlerImpl") MessageHandler defaultHandler
    ) {
        super(token);
        this.botName = botName;
        handlersMap = handlers.stream()
            .collect(
                Collectors.toConcurrentMap(
                    MessageHandler::getKey,
                    e -> e
                )
            );
        this.defaultHandler = defaultHandler;
    
        //TODO добавить работу только с авторизованными пользователями
        try {
            this.execute(new SetMyCommands(LIST_OF_COMMANDS, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e){
            log.error(e.getMessage());
        }
    }
    
    @Override
    public void onUpdateReceived(Update update) {
        MessageHandler handler = handlersMap.getOrDefault(getKey(update), defaultHandler);
        try {
            if (update.hasCallbackQuery()) {
                execute(handler.handle(update.getCallbackQuery().getMessage()));
            } else {
                execute(handler.handle(update.getMessage()));
            }
        } catch (TelegramApiException e) {
            log.error("Ошибка в обработчике", e);
        }
    }
    
    @Override
    public String getBotUsername() {
        return botName;
    }
    
    private String getKey(Update update) {
        return update.hasCallbackQuery() ?
            
            Optional.ofNullable(update.getCallbackQuery())
                .map(CallbackQuery::getData)
                .map(this::extract)
                .orElse(KEY_DEFAULT_HANDLER) :
            
            Optional.of(update.getMessage())
                .map(Message::getText)
                .map(String::toLowerCase)
                .map(this::extract)
                .orElse(KEY_DEFAULT_HANDLER);
    }
    
    private String extract(String str) {
        return str.split(" ")[0].replace("/", "");
    }
}
