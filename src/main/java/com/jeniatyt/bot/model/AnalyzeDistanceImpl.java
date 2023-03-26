package com.jeniatyt.bot.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public enum AnalyzeDistanceImpl implements AnalyzeDistance, Serializable {
    HALF_YEAR(24, "Пол года", "Неделя"),
    MONTH(4, "Месяц", "Неделя"),
    WEEK(7, "Неделя", "День"),
    DAY(24, "День", "Час");
    
    private final int periodDistance;
    private final String nameDistance;
    private final String dimension;
    
    
    @Override
    public String getDescription() {
        return getNameDistance() + ", " + getDimension();
    }
}
