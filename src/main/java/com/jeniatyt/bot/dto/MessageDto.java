package com.jeniatyt.bot.dto;

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
    private double[] chartPoints;
    private int messageId;
    private String data;
}
