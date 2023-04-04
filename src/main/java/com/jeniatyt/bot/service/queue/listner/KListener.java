package com.jeniatyt.bot.service.queue.listner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeniatyt.bot.component.button.iface.Button;
import com.jeniatyt.bot.component.button.impl.ClearAllExcludeCompaniesButton;
import com.jeniatyt.bot.component.button.impl.DayCompanyInfoButton;
import com.jeniatyt.bot.component.button.impl.ExcludeCompanyButton;
import com.jeniatyt.bot.component.button.impl.MonthCompanyInfoButton;
import com.jeniatyt.bot.component.button.impl.StopCronButton;
import com.jeniatyt.bot.component.button.impl.WeekCompanyInfoButton;
import com.jeniatyt.bot.model.dto.CompanyMessageDto;
import com.jeniatyt.bot.model.dto.MessageDto;
import com.jeniatyt.bot.service.queue.iface.TelegramAnswerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.function.Function;

import static com.jeniatyt.bot.config.KafkaConfig.GROUP_ID;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_ALL_EXCLUDE_COMPANIES;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_CLEAR_ALL_EXCLUDE_COMPANIES;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_CRON;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_DAY_ANALYSIS;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_HALF_YEAR_ANALYSIS;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_MONTH_ANALYSIS;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_START_BROKER_TOPIC;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_START_CRON;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_STOP_CRON;
import static com.jeniatyt.bot.config.KafkaConfig.RESPONSE_WEEK_ANALYSIS;


@Slf4j
@Service
@RequiredArgsConstructor
public class KListener {
    private final TelegramAnswerSender answerSender;
    private final ObjectMapper mapper;
    
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_START_BROKER_TOPIC)
    public void startStopListener(String message) {
        try {
            CompanyMessageDto response = mapper.readValue(message, CompanyMessageDto.class);
            String data = response.getCompany() != null
                ? "Найдена компания"
                : response.getData();
            
            companyProcess(
                response,
                data,
                RESPONSE_START_BROKER_TOPIC,
                ExcludeCompanyButton::new,
                MonthCompanyInfoButton::new
            );
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_START_BROKER_TOPIC, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_ALL_EXCLUDE_COMPANIES)
    public void allExcludeCompaniesListener(String message) {
        try {
            MessageDto dto = mapper.readValue(message, MessageDto.class);
            answerSender.send(
                dto,
                RESPONSE_ALL_EXCLUDE_COMPANIES,
                new ClearAllExcludeCompaniesButton().get()
            );
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_ALL_EXCLUDE_COMPANIES, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_START_CRON)
    public void startCronListener(String message) {
        try {
            MessageDto dto = mapper.readValue(message, MessageDto.class);
            answerSender.send(
                dto,
                RESPONSE_START_CRON,
                new StopCronButton(dto.getChatId(), getSecId(dto.getData())).get()
            );
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_START_CRON, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_STOP_CRON)
    public void endCronListener(String message) {
        try {
            MessageDto dto = mapper.readValue(message, MessageDto.class);
            answerSender.send(
                dto,
                RESPONSE_STOP_CRON,
                new ClearAllExcludeCompaniesButton().get()
            );
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_STOP_CRON, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_CLEAR_ALL_EXCLUDE_COMPANIES)
    public void clearAllExcludeCompaniesListener(String message) {
        try {
            MessageDto dto = mapper.readValue(message, MessageDto.class);
            answerSender.send(
                dto,
                RESPONSE_CLEAR_ALL_EXCLUDE_COMPANIES
            );
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_CLEAR_ALL_EXCLUDE_COMPANIES, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_HALF_YEAR_ANALYSIS)
    public void halfYearAnalysisListener(String message) {
        try {
            CompanyMessageDto response = mapper.readValue(message, CompanyMessageDto.class);
            companyProcess(
                response,
                "Статистика за года",
                RESPONSE_HALF_YEAR_ANALYSIS,
                ExcludeCompanyButton::new,
                MonthCompanyInfoButton::new
            );
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_HALF_YEAR_ANALYSIS, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_MONTH_ANALYSIS)
    public void monthAnalysisListener(String message) {
        try {
            CompanyMessageDto response = mapper.readValue(message, CompanyMessageDto.class);
            companyProcess(
                response,
                "Статистика за месяц",
                RESPONSE_MONTH_ANALYSIS,
                ExcludeCompanyButton::new,
                WeekCompanyInfoButton::new
            );
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_MONTH_ANALYSIS, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_WEEK_ANALYSIS)
    public void weekAnalysisListener(String message) {
        try {
            CompanyMessageDto response = mapper.readValue(message, CompanyMessageDto.class);
            companyProcess(
                response,
                "Статистика за неделю",
                RESPONSE_WEEK_ANALYSIS,
                ExcludeCompanyButton::new,
                DayCompanyInfoButton::new
            );
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_WEEK_ANALYSIS, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_DAY_ANALYSIS)
    public void dayAnalysisListener(String message) {
        try {
            CompanyMessageDto response = mapper.readValue(message, CompanyMessageDto.class);
            companyProcess(
                response,
                "Статистика за день",
                RESPONSE_DAY_ANALYSIS,
                ExcludeCompanyButton::new,
                null
            );
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_DAY_ANALYSIS, e);
        }
    }
    
    @KafkaListener(groupId = GROUP_ID, topics = RESPONSE_CRON)
    public void responseCronListener(String message) {
        try {
            CompanyMessageDto response = mapper.readValue(message, CompanyMessageDto.class);
            answerSender.send(
                response,
                RESPONSE_CLEAR_ALL_EXCLUDE_COMPANIES
            );
        } catch (JsonProcessingException e) {
            log.error(RESPONSE_DAY_ANALYSIS, e);
        }
    }
    
    private void companyProcess(
        CompanyMessageDto response,
        String data,
        String topic,
        Function<String, Button> exclude,
        Function<String, Button> next
    ) {
        if (response.getCompany() != null) {
            String secId = response.getCompany().getSecId();
            response.setData(data + " " + response.getCompany());
            if (next != null) {
                answerSender.send(
                    response,
                    topic,
                    exclude.apply(secId).get(),
                    next.apply(secId).get()
                );
            } else {
                answerSender.send(
                    response,
                    topic,
                    exclude.apply(secId).get()
                );
            }
        } else {
            answerSender.send(response, topic);
        }
    }
    
    private String getSecId(String data) {
        //TODO нужно реализовать
        return null;
    }
}
