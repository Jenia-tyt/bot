package com.jeniatyt.bot.service.component.command;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

import static com.jeniatyt.bot.service.impl.EndScheduleCheckCostMessageHandlerImpl.KEY_ESCC;
import static com.jeniatyt.bot.service.impl.EndSearchingMessageHandlerImpl.KEY_ES;
import static com.jeniatyt.bot.service.impl.HelpMessageHandlerImpl.KEY_HELP;
import static com.jeniatyt.bot.service.impl.StartSearchingMessageHandlerImpl.KEY_SS;
import static com.jeniatyt.bot.service.impl.StatisticsMessageHandlerImpl.KEY_S;

public interface Commands {
    List<BotCommand> LIST_OF_COMMANDS = List.of(
        new BotCommand(KEY_HELP, "Справочник"),
        new BotCommand(KEY_S, "Полная статистика"),
        new BotCommand(KEY_SS, "Начать поиск компании"),
        new BotCommand(KEY_ES, "Закончить поиск компании"),
        new BotCommand(KEY_ESCC, "Закончить мониторить сделку")
    );
}