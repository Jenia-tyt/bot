package com.jeniatyt.bot.service.component.command;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

import static com.jeniatyt.bot.service.impl.AllHistoryMessageHandlerImpl.KEY_AH;
import static com.jeniatyt.bot.service.impl.DayHistoryMessageHandlerImpl.KEY_DH;
import static com.jeniatyt.bot.service.impl.HelpMessageHandlerImpl.KEY_HELP;
import static com.jeniatyt.bot.service.impl.StatisticsMessageHandlerImpl.KEY_S;

public interface Commands {
    List<BotCommand> LIST_OF_COMMANDS = List.of(
        new BotCommand(KEY_S, "statistic"),
        new BotCommand(KEY_DH, "day history"),
        new BotCommand(KEY_AH, "all history"),
        new BotCommand(KEY_HELP, "help")
    );
}