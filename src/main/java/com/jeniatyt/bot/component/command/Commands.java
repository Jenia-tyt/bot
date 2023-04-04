package com.jeniatyt.bot.component.command;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

import static com.jeniatyt.bot.service.handler.impl.AllExcludeCompanyMessageHandlerImpl.KEY_AEC;
import static com.jeniatyt.bot.service.handler.impl.HelpMessageHandlerImpl.KEY_HELP;
import static com.jeniatyt.bot.service.handler.impl.StartSearchingMessageHandlerImpl.KEY_SS;

public interface Commands {
    List<BotCommand> LIST_OF_COMMANDS = List.of(
        new BotCommand(KEY_HELP, "Справочник"),
        new BotCommand(KEY_SS, "Начать поиск компании"),
        new BotCommand(KEY_AEC, "Исключенные компании из поиска")
    );
}