package com.jeniatyt.bot;

import com.jeniatyt.bot.service.handler.iface.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static com.jeniatyt.bot.component.command.Commands.LIST_OF_COMMANDS;
import static com.jeniatyt.bot.service.handler.impl.DefaultMessageHandlerImpl.KEY_DEFAULT_HANDLER;


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
        this.defaultHandler = defaultHandler;
        this.handlersMap = handlers.stream()
            .collect(
                Collectors.toConcurrentMap(
                    MessageHandler::getKey,
                    e -> e
                )
            );
    
        //TODO добавить работу только с авторизованными пользователями
        try {
            this.execute(new SetMyCommands(LIST_OF_COMMANDS, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e){
            log.error(e.getMessage());
        }
    }
    
    @Override
    public void onUpdateReceived(Update update) {
        String[] command = parseCommand(update);
        MessageHandler handler = handlersMap.getOrDefault(command[0], defaultHandler);
        try {
            Message message;
           if (update.hasCallbackQuery()) {
               CallbackQuery callbackQuery = update.getCallbackQuery();
               AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery();
               answerCallbackQuery.setCallbackQueryId(callbackQuery.getId());
               execute(answerCallbackQuery);
               
               message = callbackQuery.getMessage();
           } else {
               message = update.getMessage();
           }
            
            Optional<SendMessage> answer = handler.handle(message,  Arrays.copyOfRange(command, 1, command.length));
            if (answer.isPresent()) {
                execute(answer.get());
            }
        } catch (TelegramApiException e) {
            log.error("Ошибка в обработчике", e);
        }
    }
    
    @Override
    public String getBotUsername() {
        return botName;
    }
    
    private String[] parseCommand(Update update) {
        return update.hasCallbackQuery() ?
            
            Optional.ofNullable(update.getCallbackQuery())
                .map(CallbackQuery::getData)
                .map(this::extract)
                .orElse(new String[] {KEY_DEFAULT_HANDLER}) :
            
            Optional.of(update.getMessage())
                .map(Message::getText)
                .map(String::toLowerCase)
                .map(this::extract)
                .orElse(new String[] {KEY_DEFAULT_HANDLER});
    }
    
    private String[] extract(String str) {
        String[] split = str.split(" ");
        split[0] = split[0].replace("/", "");
        for (int i = 0; i < split.length - 1; i++) {
            split[i] = split[i].trim();
        }
        return split;
    }
}
