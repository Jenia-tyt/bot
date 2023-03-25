package com.jeniatyt.bot.model;

public enum SearchStep implements Step {
    HALF_YEAR {
        @Override
        public String getDistance() {
            return "Пол года";
        }
    },
    MONTH {
        @Override
        public String getDistance() {
            return "Месяц";
        }
    },
    WEEK {
        @Override
        public String getDistance() {
            return "Неделя";
        }
    },
    DAY {
        @Override
        public String getDistance() {
            return "День";
        }
    }
}
