package com.jeniatyt.bot.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class KafkaConfig {
    public static final String GROUP_ID = "FIRST";
    
    public static final String REQUEST_START_BROKER_TOPIC = "REQUEST_START_BROKER_TOPIC";
    public static final String REQUEST_EXCLUDE_COMPANY_BROKER_TOPIC = "REQUEST_EXCLUDE_COMPANY_BROKER_TOPIC";
    public static final String REQUEST_CLEAR_ALL_EXCLUDE_COMPANIES = "REQUEST_CLEAR_ALL_EXCLUDE_COMPANIES";
    public static final String REQUEST_ALL_EXCLUDE_COMPANIES = "REQUEST_ALL_EXCLUDE_COMPANIES";
    public static final String REQUEST_HALF_YEAR_ANALYSIS = "REQUEST_HALF_YEAR_ANALYSIS";
    public static final String REQUEST_MONTH_ANALYSIS = "REQUEST_MONTH_ANALYSIS";
    public static final String REQUEST_WEEK_ANALYSIS = "REQUEST_WEEK_ANALYSIS";
    public static final String REQUEST_DAY_ANALYSIS = "REQUEST_DAY_ANALYSIS";
    public static final String REQUEST_START_CRON = "REQUEST_START_CRON";
    public static final String REQUEST_STOP_CRON = "REQUEST_STOP_CRON";
    
    public static final String RESPONSE_CLEAR_ALL_EXCLUDE_COMPANIES = "RESPONSE_CLEAR_ALL_EXCLUDE_COMPANIES";
    public static final String RESPONSE_ALL_EXCLUDE_COMPANIES = "RESPONSE_ALL_EXCLUDE_COMPANIES";
    public static final String RESPONSE_START_BROKER_TOPIC = "RESPONSE_START_BROKER_TOPIC";
    public static final String RESPONSE_HALF_YEAR_ANALYSIS = "RESPONSE_HALF_YEAR_ANALYSIS";
    public static final String RESPONSE_MONTH_ANALYSIS = "RESPONSE_MONTH_ANALYSIS";
    public static final String RESPONSE_WEEK_ANALYSIS = "RESPONSE_WEEK_ANALYSIS";
    public static final String RESPONSE_DAY_ANALYSIS = "RESPONSE_DAY_ANALYSIS";
    public static final String RESPONSE_START_CRON = "RESPONSE_START_CRON";
    public static final String RESPONSE_STOP_CRON = "RESPONSE_STOP_CRON";
    public static final String RESPONSE_CRON = "RESPONSE_CRON";
    
    @Bean
    public NewTopic requestStartStopTopic() {
        return TopicBuilder
            .name(REQUEST_START_BROKER_TOPIC)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic requestExcludeTopic() {
        return TopicBuilder
            .name(REQUEST_EXCLUDE_COMPANY_BROKER_TOPIC)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic requestAllExcludeCompanies() {
        return TopicBuilder
            .name(REQUEST_ALL_EXCLUDE_COMPANIES)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic requestDeleteAllExcludeCompanies() {
        return TopicBuilder
            .name(REQUEST_CLEAR_ALL_EXCLUDE_COMPANIES)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic requestHalfYearAnalysis() {
        return TopicBuilder
            .name(REQUEST_HALF_YEAR_ANALYSIS)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic requestMonthAnalysis() {
        return TopicBuilder
            .name(REQUEST_MONTH_ANALYSIS)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic requestWeekAnalysis() {
        return TopicBuilder
            .name(REQUEST_WEEK_ANALYSIS)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic requestDayAnalysis() {
        return TopicBuilder
            .name(REQUEST_DAY_ANALYSIS)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic requestStatCron() {
        return TopicBuilder
            .name(REQUEST_START_CRON)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic requestEndCron() {
        return TopicBuilder
            .name(REQUEST_STOP_CRON)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
//    =====================================================================
    
    @Bean
    public NewTopic responseAllExcludeCompanies() {
        return TopicBuilder
            .name(RESPONSE_ALL_EXCLUDE_COMPANIES)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic responseStartStopTopic() {
        return TopicBuilder
            .name(RESPONSE_START_BROKER_TOPIC)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic responseClearAllExcludeCompanies() {
        return TopicBuilder
            .name(RESPONSE_CLEAR_ALL_EXCLUDE_COMPANIES)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic responseHalfYearAnalysis() {
        return TopicBuilder
            .name(RESPONSE_HALF_YEAR_ANALYSIS)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic responseMonthAnalysis() {
        return TopicBuilder
            .name(RESPONSE_MONTH_ANALYSIS)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic responseWeekAnalysis() {
        return TopicBuilder
            .name(RESPONSE_WEEK_ANALYSIS)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic responseDayAnalysis() {
        return TopicBuilder
            .name(RESPONSE_DAY_ANALYSIS)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic responseStatCron() {
        return TopicBuilder
            .name(RESPONSE_START_CRON)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic responseEndCron() {
        return TopicBuilder
            .name(RESPONSE_STOP_CRON)
            .partitions(1)
            .replicas(-1)
            .build();
    }
}
