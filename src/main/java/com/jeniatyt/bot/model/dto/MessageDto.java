package com.jeniatyt.bot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto implements Serializable {
    private String handelKey;
    private String chatId;
    private int messageId;
    private String data;
}
