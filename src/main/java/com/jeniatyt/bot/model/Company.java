package com.jeniatyt.bot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Company implements Serializable {
    private String secId;
    private String name;
    private String regNumber;
    
    @Override
    public String toString() {
        return name == null
            ? "SecId " + secId
            : "Имя " + name + " SecId " + secId;
    }
}
