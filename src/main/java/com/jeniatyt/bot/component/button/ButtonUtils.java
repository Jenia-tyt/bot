package com.jeniatyt.bot.component.button;

import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

@UtilityClass
public class ButtonUtils {
    
    public static InlineKeyboardMarkup inlineMarkup(InlineKeyboardButton... buttons) {
        List<InlineKeyboardButton> rowInline = List.of(buttons);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(List.of(rowInline));
        return markupInline;
    }
}
