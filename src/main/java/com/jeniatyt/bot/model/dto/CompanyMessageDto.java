package com.jeniatyt.bot.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jeniatyt.bot.model.AnalyzeDistanceImpl;
import com.jeniatyt.bot.model.Company;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CompanyMessageDto extends MessageDto {
    @JsonProperty("company")
    private Company company;
    @JsonProperty("cost")
    private double[] cost;
    @JsonProperty("analyzeDistance")
    private AnalyzeDistanceImpl analyzeDistance;
}
