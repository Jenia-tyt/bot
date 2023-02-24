package com.jeniatyt.bot.service.component.button;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ButtonHelp {
    private static final InlineKeyboardButton HELP_BUTTON = new InlineKeyboardButton("help");
    
    public static InlineKeyboardMarkup inlineMarkup() {
        HELP_BUTTON.setCallbackData("help");
        List<InlineKeyboardButton> rowInline = List.of(HELP_BUTTON);
        
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(List.of(rowInline));
        return markupInline;
    }
}
