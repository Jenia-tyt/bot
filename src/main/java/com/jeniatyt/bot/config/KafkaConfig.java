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
    public static final String REQUEST_STATISTIC_BROKER_TOPIC = "REQUEST_STATISTIC_BROKER_TOPIC";
    public static final String REQUEST_EXCLUDE_COMPANY_BROKER_TOPIC = "REQUEST_EXCLUDE_COMPANY_BROKER_TOPIC";
    
    public static final String RESPONSE_START_BROKER_TOPIC = "RESPONSE_START_BROKER_TOPIC";
    public static final String RESPONSE_STATISTIC_BROKER_TOPIC = "RESPONSE_STATISTIC_BROKER_TOPIC";
    
    @Bean
    public NewTopic requestStartStopTopic() {
        return TopicBuilder
            .name(REQUEST_START_BROKER_TOPIC)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic requestStatisticTopic() {
        return TopicBuilder
            .name(REQUEST_STATISTIC_BROKER_TOPIC)
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
    public NewTopic responseStartStopTopic() {
        return TopicBuilder
            .name(RESPONSE_START_BROKER_TOPIC)
            .partitions(1)
            .replicas(-1)
            .build();
    }
    
    @Bean
    public NewTopic responseStatisticTopic() {
        return TopicBuilder
            .name(RESPONSE_STATISTIC_BROKER_TOPIC)
            .partitions(1)
            .replicas(-1)
            .build();
    }
}
