package com.jeniatyt.bot.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public enum AnalyzeDistanceImpl implements Serializable {
    HALF_YEAR(24, 7, "Пол года", "Неделя"),
    MONTH(4, 7,"Месяц", "Неделя"),
    WEEK(7, 24, "Неделя", "День"),
    DAY(24, 60, "День", "Час");
    
    private final int size;
    private final int interval;
    private final String nameDistance;
    private final String dimension;
    
    public String getDescription() {
        return getNameDistance() + ", " + getDimension();
    }
}
